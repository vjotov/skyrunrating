package com.jotov.skyrunrating.controller;

import com.jotov.skyrunrating.dto.RunnerDTO;
import com.jotov.skyrunrating.entity.Result;
import com.jotov.skyrunrating.entity.Runner;
import com.jotov.skyrunrating.service.ResultService;
import com.jotov.skyrunrating.service.RunnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/runners")
public class RunnerRestConroller {
    @Autowired
    private RunnerService runnerService;

    @Autowired
    private ResultService resultService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.GET)
    public List<RunnerDTO> getAllRunners() {
        List<Runner> runners = runnerService.getAllRunners();
        return runners.stream()
                .map(runner -> convertToDto(runner))
                .collect(Collectors.toList());
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public RunnerDTO getRunner(@PathVariable long id) {
        return convertToDto(runnerService.getRunner(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public long createRunner(@RequestBody RunnerDTO runnerDTO) {
        Runner runner = convertToEntity(runnerDTO);
        runnerService.createRunner(runner);
        return runner.getId();
    }

    @RequestMapping(value = "/{id}/results", method = RequestMethod.GET)
    public List<Result> getResultsByRunner(@PathVariable int id) {
        return resultService.getResultByRunner(id);
    }

    private RunnerDTO convertToDto(Runner runner) {
        RunnerDTO runnerDTO = modelMapper.map(runner, RunnerDTO.class);
        return runnerDTO;
    }

    private Runner convertToEntity(RunnerDTO runnerDTO) {
        Runner runner = modelMapper.map(runnerDTO, Runner.class);
        return runner;
    }
}
