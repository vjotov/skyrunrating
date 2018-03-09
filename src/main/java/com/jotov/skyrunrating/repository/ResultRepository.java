package com.jotov.skyrunrating.repository;

import com.jotov.skyrunrating.entity.Result;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResultRepository extends CrudRepository<Result, Long> {
    // TODO - add @Query annotation -
    // //https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-three-custom-queries-with-query-methods/
    // https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
    //@Query("SELECT r FROM Result r WHERE r.competition_id = ?1")
    //List<Result> findByRunner(Integer runnerId);
}
