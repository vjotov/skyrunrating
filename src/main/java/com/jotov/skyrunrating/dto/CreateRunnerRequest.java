package com.jotov.skyrunrating.dto;

import com.jotov.skyrunrating.entity.Runner;

public class CreateRunnerRequest {
    public static Runner getRunner(CreateRunnerRequest runnerDTO) {;
        Runner runner = new Runner(null,
                runnerDTO.name,
                runnerDTO.dateOfBirth,
                runnerDTO.sex,
                runnerDTO.city,
                runnerDTO.region,
                runnerDTO.team);
        return runner;
    }

    private String name;
    private String dateOfBirth;
    private String sex;
    private String city;
    private String region;
    private String team;

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
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
