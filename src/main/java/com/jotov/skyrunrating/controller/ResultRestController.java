package com.jotov.skyrunrating.controller;

import com.jotov.skyrunrating.dto.CreateResultRequest;
import com.jotov.skyrunrating.entity.Result;
import com.jotov.skyrunrating.service.CompetitionService;
import com.jotov.skyrunrating.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/result")
public class ResultRestController {

    @Autowired
    private ResultService resultService;
    @Autowired
    private CompetitionService competitionService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Result> getAllResults() {
        //return (List<Competition>) resultService.findAll();
        return resultService.getAllCompetitions();
    }

    //@RequestMapping(value = "/{id}/", method = RequestMethod.GET)
    public Result getCompetition(@PathVariable long id) {
        return resultService.getResult(id);
    }


    @RequestMapping(method = RequestMethod.POST)
    public long createCompetition(@RequestBody CreateResultRequest resultDTO) {


        Result result = resultService.createResult(resultDTO);
        return result.getId();
    }

}
