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

    public Runner getRunner(Long id) {
        if (id == null) throw new IllegalArgumentException("An identifier is required to retrieve an instance of Competition");
        return runnerRepository.findOne(id);
    }

    public List<Runner> getRunner(String name) {
        List<Runner> runners = new ArrayList<>();
        //TODO
        //return runnerRepository.findByName(name);
        return runners;
    }

    public void createRunner(Runner runner) {
        runnerRepository.save(runner);
    }

    public void updateRunner(Runner runner) {
        runnerRepository.save(runner);
    }

    public void deleteRunner(Long id) {
        runnerRepository.delete(id);
    }
}
