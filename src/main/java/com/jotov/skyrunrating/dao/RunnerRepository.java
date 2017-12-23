package com.jotov.skyrunrating.dao;

import com.jotov.skyrunrating.model.Runner;
import org.springframework.data.repository.CrudRepository;

public interface RunnerRepository extends CrudRepository<Runner, Integer> {
}
