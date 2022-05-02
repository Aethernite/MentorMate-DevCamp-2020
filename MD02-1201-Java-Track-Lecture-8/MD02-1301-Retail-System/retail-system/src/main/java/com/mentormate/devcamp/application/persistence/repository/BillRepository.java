package com.mentormate.devcamp.application.persistence.repository;

import com.mentormate.devcamp.application.persistence.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Bill repository.
 * <p>
 * Handles all of the operations with the H2 database for the entity {@link Bill}
 */
public interface BillRepository extends JpaRepository<Bill, Long> {
    /**
     * Find one by user id.
     *
     * @param id the user id
     * @return the bill
     */
    Bill findOneByUserId(long id);
}
