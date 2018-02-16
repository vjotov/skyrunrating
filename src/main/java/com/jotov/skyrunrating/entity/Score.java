package com.jotov.skyrunrating.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Score extends AEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer score;

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
}
