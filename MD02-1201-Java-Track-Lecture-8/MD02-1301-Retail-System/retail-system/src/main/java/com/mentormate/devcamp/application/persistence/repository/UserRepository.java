package com.mentormate.devcamp.application.persistence.repository;

import com.mentormate.devcamp.application.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The User repository.
 * <p>
 * Handles all of the operations with the H2 database for the entity {@link User}
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
