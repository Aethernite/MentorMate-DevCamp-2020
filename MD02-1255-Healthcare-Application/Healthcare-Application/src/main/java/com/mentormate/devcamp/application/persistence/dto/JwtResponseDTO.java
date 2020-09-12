package com.mentormate.devcamp.application.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type Jwt response dto.
 * <p>
 * Contains the jwt token
 */
@AllArgsConstructor
@Data
public class JwtResponseDTO {
    private String token;
}
