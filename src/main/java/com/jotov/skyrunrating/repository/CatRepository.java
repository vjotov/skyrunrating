package com.jotov.skyrunrating.repository;

import com.jotov.skyrunrating.entity.Cat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends CrudRepository<Cat, Long>{
}
