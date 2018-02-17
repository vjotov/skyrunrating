package com.jotov.skyrunrating.entity;

import javax.persistence.*;

@Entity
public class Score extends AEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer score;
    private Runner runner;
    private Competition competition;

    /**
     *
     * @return Id
     */
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

    /**
     *
     * @return The Score of
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

    /**
     *
     * @return Runner
     */
    @ManyToOne
    @JoinColumn(name = "runner_id")
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
    @ManyToOne
    @JoinColumn(name = "competition_id")
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
