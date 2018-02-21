package com.jotov.skyrunrating.repository;

import com.jotov.skyrunrating.entity.Result;
import org.springframework.data.repository.CrudRepository;

public interface ResultRepository extends CrudRepository<Result, Integer> {
    // TODO - add @Query annotation -
    // //https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-three-custom-queries-with-query-methods/
//    @Query("SELECT * FROM Result LIMIT 1")
//    List<Result> findByRunner(Integer runnerId);
}
