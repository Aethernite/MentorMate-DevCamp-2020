package com.mentormate.devcamp.application.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Appointment extends BaseEntity {
    private String doctor;
    private String customer;
    private LocalDateTime startTime;


    public void update(Appointment appointment) {
        this.doctor = appointment.getDoctor();
        this.customer = appointment.getCustomer();
        this.startTime = appointment.getStartTime();
    }

}
