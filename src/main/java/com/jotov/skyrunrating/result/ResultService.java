package com.jotov.skyrunrating.result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;

    public List<Result> getAllCompetitions() {
        List<Result> results = new ArrayList<>();
        resultRepository.findAll()
                .forEach(results::add);
        return results;
    }

    public Result getResult(Integer id) {
        return resultRepository.findOne(id);
    }

    public void createResult(Result result) {
        resultRepository.save(result);
    }

    public void updateResult(Result result) {
        resultRepository.save(result);
    }

    public void deleteResult(Integer id) {
        resultRepository.delete(id);
    }
}
