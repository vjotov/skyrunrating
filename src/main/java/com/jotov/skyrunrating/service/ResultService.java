package com.jotov.skyrunrating.service;

import com.jotov.skyrunrating.entity.Result;
import com.jotov.skyrunrating.repository.ResultRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private CompetitionService competitionService;

    public List<Result> getAllResults() {
        List<Result> results = new ArrayList<>();
        resultRepository.findAll()
                .forEach(results::add);
        return results;
    }

    public Result getResult(Long id) {
//        return resultRepository.findOne(id);
        return null;
    }

    public Result createResult(Result result) {
        if (result.getCompetition() == null) return null;
        resultRepository.save(result);
        return result;
    }
//    public Result createResult(CreateResultRequest resultDTO) {
//        Competition competition = competitionService.getCompetition(resultDTO.getCompetitionId());
//        if (competition == null) return null;
//        Result result = new Result(resultDTO.getPosition(),
//                resultDTO.getResult(),
//                competition);
//        competition.addResult(result);
//        resultRepository.save(result);
//        //competiotionRepository.save(competition);
//        return result;
//    }

    public void updateResult(Result result) {
        resultRepository.save(result);
    }

    public void deleteResult(Long id) {
//        resultRepository.delete(id);
        return;
    }

    public List<Result> getResultByRunner(int id) {
        //TODO
        //return resultRepository.findByRunner(id);
        return null;

    }
}
