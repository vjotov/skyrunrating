package com.jotov.skyrunrating.dto;

import com.jotov.skyrunrating.dto.context.Existing;
import com.jotov.skyrunrating.dto.context.New;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;


public class CompetitionDTO {
    //TODO https://lmonkiewicz.com/programming/get-noticed-2017/spring-boot-rest-request-validation/
    @NotNull(groups = Existing.class)
    @Null(groups = New.class)
    private Long id;

    @NotNull(groups = {Existing.class, New.class})
    private String name;

    @NotNull(groups = {Existing.class, New.class})
    private Date date;

    @NotNull(groups = {Existing.class, New.class})
    private int maxPoints;

    @NotNull(groups = {Existing.class, New.class})
    private int meterDistance;

    @NotNull(groups = {Existing.class, New.class})
    private int meterDisplacement;

    @NotNull(groups = {Existing.class, New.class})
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
