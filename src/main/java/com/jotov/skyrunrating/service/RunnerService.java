package com.jotov.skyrunrating.service;

import com.jotov.skyrunrating.entity.Runner;
import com.jotov.skyrunrating.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RunnerService {
    @Autowired
    private RunnerRepository runnerRepository;

    public List<Runner> getAllRunners() {
        List<Runner> runners = new ArrayList<>();
        runnerRepository.findAll()
                .forEach(runners::add);
        return runners;
    }

    public Runner getRunner(Integer id) {
        return runnerRepository.findOne(id);
    }

    public void createRunner(Runner runner) {
        runnerRepository.save(runner);
    }

    public void updateRunner(Runner runner) {
        runnerRepository.save(runner);
    }

    public void deleteRunner(Integer id) {
        runnerRepository.delete(id);
    }
}
