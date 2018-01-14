package com.jotov.skyrunrating.repository;

import com.jotov.skyrunrating.entity.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreRepository extends CrudRepository<Score, Integer> {
}
