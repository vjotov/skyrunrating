package com.jotov.skyrunrating.competition;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CompetitionService {


    public enum CSV_PART { COMPETITION_HEAD, COMPETITION_DATA, RUNNERS_HEAD, RUNNERS_DATA }
    public enum TYPES { STRING, INT, DATE,TIME }

    // TODO - to move them to resources
    private static final String[] competitionHead = {"Название","Дистанция","Набор","Количество баллов","Рекорд","Дата"};
    private static final TYPES[] competitionData = {TYPES.STRING, TYPES.INT, TYPES.INT, TYPES.INT, TYPES.TIME, TYPES.DATE};
    private static final String[] runnersHead = {"Место","ФИО","Время","Пол","Группа","Клуб"};
    private static final TYPES[] runnersData = {TYPES.INT, TYPES.STRING, TYPES.TIME, TYPES.STRING, TYPES.STRING, TYPES.STRING};
    private static final int competitionColumnsNumber = competitionHead.length;
    private static final int runnerColumnsNumber = runnersHead.length;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH.mm.ss");
    private static final String UPLOAD_FOLDER = "D://tmp//";

    @Autowired
    private CompetiotionRepository competiotionRepository;

    public List<Competition> getAllCompetitions() {
        List<Competition> competitions = new ArrayList<>();
        competiotionRepository.findAll()
                .forEach(competitions::add);
        return competitions;
    }

    public Competition getCompetition(Integer id) {
        return competiotionRepository.findOne(id);
    }

    public void createCompetition(Competition course) {
        competiotionRepository.save(course);
    }

    public void updateCompetition(Competition course) {
        competiotionRepository.save(course);
    }

    public void deleteCompetition(Integer id) {
        competiotionRepository.delete(id);
    }

    public void validateImport(MultipartFile competitionFile) {
        File cf = new File(UPLOAD_FOLDER+competitionFile.getOriginalFilename());
        try{
            competitionFile.transferTo(cf);
            validateImport(new FileReader(cf));
        } catch (Exception ex) {
            //TODO
        }
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

    private boolean hasIncorrectHeadColumnOrder(String[] line, String[] spec) {
        boolean result = true;
        for(int i = 0; i < spec.length; i++) {
            result = result && line[i].equals(spec[i]);
        }
        return !result;
    }

    private boolean hasIncorrectDataFormat(String[] line, TYPES[] spec) {
        for(int i = 0; i < spec.length; i++) {
            switch(spec[i]) {
                case STRING : break;
                case INT : {
                    try {
                        int ii = Integer.parseInt(line[i]);
                    } catch (Exception ex) {return true;}
                    break;
                }
                case DATE : {
                    try {
                        Date d = dateFormat.parse(line[i]);
                    } catch (Exception e) {return true;}
                    break;
                }
                case TIME : {
                    try{
                        Date d = timeFormat.parse(line[i]);
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

    private void setRunnerResultData(CompetitionImportModel model, String[] nextLine) {
        RunnerResultImportModel runnerResult;
    }
}


