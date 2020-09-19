package com.mentormate.devcamp.application.persistence.repository;

import com.mentormate.devcamp.application.persistence.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * This repository is responsible to contain all queries that is related to {@link Appointment}
 */
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    /**
     * Find by doctor and start time optional.
     *
     * @param doctor    the doctor
     * @param startTime the start time
     * @return the optional
     */
    Optional<Appointment> findByDoctorAndStartTime(String doctor, LocalDateTime startTime);

    /**
     * Find all page.
     *
     * @param pageable the pageable
     * @return the page
     */
    Page<Appointment> findAll(Pageable pageable);

    /**
     * Find all appointments by doctor name.
     *
     * @param doctor   the doctor
     * @param pageable the pageable
     * @return the page
     */
    Page<Appointment> findAllByDoctor(String doctor, Pageable pageable);

    /**
     * Find one by doctor name.
     *
     * @param doctor the doctor
     * @return the optional
     */
    Optional<Appointment> findOneByDoctor(String doctor);
}
