package com.jotov.skyrunrating.dto;

public class CreateResultRequest {
    private Long runnerId;
    private Long competitionId;
    private Integer position;
    private Integer result; // in seconds

    public Long getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(Long runner) {
        this.runnerId = runner;
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Long competition) {
        this.competitionId = competition;
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

}
