package com.mentormate.devcamp.application.persistence.entity.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * The Login request dto.
 * <p>
 * Contains username and password
 */
@RequiredArgsConstructor
@Data
public class LoginRequestDTO {
    private String username;
    private String password;
}
