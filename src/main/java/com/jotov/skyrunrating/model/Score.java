package com.jotov.skyrunrating.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Score {
    @Id
    private int id;
    private int score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
