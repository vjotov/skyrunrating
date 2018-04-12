package com.jotov.skyrunrating.controller;

import com.jotov.skyrunrating.dto.ResultDTO;
import com.jotov.skyrunrating.dto.context.New;
import com.jotov.skyrunrating.entity.Competition;
import com.jotov.skyrunrating.entity.Result;
import com.jotov.skyrunrating.entity.Runner;
import com.jotov.skyrunrating.service.CompetitionService;
import com.jotov.skyrunrating.service.ResultService;
import com.jotov.skyrunrating.service.RunnerService;
import com.jotov.skyrunrating.util.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/result")
public class ResultRestController {

    @Autowired
    private ResultService resultService;

    @Autowired
    private CompetitionService competitionService;

    @Autowired
    private RunnerService runnerService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.GET)
    public List<ResultDTO> getAllResults() {
        List<Result> results = resultService.getAllResults();
        return results.stream()
                .map(result -> convertToDto(result))
                .collect(Collectors.toList());
    }

    //@RequestMapping(value = "/{id}/", method = RequestMethod.GET)
    public Result getCompetition(@PathVariable long id) {
        return resultService.getResult(id);
    }


    @RequestMapping(method = RequestMethod.POST)
    public Long createResult(@Validated(New.class) @RequestBody ResultDTO resultDTO) {
        //Result result = convertToEntity(resultDTO);
        Competition competition = competitionService.getCompetition(resultDTO.getCompetitionId());
        if (competition==null)
            throw (new NotFoundException("Competition not found"));
        Runner runner = runnerService.getRunner(resultDTO.getRunnerId());
        if(runner == null)
            throw (new NotFoundException("Runner not found"));
        //TODO - to check possible error!!!
        //competition.addResult(result);
        //resultService.createResult(result);
        //if (result == null)
            return null;
        //else
        //    return result.getId();
    }

    private ResultDTO convertToDto(Result result) {
        ResultDTO resultDTO = modelMapper.map(result, ResultDTO.class);
        return resultDTO;
    }

    private Result convertToEntity(ResultDTO resultDTO) {
        Result result = modelMapper.map(resultDTO, Result.class);
        return result;
    }

}
