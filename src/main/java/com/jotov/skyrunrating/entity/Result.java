package com.jotov.skyrunrating.entity;

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
    //private Runner runner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competition_id", nullable = false)
    private Competition competition;
    private Date modificationTime;
    private Date creationTime;

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
    public void getCreationTime() {
        Date now = new Date();
        this.creationTime = now;
        this.modificationTime = now;
    }
//    /**
//     *
//     * @return Runner
//     */
//    @ManyToOne
//    @JoinColumn(name = "runner_id")
//    public Runner getRunner() {
//        return runner;
//    }
//
//    /**
//     *
//     * @param runner
//     */
//    public void setRunner(Runner runner) {
//        this.runner = runner;
//    }
//
    /**
     *
     * @return Competition
     */
//    @ManyToOne
//    @JoinColumn(name = "competition_id")
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


}
