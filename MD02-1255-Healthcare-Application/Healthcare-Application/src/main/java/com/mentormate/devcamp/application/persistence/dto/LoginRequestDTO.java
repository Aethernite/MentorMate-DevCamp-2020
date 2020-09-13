package com.mentormate.devcamp.application.persistence.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * The Login request dto.
 * <p>
 * Contains the user information needed for login
 */
@Schema(description = "Login Request DTO is a DTO that is used for the transferring the username and password for the sign-in operation", allowableValues = {"username","password"})
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class LoginRequestDTO {
    @Schema(description = "The username of the client")
    private String username;
    @Schema(description = "The password of the client")
    private String password;
}
