package com.jotov.skyrunrating.controller;

import com.jotov.skyrunrating.entity.Result;
import com.jotov.skyrunrating.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/competitions")
public class ResultRestController {

    @Autowired
    private ResultService resultService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Result> getAllCompetitions() {
        //return (List<Competition>) competiotionRepository.findAll();
        return resultService.getAllCompetitions();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getCompetition(@PathVariable int id) {
        return resultService.getResult(id);
    }


    @RequestMapping(method = RequestMethod.POST)
    public long createCompetition(@RequestBody Result result) {
        resultService.createResult(result);
        return result.getId();
    }

}
