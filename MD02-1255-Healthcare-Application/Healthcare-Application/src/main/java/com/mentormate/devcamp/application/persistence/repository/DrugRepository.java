package com.mentormate.devcamp.application.persistence.repository;

import com.mentormate.devcamp.application.persistence.entity.Drug;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * This repository is responsible to contain all queries that is related to {@link Drug}
 */
public interface DrugRepository extends CrudRepository<Drug, Long> {
    /**
     * Find by name.
     *
     * @param name the name
     * @return an optional
     */
    Optional<Drug> findByName(String name);

    /**
     * Find all paginated.
     *
     * @param pageable the pageable
     * @return the page
     */
    Page<Drug> findAll(Pageable pageable);
}
