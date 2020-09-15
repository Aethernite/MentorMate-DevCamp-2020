package com.mentormate.devcamp.application.persistence.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type Jwt response dto.
 * <p>
 * Contains the jwt token
 */
@Schema(description = "JWT Response DTO is a DTO that is used for transferring the JWT token", allowableValues = {"token"})
@AllArgsConstructor
@Data
public class JwtResponseDTO {
    @Schema(description = "The JWT token")
    private String token;
}
