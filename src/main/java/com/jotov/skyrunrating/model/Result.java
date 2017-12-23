package com.jotov.skyrunrating.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Result {
    @Id
    private int id;
    private int position;
    private int result; // in seconds

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
