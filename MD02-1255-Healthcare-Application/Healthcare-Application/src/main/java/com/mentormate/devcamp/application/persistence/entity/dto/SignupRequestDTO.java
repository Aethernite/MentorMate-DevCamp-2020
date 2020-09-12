package com.mentormate.devcamp.application.persistence.entity.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * The type Signup request dto.
 * 
 * Contains
 */
@RequiredArgsConstructor
@Data
public class SignupRequestDTO {

    @Size(max = 20, min = 5)
    @NotBlank
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 20, min = 5)
    private String password;
}
