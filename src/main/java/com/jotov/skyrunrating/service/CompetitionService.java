package com.jotov.skyrunrating.service;

import com.jotov.skyrunrating.entity.Competition;
import com.jotov.skyrunrating.repository.CompetiotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompetitionService {
    @Autowired
    private CompetiotionRepository competiotionRepository;

    @Autowired
    private RunnerService runnerService;

    private ResultService resultService;

    public List<Competition> getAllCompetitions() {
        List<Competition> competitions = new ArrayList<>();
        competiotionRepository.findAll()
                .forEach(competitions::add);
        return competitions;
    }

    public Competition getCompetition(Integer id) {
        return competiotionRepository.findOne(id);
    }

    public void createCompetition(Competition competition) {
        competiotionRepository.save(competition);
    }



    public void updateCompetition(Competition course) {
        competiotionRepository.save(course);
    }

    public void deleteCompetition(Integer id) {
        competiotionRepository.delete(id);
    }




}


