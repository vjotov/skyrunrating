package com.jotov.skyrunrating.runner;

import com.jotov.skyrunrating.competition.Competition;
import org.springframework.data.repository.CrudRepository;

public interface RunnerRepository extends CrudRepository<Runner, String> {
}
