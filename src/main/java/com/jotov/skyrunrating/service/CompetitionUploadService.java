package com.jotov.skyrunrating.service;

import com.jotov.skyrunrating.entity.Competition;
import com.jotov.skyrunrating.model.CompetitionImportModel;
import com.jotov.skyrunrating.model.RunnerResultImportModel;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static com.jotov.skyrunrating.SkyrunratingApplication.parseStringToDuration;

@Service
public class CompetitionUploadService {
    @Autowired
    private CompetitionService competitionService;

    public enum CSV_PART { COMPETITION_HEAD, COMPETITION_DATA, RUNNERS_HEAD, RUNNERS_DATA }
    public enum TYPES { STRING, INT, DATE,TIME }

    // TODO - to move them to resources
    private static final String[] competitionHead = {"Название","Дистанция","Набор","Количество баллов","Рекорд","Дата"};
    private static final TYPES[] competitionData = {TYPES.STRING, TYPES.INT, TYPES.INT, TYPES.INT, TYPES.TIME, TYPES.DATE};
    private static final String[] runnersHead = {"Место","ФИО","Время","Пол","Город","Клуб"};
    private static final TYPES[] runnersData = {TYPES.INT, TYPES.STRING, TYPES.TIME, TYPES.STRING, TYPES.STRING, TYPES.STRING};
    private static final int competitionColumnsNumber = competitionHead.length;
    private static final int runnerColumnsNumber = runnersHead.length;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH.mm.ss");
    private static final String UPLOAD_FOLDER = "D://tmp//";

    private long createCompetition(String[] line) {
        //TODO - create competition and return its ID
        Competition competition = new Competition();
        competition.setName(line[0]);
        competition.setMeterDistance(Integer.parseInt(line[1]));
        competition.setMeterDisplacement(Integer.parseInt(line[2]));
        competition.setMaxPoints(Integer.parseInt(line[3]));
        competition.setSecondsRecord(Integer.parseInt(line[4]));
        try {
            competition.setDate(dateFormat.parse(line[5]));
        } catch (ParseException e) {competition.setDate(new Date());}

        competitionService.createCompetition(competition);
        return competition.getId();
    }

    private void createRunnerAndResult(long competitionId, String[] line) {
//        RunnerResultImportModel runnerResult = new RunnerResultImportModel();
//        runnerResult.setPosition(Integer.parseInt(line[0]));
//        runnerResult.setName(line[1]);
//        runnerResult.setResultSeconds(line[2]);
//        runnerResult.setSex(line[3]);
//        runnerResult.setCity(line[4]);
//        runnerResult.setTeam(line[5]);

        // TODO - check for Runner and load if exists
        // runnerService

        // TODO create result and attach to the runner
        // resultService
    }

    public CompetitionImportModel validateImport(MultipartFile competitionFile) throws IOException, CompetitionCSVFormatException{
        File cf = new File(UPLOAD_FOLDER+competitionFile.getOriginalFilename());
//        try{
        competitionFile.transferTo(cf);
        return validateImport(new FileReader(cf));
//        } catch (Exception ex) {
//            ex.getMessage();
//            System.out.println("Validation error");
//            return null;
//        }
    }

    private CompetitionImportModel validateImport(FileReader fileReader) throws IOException, CompetitionCSVFormatException {
        CompetitionImportModel model = new CompetitionImportModel();
        CSVReader csvReader = new CSVReader(fileReader);
        CSV_PART mode = CSV_PART.COMPETITION_HEAD; // 0 - competition header, 1 - competition data, 2 - competitors header, 3 - competitors data
        String [] nextLine;
        while ((nextLine = csvReader.readNext()) != null) {
            switch (mode) {
                case COMPETITION_HEAD:  {
                    if(nextLine.length != competitionColumnsNumber) throw new CompetitionCSVFormatException(CompetitionCSVFormatException.FORMAT_ERROR.COMPETITION_HEADER_MISSING_COLUMNS, csvReader.getLinesRead());
                    if(hasIncorrectHeadColumnOrder(nextLine, competitionHead)) throw new CompetitionCSVFormatException(CompetitionCSVFormatException.FORMAT_ERROR.COMPETITION_HEADER_WRONG_COLUMN_ORDER, csvReader.getLinesRead());

                    mode = CSV_PART.COMPETITION_DATA;
                    break;
                }
                case COMPETITION_DATA: {
                    if(nextLine.length != competitionColumnsNumber) throw new CompetitionCSVFormatException(CompetitionCSVFormatException.FORMAT_ERROR.COMPETITION_DATA_MISSING_COLUMNS, csvReader.getLinesRead());
                    if(hasIncorrectDataFormat(nextLine,competitionData)) throw new CompetitionCSVFormatException(CompetitionCSVFormatException.FORMAT_ERROR.COMPETITION_DATA_WRONG_COLUMN_FORMAT, csvReader.getLinesRead());
                    setCompetitionData(model, nextLine);
                    mode = CSV_PART.RUNNERS_HEAD;
                    break;
                }
                case RUNNERS_HEAD: {
                    if(nextLine.length != runnerColumnsNumber) throw new CompetitionCSVFormatException(CompetitionCSVFormatException.FORMAT_ERROR.RUNNER_HEADER_MISSING_COLUMNS, csvReader.getLinesRead());
                    if(hasIncorrectHeadColumnOrder(nextLine, runnersHead)) throw new CompetitionCSVFormatException(CompetitionCSVFormatException.FORMAT_ERROR.RUNNER_HEADER_WRONG_COLUMN_ORDER, csvReader.getLinesRead());


                    mode = CSV_PART.RUNNERS_DATA;
                    break;
                }
                case RUNNERS_DATA: {
                    if(nextLine.length != runnerColumnsNumber) throw new CompetitionCSVFormatException(CompetitionCSVFormatException.FORMAT_ERROR.RUNNER_DATA_MISSING_COLUMNS, csvReader.getLinesRead());
                    if(hasIncorrectDataFormat(nextLine,runnersData)) throw new CompetitionCSVFormatException(CompetitionCSVFormatException.FORMAT_ERROR.RUNNER_DATA_WRONG_COLUMN_FORMAT, csvReader.getLinesRead());
                    setRunnerResultData(model, nextLine);
                    break;
                }
                default: break;
            }

        }
        return model;
    }

    public CompetitionImportModel performImport(MultipartFile competitionFile) throws IOException, CompetitionCSVFormatException {
        File cf = new File(UPLOAD_FOLDER+competitionFile.getOriginalFilename());
        competitionFile.transferTo(cf);
        CompetitionImportModel model = new CompetitionImportModel();
        CSVReader csvReader = new CSVReader(new FileReader(cf));
        CSV_PART mode = CSV_PART.COMPETITION_HEAD; // 0 - competition header, 1 - competition data, 2 - competitors header, 3 - competitors data
        String [] nextLine;
        // TODO: to refactor the code
        long competitionId = 0;

        while ((nextLine = csvReader.readNext()) != null) {
            switch (mode) {
                case COMPETITION_HEAD:  {
//                    if(nextLine.length != competitionColumnsNumber) throw new CompetitionCSVFormatException(CompetitionCSVFormatException.FORMAT_ERROR.COMPETITION_HEADER_MISSING_COLUMNS, csvReader.getLinesRead());
//                    if(hasIncorrectHeadColumnOrder(nextLine, competitionHead)) throw new CompetitionCSVFormatException(CompetitionCSVFormatException.FORMAT_ERROR.COMPETITION_HEADER_WRONG_COLUMN_ORDER, csvReader.getLinesRead());

                    mode = CSV_PART.COMPETITION_DATA;
                    break;
                }
                case COMPETITION_DATA: {
//                    if(nextLine.length != competitionColumnsNumber) throw new CompetitionCSVFormatException(CompetitionCSVFormatException.FORMAT_ERROR.COMPETITION_DATA_MISSING_COLUMNS, csvReader.getLinesRead());
//                    if(hasIncorrectDataFormat(nextLine,competitionData)) throw new CompetitionCSVFormatException(CompetitionCSVFormatException.FORMAT_ERROR.COMPETITION_DATA_WRONG_COLUMN_FORMAT, csvReader.getLinesRead());
                    //setCompetitionData(model, nextLine);
                    competitionId = createCompetition(nextLine);
                    mode = CSV_PART.RUNNERS_HEAD;
                    break;
                }
                case RUNNERS_HEAD: {
//                    if(nextLine.length != runnerColumnsNumber) throw new CompetitionCSVFormatException(CompetitionCSVFormatException.FORMAT_ERROR.RUNNER_HEADER_MISSING_COLUMNS, csvReader.getLinesRead());
//                    if(hasIncorrectHeadColumnOrder(nextLine, runnersHead)) throw new CompetitionCSVFormatException(CompetitionCSVFormatException.FORMAT_ERROR.RUNNER_HEADER_WRONG_COLUMN_ORDER, csvReader.getLinesRead());


                    mode = CSV_PART.RUNNERS_DATA;
                    break;
                }
                case RUNNERS_DATA: {
//                    if(nextLine.length != runnerColumnsNumber) throw new CompetitionCSVFormatException(CompetitionCSVFormatException.FORMAT_ERROR.RUNNER_DATA_MISSING_COLUMNS, csvReader.getLinesRead());
//                    if(hasIncorrectDataFormat(nextLine,runnersData)) throw new CompetitionCSVFormatException(CompetitionCSVFormatException.FORMAT_ERROR.RUNNER_DATA_WRONG_COLUMN_FORMAT, csvReader.getLinesRead());
                    //setRunnerResultData(model, nextLine);
                    createRunnerAndResult(competitionId, nextLine);
                    break;
                }
                default: break;
            }

        }

        return null;
    }

    private boolean hasIncorrectHeadColumnOrder(String[] line, String[] spec) {
        boolean result = true;
        for(int i = 0; i < spec.length; i++) {
            result = result && line[i].equals(spec[i]);
        }
        return !result;
    }

    private boolean hasIncorrectDataFormat(String[] line, TYPES[] spec) {
        int ii;
        Date date;
        Duration duration;
        for(int i = 0; i < spec.length; i++) {
            switch(spec[i]) {
                case STRING : break;
                case INT : {
                    try {
                        ii = Integer.parseInt(line[i]);
                    } catch (Exception ex) {return true;}
                    break;
                }
                case DATE : {
                    try {
                        date = dateFormat.parse(line[i]);
                    } catch (Exception e) {return true;}
                    break;
                }
                case TIME : {
                    try {
                        duration = parseStringToDuration(line[i]);
                    } catch (Exception e) {return true;}
                    break;
                }
            }
        }
        return false;
    }

    private void setCompetitionData(CompetitionImportModel model, String [] line) {
        //TODO  -to remove hardcoded indexes
        model.setName(line[0]);
        model.setMeterDistance(Integer.parseInt(line[1]));
        model.setMeterDisplacement(Integer.parseInt(line[2]));
        model.setMaxPoints(Integer.parseInt(line[3]));
        model.setSecondsRecord(line[4]);
        try {
            model.setDate(dateFormat.parse(line[5]));
        } catch (ParseException e) {model.setDate(new Date());}
    }

    private void setRunnerResultData(CompetitionImportModel model, String[] line) {
        //TODO  -to remove hardcoded indexes
        RunnerResultImportModel runnerResult = new RunnerResultImportModel();
        runnerResult.setPosition(Integer.parseInt(line[0]));
        runnerResult.setName(line[1]);
        runnerResult.setResultSeconds(line[2]);
        runnerResult.setSex(line[3]);
        runnerResult.setCity(line[4]);
        runnerResult.setTeam(line[5]);

        model.addRunnerResults(runnerResult);
    }
}
