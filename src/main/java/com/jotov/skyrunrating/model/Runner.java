package com.jotov.skyrunrating.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Runner {
    @Id
    private int id;
    private String name;
    private String dateOfBirth;
    private String sex;
    private String city;
    private String region;
    private String Team;

    public Runner() { }

    public Runner(int id,
                  String name,
                  String dateOfBirth,
                  String sex,
                  String city,
                  String region,
                  String team) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.city = city;
        this.region = region;
        Team = team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTeam() {
        return Team;
    }

    public void setTeam(String team) {
        Team = team;
    }
}
