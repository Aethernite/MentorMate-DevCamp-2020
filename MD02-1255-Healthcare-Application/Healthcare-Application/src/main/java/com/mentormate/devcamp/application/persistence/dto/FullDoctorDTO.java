package com.mentormate.devcamp.application.persistence.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The FullDoctorDTO.
 * <p>
 * This is a DTO for the user entity but only for the users with doctor role.
 */
@Schema(description = "Full Doctor DTO is a DTO for the User entity. Id inclusive. Applies only for the users with role DOCTOR.")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
public class FullDoctorDTO {
    @Schema(description = "The id of the user in the database.")
    private long id;

    @Schema(description = "The username of the user in the database.")
    private String username;

    @Schema(description = "The email of the user in the database.")
    private String email;

}
