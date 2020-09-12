package com.mentormate.devcamp.application.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * The type Signup request dto.
 * <p>
 * Contains the user information needed for the sign-up
 */
@RequiredArgsConstructor
@AllArgsConstructor
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

    @NotNull
    private Set<RoleDTO> roles;
}
