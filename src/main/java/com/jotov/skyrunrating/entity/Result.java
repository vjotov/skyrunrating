package com.jotov.skyrunrating.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer position;
    private Integer result; // in seconds
    private Integer score;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "runner_id", nullable = false)
    @JsonIgnore
    private Runner runner;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "competition_id", nullable = false)
    @JsonIgnore
    private Competition competition;

    private Date modificationTime;
    private Date creationTime;

    @Transient
    private Long runnerId;
    @Transient
    private Long competitionId;

    public Result() { super(); }

    /**
     *
     * @param position
     * @param result
     * @param competition
     */
    public Result(Integer position,
                  Integer result,
                  Competition competition) {
        this.position = position;
        this.result = result;
        this.competition = competition;
    }

    /**
     *
     * @return the id of the result
     */
    public Long getId() {
        return id;
    }

    /**
     * This setter method should only be used by unit tests.
     * @param id new id of the result
     */
    protected void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return the position of the runner in the competition.
     */
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getResult() { return result; }

    public void setResult(int result) {
        this.result = result;
    }


    public Date getModificationTime() {
        return modificationTime;
    }

    public Date getCreationTime() { return creationTime; }

    /**
     *
     * @return The Score
     */
    public Integer getScore() {
        return score;
    }

    /**
     *
     * @param score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    @PreUpdate
    public void preUpdate() {
        this.modificationTime = new Date();
    }

    @PrePersist
    public void prePersist() {
        Date now = new Date();
        this.creationTime = now;
        this.modificationTime = now;
    }
    /**
     *
     * @return Runner
     */
    public Runner getRunner() {
        return runner;
    }

    /**
     *
     * @param runner
     */
    public void setRunner(Runner runner) {
        this.runner = runner;
    }

    /**
     *
     * @return Competition
     */

    public Competition getCompetition() {
        return competition;
    }

    /**
     *
     * @param competition
     */
    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    @Transient
    public Long getCompetitionId() {
        return competition.getId();
    }

    @Transient
    public Long getRunnerId() {
        return runner.getId();
    }

    public void setRunnerId(Long runnerId) {
        this.runnerId = runnerId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }
}
