package com.mentormate.devcamp.application.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Validated
public class AppointmentDTO {
    @NotBlank
    private String doctor;
    private String customer;
    @NotNull
    @Future
    private LocalDateTime startTime;
}
