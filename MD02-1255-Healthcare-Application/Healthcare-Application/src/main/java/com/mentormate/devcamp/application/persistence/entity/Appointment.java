package com.mentormate.devcamp.application.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * The entity Appointment.
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Appointment extends BaseEntity {
    private String doctor;
    private String customer;
    private LocalDateTime startTime;
    private Status status;

    /**
     * Instantiates a new Appointment.
     *
     * @param doctor    the doctor
     * @param customer  the customer
     * @param startTime the start time
     */
    public Appointment(String doctor, String customer, LocalDateTime startTime) {
        this.doctor = doctor;
        this.customer = customer;
        this.startTime = startTime;
        this.status = Status.PENDING;
    }

    /**
     * Updates the object with new information.
     * <p>
     * Updates all the fields with new information from the given appointment object.
     * The id stays the same.
     *
     * @param appointment the appointment
     */
    public void update(Appointment appointment) {
        this.doctor = appointment.getDoctor();
        this.customer = appointment.getCustomer();
        this.startTime = appointment.getStartTime();
        this.status = appointment.getStatus();
    }

    /**
     * The enum Status.
     */
    public enum Status {
        /**
         * Approved status.
         */
        APPROVED,
        /**
         * Declined status.
         */
        DECLINED,
        /**
         * Pending status.
         */
        PENDING
    }

}
