package com.mentormate.devcamp.application.persistence.repository;

import com.mentormate.devcamp.application.persistence.entity.Drug;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * This repository is responsible to contain all queries that is related to {@link Drug}
 */
public interface DrugRepository extends PagingAndSortingRepository<Drug, Integer> {
    Drug findById(Long id);
}
