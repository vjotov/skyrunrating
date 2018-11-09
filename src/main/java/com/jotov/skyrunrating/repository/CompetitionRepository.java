package com.jotov.skyrunrating.repository;

import com.jotov.skyrunrating.entity.Competition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CompetitionRepository extends CrudRepository<Competition, Long> {
    //@Query("SELECT COUNT(c) FROM Competition c WHERE c.id=?1")
//    boolean existsById(Long id);

}
