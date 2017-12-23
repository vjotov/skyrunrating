package com.jotov.skyrunrating.service;

import com.jotov.skyrunrating.model.Runner;
import com.jotov.skyrunrating.dao.RunnerRepository;
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
