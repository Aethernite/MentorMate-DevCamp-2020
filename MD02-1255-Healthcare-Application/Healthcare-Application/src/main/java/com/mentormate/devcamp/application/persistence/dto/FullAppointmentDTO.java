package com.mentormate.devcamp.application.persistence.dto;

import com.mentormate.devcamp.application.persistence.entity.Appointment;
import com.mentormate.devcamp.application.persistence.entity.Appointment.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * The Appointment DTO.
 * <p>
 * Data transfer object for the {@link Appointment} including the Id of the entity
 */
@Schema(description = "Full Appointment DTO is a DTO for the Appointment entity. Id inclusive.")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FullAppointmentDTO {
    @Schema(description = "The appointment id in the database.")
    private Long id;

    @Schema(description = "The doctor name.")
    private String doctor;

    @Schema(description = "The customer name. Can be empty.")
    private String customer;

    @Schema(description = "The start date time for the appointment.")
    private LocalDateTime startTime;

    @Schema(description = "The status for the appointment")
    private Status status;

}
