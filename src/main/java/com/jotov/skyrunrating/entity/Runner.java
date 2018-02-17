package com.jotov.skyrunrating.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Runner extends AEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String dateOfBirth;
    private String sex;
    private String city;
    private String region;
    private String team;
    private Set<Score> scores;
    private Set<Result> results;


    public Runner() { }

    public Runner(Long id,
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
        this.team = team;
    }

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

    @OneToMany(mappedBy = "Score", cascade = CascadeType.ALL)
    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }

    @OneToMany(mappedBy = "Result", cascade = CascadeType.ALL)
    public Set<Result> getResults() {
        return results;
    }

    public void setResults(Set<Result> results) {
        this.results = results;
    }
}
