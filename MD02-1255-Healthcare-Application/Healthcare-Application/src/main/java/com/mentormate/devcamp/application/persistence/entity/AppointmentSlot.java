package com.mentormate.devcamp.application.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NamedQuery(name = "appointmentSlotsBetween",
        query = "select a from AppointmentSlot a where a.isDeleted=false and a.doctor=:doctor and (a.endTime > :startTime and a.startTime < :endTime)")
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class AppointmentSlot extends BaseEntity {
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "doctor_id")
    private Doctor doctor;
    private boolean isDeleted;

}
