package com.jotov.skyrunrating.controller;

import com.jotov.skyrunrating.entity.Competition;
import com.jotov.skyrunrating.repository.CompetiotionRepository;
import com.jotov.skyrunrating.service.CompetitionService;
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
    private CompetitionService competiotionRepository;

    @GetMapping("competitions/")
    public List<Competition> getAllCompetitions() {
        //return (List<Competition>) competiotionRepository.findAll();
        return competiotionRepository.getAllCompetitions();
    }

    @GetMapping("competitions/{id}")
    public Competition getCompetition(@PathVariable int id) {
        return competiotionRepository.getCompetition(id);
    }

    @PostMapping("comtetitions/")
    public void createCompetition(Competition competition) {
        competiotionRepository.createCompetition(competition);
       // return competition.getId();
    }
}
