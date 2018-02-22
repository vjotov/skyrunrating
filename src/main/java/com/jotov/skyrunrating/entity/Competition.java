package com.jotov.skyrunrating.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jotov.skyrunrating.model.CompetitionImportModel;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date date;
    private int maxPoints;
    private int meterDistance;
    private int meterDisplacement;
    private int secondsRecord;
    private Date modificationTime;
    private Date creationTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "competition", cascade = CascadeType.ALL)
    private List<Result> results;


    public Competition() {}

    public Competition(Long id,
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

    @PreUpdate
    public void preUpdate() {
        this.modificationTime = new Date();
    }

    @PrePersist
    public void getCreationTime() {
        Date now = new Date();
        this.creationTime = now;
        this.modificationTime = now;
    }

    //TODO: https://spring.io/blog/2014/12/02/latest-jackson-integration-improvements-in-spring
    //TODO: https://stackoverflow.com/questions/31465440/recursive-json-view-of-an-entity-with-one-to-many-relationship-in-rest-controlle
    @JsonIgnore
    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
