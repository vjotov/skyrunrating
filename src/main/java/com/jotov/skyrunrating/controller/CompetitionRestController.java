package com.jotov.skyrunrating.controller;

import com.jotov.skyrunrating.entity.Competition;
import com.jotov.skyrunrating.repository.CompetiotionRepository;
import com.jotov.skyrunrating.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/competitions")
public class CompetitionRestController {
    @Autowired
    private CompetitionService competiotionRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Competition> getAllCompetitions() {
        //return (List<Competition>) competiotionRepository.findAll();
        return competiotionRepository.getAllCompetitions();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Competition getCompetition(@PathVariable int id) {
        return competiotionRepository.getCompetition(id);
    }


    @RequestMapping(method = RequestMethod.POST)
    public long createCompetition(@RequestBody  Competition competition) {
        competiotionRepository.createCompetition(competition);
        return competition.getId();
    }
}
