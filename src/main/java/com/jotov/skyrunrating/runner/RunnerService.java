package com.jotov.skyrunrating.runner;

import com.jotov.skyrunrating.competition.CompetiotionRepository;
import com.jotov.skyrunrating.competition.Competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RunnerService {
    @Autowired
    private RunnerRepository runnerRepository;

    public List<Runner> getAllCompetitions() {
        List<Runner> runners = new ArrayList<>();
        runnerRepository.findAll()
                .forEach(runners::add);
        return runners;
    }

    public Runner getCourse(Integer id) {
        return runnerRepository.findOne(id);
    }

    public void createCourse(Runner runner) {
        runnerRepository.save(runner);
    }

    public void updateCourse(Runner runner) {
        runnerRepository.save(runner);
    }

    public void deleteCourse(Integer id) {
        runnerRepository.delete(id);
    }
}
