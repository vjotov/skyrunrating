package com.jotov.skyrunrating.repository;

import com.jotov.skyrunrating.entity.Runner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RunnerRepository extends CrudRepository<Runner, Long> {
    @Query("SELECT COUNT(c) FROM Runner c WHERE c.id=?1")
    boolean existsById(Long id);
}
