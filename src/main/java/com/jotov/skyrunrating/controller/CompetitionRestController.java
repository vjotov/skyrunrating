package com.jotov.skyrunrating.controller;

import com.jotov.skyrunrating.entity.Competition;
import com.jotov.skyrunrating.repository.CompetiotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CompetitionRestController {
    @Autowired
    private CompetiotionRepository competiotionRepository;

    @GetMapping("competitions/")
    public List<Competition> getAllCompetitions() {
        //return (List<Competition>) competiotionRepository.findAll();
        List<Competition> competitions = new ArrayList<>();
        competiotionRepository.findAll()
                .forEach(competitions::add);
        return competitions;
    }

    @GetMapping("competitions/{id}")
    public Competition getCompetition(@PathVariable int id) {
        return competiotionRepository.findOne(id);
    }

    @PostMapping("comtetitions/")
    public Integer createCompetition(Competition competition) {
        competiotionRepository.save(competition);
        return competition.getId();
    }
}
