package com.jotov.skyrunrating.model;

import java.time.Duration;

import static com.jotov.skyrunrating.SkyrunratingApplication.parseStringToDuration;

public class RunnerResultImportModel {
    private String name;
    private String sex;
    private String city;
    private String region;
    private String team;
    private Duration resultSeconds;
    private int position;

    public RunnerResultImportModel() {}

    public RunnerResultImportModel(String name, String sex, String city, String region, String team,Duration resultSeconds, int position) {
        this.name = name;
        this.sex = sex;
        this.city = city;
        this.region = region;
        this.team = team;
    }

    public RunnerResultImportModel(String name, String sex, String team, Duration resultSeconds, int position) {
        this.name = name;
        this.sex = sex;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Duration getResultSeconds() {
        return resultSeconds;
    }

    public void setResultSeconds(Duration resultSeconds) {
        this.resultSeconds = resultSeconds;
    }

    public void setResultSeconds(String input) {
        this.resultSeconds = parseStringToDuration(input);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
