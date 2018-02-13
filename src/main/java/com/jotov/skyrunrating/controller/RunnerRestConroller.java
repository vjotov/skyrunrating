package com.jotov.skyrunrating.controller;

import com.jotov.skyrunrating.entity.Result;
import com.jotov.skyrunrating.entity.Runner;
import com.jotov.skyrunrating.service.ResultService;
import com.jotov.skyrunrating.service.RunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/runners")
public class RunnerRestConroller {
    @Autowired
    private RunnerService runnerService;

    @Autowired
    private ResultService resultService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Runner> getAllRunners() {
        return runnerService.getAllRunners();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Runner getRunner(@PathVariable int id) {
        return runnerService.getRunner(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public int createRunner(@RequestBody Runner runner) {
        runnerService.createRunner(runner);
        return runner.getId();
    }

    @RequestMapping(value = "/{id}/results", method = RequestMethod.GET)
    public List<Result> getResultsByRunner(@PathVariable int id) {
        return resultService.getResultByRunner(id);
    }
}
