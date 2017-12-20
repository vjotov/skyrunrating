package com.jotov.skyrunrating.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAllCompetitions() {
        List<Score> scores = new ArrayList<>();
        scoreRepository.findAll()
                .forEach(scores::add);
        return scores;
    }

    public Score getCourse(Integer id) {
        return scoreRepository.findOne(id);
    }

    public void createCourse(Score score) {
        scoreRepository.save(score);
    }

    public void updateCourse(Score score) {
        scoreRepository.save(score);
    }

    public void deleteCourse(Integer id) {
        scoreRepository.delete(id);
    }
}
