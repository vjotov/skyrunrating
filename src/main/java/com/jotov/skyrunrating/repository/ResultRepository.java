package com.jotov.skyrunrating.repository;

import com.jotov.skyrunrating.entity.Result;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResultRepository extends CrudRepository<Result, Integer> {
    // TODO - add @Query annotation -
    // //https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-three-custom-queries-with-query-methods/
    List<Result> findByRunner(Integer runnerId);
}
