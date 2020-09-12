package com.mentormate.devcamp.application.persistence.repository;

import com.mentormate.devcamp.application.persistence.entity.Drug;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * This repository is responsible to contain all queries that is related to {@link Drug}
 */
public interface DrugRepository extends CrudRepository<Drug, Long> {
    Optional<Drug> findByName(String name);
}
