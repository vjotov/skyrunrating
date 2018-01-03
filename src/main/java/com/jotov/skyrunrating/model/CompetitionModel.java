package com.jotov.skyrunrating.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import java.util.Date;

public class CompetitionModel {
    //Название,Дистанция,Набор,Количество баллов,Рекорд,Дата
    @CsvBindByName(column = "Название",required = true)
    private String name;

    @CsvBindByName(column = "Дата", required = true)
    @CsvDate("dd.MM.yyyy")
    private Date date;

    @CsvBindByName(column = "Количество баллов", required = true)
    private int maxPoints;

    @CsvBindByName(column = "Дистанция", required = true)
    private int meterDistance;

    @CsvBindByName(column = "Набор", required = true)
    private int meterDisplacement;

    @CsvBindByName(column = "Рекорд", required = true)
    // TODO: to change to java.time.Duration
    private int secondsRecord;

    public CompetitionModel() {}

    public CompetitionModel(
                            String name,
                            Date description,
                            int maxPoints,
                            int meterDistance,
                            int meterDisplacement,
                            int secondsRecord
                            ) {
        this.name = name;
        date = description;
        this.meterDistance = meterDistance;
        this.meterDisplacement = meterDisplacement;
        this.maxPoints = maxPoints;
        this.secondsRecord = secondsRecord;
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

    public int getSecondsRecord() {
        return secondsRecord;
    }

    public void setSecondsRecord(int secondsRecord) {
        this.secondsRecord = secondsRecord;
    }
}
