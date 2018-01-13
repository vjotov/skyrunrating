package com.jotov.skyrunrating.entity;

import com.jotov.skyrunrating.model.CompetitionImportModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private Date date;
    private int maxPoints;
    private int meterDistance;
    private int meterDisplacement;
    private int secondsRecord;

    public Competition() {}

    public Competition(int id,
                       String name,
                       Date description,
                       int meterDistance,
                       int meterDisplacement,
                       int maxPoints,
                       int secondsRecord) {
        this.id = id;
        this.name = name;
        date = description;
        this.meterDistance = meterDistance;
        this.meterDisplacement = meterDisplacement;
        this.maxPoints = maxPoints;
        this.secondsRecord = secondsRecord;
    }
    public Competition(CompetitionImportModel model) {
        name = model.getName();
        date = model.getDate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
