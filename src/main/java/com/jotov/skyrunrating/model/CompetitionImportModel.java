package com.jotov.skyrunrating.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.time.Duration;
import java.util.Date;

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
    // TODO: to change to java.time.Duration
    private Duration secondsRecord;

    public CompetitionImportModel() {}

    public CompetitionImportModel(
                            String name,
                            Date description,
                            int maxPoints,
                            int meterDistance,
                            int meterDisplacement,
                            Duration secondsRecord
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

    public Duration getSecondsRecord() {
        return secondsRecord;
    }

    public void setSecondsRecord(Duration secondsRecord) {
        this.secondsRecord = secondsRecord;
    }

    public void setSecondsRecord(String input) {
        String[] parts = input.split ( ":" );
        Duration d = Duration.ZERO;
        if ( parts.length == 3 ) {
            int hours = Integer.parseInt ( parts[ 0 ] );
            int minutes = Integer.parseInt ( parts[ 1 ] );
            int seconds = Integer.parseInt ( parts[ 2 ] );
            d = d.plusHours ( hours ).plusMinutes ( minutes ).plusSeconds ( seconds );
        } else if ( parts.length == 2 ) {
            int hours = Integer.parseInt ( parts[ 0 ] );
            int minutes = Integer.parseInt ( parts[ 1 ] );
            d = d.plusHours ( hours ).plusMinutes ( minutes );
        } else {
            System.out.println ( "ERROR - Unexpected input." );
        }
        this.secondsRecord = d;
    }
}
