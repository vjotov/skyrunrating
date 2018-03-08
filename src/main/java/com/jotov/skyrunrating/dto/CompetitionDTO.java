package com.jotov.skyrunrating.dto;

import com.jotov.skyrunrating.entity.Competition;
import com.jotov.skyrunrating.model.CompetitionImportModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompetitionDTO {
    private Long id;
    private String name;
    private Date date;
    private int maxPoints;
    private int meterDistance;
    private int meterDisplacement;
    private int secondsRecord;
    private Date modificationTime;
    private Date creationTime;

    //private List<ResultDTO> results;


    public CompetitionDTO() {}

    public CompetitionDTO(Long id,
                       String name,
                       Date date,
                       int meterDistance,
                       int meterDisplacement,
                       int maxPoints,
                       int secondsRecord) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.meterDistance = meterDistance;
        this.meterDisplacement = meterDisplacement;
        this.maxPoints = maxPoints;
        this.secondsRecord = secondsRecord;
    }

    public CompetitionDTO(Competition competition) {
        this.id = competition.getId();
        this.name = competition.getName();
        this.date = competition.getDate();
        this.meterDistance = competition.getMeterDistance();
        this.meterDisplacement =competition.getMeterDisplacement();
        this.maxPoints = competition.getMaxPoints();
        this.secondsRecord = competition.getSecondsRecord();
        this.modificationTime = competition.getModificationTime();
        this.creationTime = competition.getCreationTime();
    }

    public Long getId() {
        return id;
    }

    /**
     * This setter method should only be used by unit tests.
     * @param id
     */
    protected void setId(Long id) {
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

    public Date getCreationTime() { return creationTime; }

    public Date getModificationTime() { return modificationTime; }
}
