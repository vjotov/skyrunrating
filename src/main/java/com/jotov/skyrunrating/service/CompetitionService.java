package com.jotov.skyrunrating.service;

import com.jotov.skyrunrating.entity.Competition;
import com.jotov.skyrunrating.repository.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompetitionService {
    @Autowired
    private CompetitionRepository competiotionRepository;

    @Autowired
    private RunnerService runnerService;


    public List<Competition> getAllCompetitions() {
        List<Competition> competitions = new ArrayList<>();
        competiotionRepository.findAll()
                .forEach(competitions::add);
        return competitions;
    }

    public Competition getCompetition(Long id) {
        if (id == null) throw new IllegalArgumentException("An identifier is required to retrieve an instance of Competition");
        return competiotionRepository.findOne(id);
    }

    public Competition createCompetition(Competition competition) {
        competiotionRepository.save(competition);
        return competition;
    }



    public void updateCompetition(Competition course) {
        competiotionRepository.save(course);
    }

    public void deleteCompetition(Long id) {
        competiotionRepository.delete(id);
    }




}


