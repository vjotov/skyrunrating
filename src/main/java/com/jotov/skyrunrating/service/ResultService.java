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

    public List<Result> getResultByRunner(int id) {
        //TODO
        //return resultRepository.findByRunner(id);
        return null;

    }
}
