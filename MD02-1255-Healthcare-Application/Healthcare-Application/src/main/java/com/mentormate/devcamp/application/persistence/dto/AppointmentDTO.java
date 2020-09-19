package com.mentormate.devcamp.application.persistence.dto;

import com.mentormate.devcamp.application.persistence.entity.Appointment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * The Appointment DTO.
 * <p>
 * Data transfer object for the {@link Appointment} excluding the Id of the entity
 */
@Schema(description = "Appointment DTO is a DTO for the Appointment entity. Id exclusive.", allowableValues = {"doctor", "customer", "startTime"})
@NoArgsConstructor
@AllArgsConstructor
@Data
@Validated
public class AppointmentDTO {
    @Schema(description = "The doctor name.")
    @NotBlank
    private String doctor;

    @Schema(description = "The customer name. Can be empty.")
    private String customer;

    @Schema(description = "The start date time for the appointment.")
    @NotNull
    @Future
    private LocalDateTime startTime;
}
