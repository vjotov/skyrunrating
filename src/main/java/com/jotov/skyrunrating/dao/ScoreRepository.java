package com.jotov.skyrunrating.dao;

import com.jotov.skyrunrating.model.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreRepository extends CrudRepository<Score, Integer> {
}
