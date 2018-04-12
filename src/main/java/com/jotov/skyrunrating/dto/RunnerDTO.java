package com.jotov.skyrunrating.dto;

import com.jotov.skyrunrating.dto.context.Existing;
import com.jotov.skyrunrating.dto.context.New;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class RunnerDTO {

    @NotNull(groups = Existing.class)
    @Null(groups = New.class)
    private Long id;

    @NotNull(groups = {Existing.class, New.class})
    private String name;
    @NotNull(groups = {Existing.class, New.class})
    private String dateOfBirth;
    @NotNull(groups = {Existing.class, New.class})
    private String sex;
    private String city;
    private String region;
    private String team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
