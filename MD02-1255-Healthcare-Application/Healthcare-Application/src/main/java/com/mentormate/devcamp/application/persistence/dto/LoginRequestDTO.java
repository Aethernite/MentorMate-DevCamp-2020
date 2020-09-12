package com.mentormate.devcamp.application.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * The Login request dto.
 * <p>
 * Contains the user information needed for login
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class LoginRequestDTO {
    private String username;
    private String password;
}
