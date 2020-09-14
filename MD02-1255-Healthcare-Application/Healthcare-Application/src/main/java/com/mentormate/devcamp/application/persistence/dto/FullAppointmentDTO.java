package com.mentormate.devcamp.application.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FullAppointmentDTO {
    private Long id;
    private String doctor;
    private String customer;
    private LocalDateTime startTime;

    public Long getId() {
        return id;
    }

}
