package com.jotov.skyrunrating.competition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompetitionService {
    @Autowired
    private CompetiotionRepository competiotionRepository;

    public List<Competition> getAllCompetitions() {
        List<Competition> competitions = new ArrayList<>();
        competiotionRepository.findAll()
                .forEach(competitions::add);
        return competitions;
    }

    public Competition getCourse(Integer id) {
        return competiotionRepository.findOne(id);
    }

    public void createCourse(Competition course) {
        competiotionRepository.save(course);
    }

    public void updateCourse(Competition course) {
        competiotionRepository.save(course);
    }

    public void deleteCourse(Integer id) {
        competiotionRepository.delete(id);
    }
}
