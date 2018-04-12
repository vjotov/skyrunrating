package com.jotov.skyrunrating.dto;

import com.jotov.skyrunrating.dto.context.Existing;
import com.jotov.skyrunrating.dto.context.New;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

public class ResultDTO {

    @NotNull(groups = Existing.class)
    @Null(groups = New.class)
    private Long id;

    @NotNull(
            message = "Position is required",
            groups = {Existing.class, New.class}
    )
    private Integer position;

    @NotNull(groups = {Existing.class, New.class})
    private Integer result; // in seconds

    @NotNull(groups = Existing.class)
    @Null(groups = New.class)
    private Integer score;

    private String runner;
    private String competition;

    @NotNull(groups = {Existing.class, New.class})
    private Long runnerId;
    @NotNull(groups = {Existing.class, New.class})
    private Long competitionId;

    private Date modificationTime;
    private Date creationTime;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRunner() {
        return runner;
    }

    public void setRunner(String runner) {
        this.runner = runner;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public Long getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(Long runnerId) {
        this.runnerId = runnerId;
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    public Date getCreationTime() { return creationTime; }
    public Date getModificationTime() { return modificationTime; }
}
