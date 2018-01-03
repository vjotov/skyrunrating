package com.jotov.skyrunrating.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAllScores() {
        List<Score> scores = new ArrayList<>();
        scoreRepository.findAll()
                .forEach(scores::add);
        return scores;
    }

    public Score getScore(Integer id) {
        return scoreRepository.findOne(id);
    }

    public void createScore(Score score) {
        scoreRepository.save(score);
    }

    public void updateScore(Score score) {
        scoreRepository.save(score);
    }

    public void deleteScore(Integer id) {
        scoreRepository.delete(id);
    }
}
