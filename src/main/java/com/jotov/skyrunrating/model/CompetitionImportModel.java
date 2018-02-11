package com.jotov.skyrunrating.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

import static com.jotov.skyrunrating.SkyrunratingApplication.parseStringToDuration;
@Configuration
public class CompetitionImportModel {
    //Название,Дистанция,Набор,Количество баллов,Рекорд,Дата
    //@CsvBindByName(column = "Название",required = true)
    private String name;

    //@CsvBindByName(column = "Дата", required = true)
    //@CsvDate("dd.MM.yyyy")
    private Date date;

    //@CsvBindByName(column = "Количество баллов", required = true)
    private int maxPoints;

    //@CsvBindByName(column = "Дистанция", required = true)
    private int meterDistance;

    //@CsvBindByName(column = "Набор", required = true)
    private int meterDisplacement;

    //@CsvBindByName(column = "Рекорд", required = true)
    private Duration secondsRecord;

    private ArrayList<RunnerResultImportModel> runnerResults;

   // @Bean(scope=DefaultScopes)
    public CompetitionImportModel CompetitionImportModelBean() {
        return new CompetitionImportModel();
    }

    public CompetitionImportModel() {
        this.runnerResults = new ArrayList<RunnerResultImportModel>();
    }

    public CompetitionImportModel(
                            String name,
                            Date date,
                            int maxPoints,
                            int meterDistance,
                            int meterDisplacement,
                            Duration secondsRecord
                            ) {
        this.name = name;
        this.date = date;
        this.meterDistance = meterDistance;
        this.meterDisplacement = meterDisplacement;
        this.maxPoints = maxPoints;
        this.secondsRecord = secondsRecord;
        this.runnerResults = new ArrayList<RunnerResultImportModel>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getMeterDistance() {
        return meterDistance;
    }

    public void setMeterDistance(int meterDistance) {
        this.meterDistance = meterDistance;
    }

    public int getMeterDisplacement() {
        return meterDisplacement;
    }

    public void setMeterDisplacement(int meterDisplacement) {
        this.meterDisplacement = meterDisplacement;
    }

    public Duration getSecondsRecord() {
        return secondsRecord;
    }

    public void setSecondsRecord(Duration secondsRecord) {
        this.secondsRecord = secondsRecord;
    }

    public void setSecondsRecord(String input) {
        this.secondsRecord = parseStringToDuration(input);
    }

    public ArrayList<RunnerResultImportModel> getRunnerResults() {
        return runnerResults;
    }

    public void addRunnerResults(RunnerResultImportModel runnerResults) {
        this.runnerResults.add(runnerResults);
    }

    @Override
    public String toString() {
        return name+" "+maxPoints+" "+meterDistance;
    }
}
