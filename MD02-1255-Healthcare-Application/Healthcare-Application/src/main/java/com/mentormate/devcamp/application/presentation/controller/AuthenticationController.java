package com.mentormate.devcamp.application.presentation.controller;

import com.mentormate.devcamp.application.business.service.AuthenticationService;
import com.mentormate.devcamp.application.persistence.entity.dto.JwtResponseDTO;
import com.mentormate.devcamp.application.persistence.entity.dto.LoginRequestDTO;
import com.mentormate.devcamp.application.persistence.entity.dto.SignupRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Authentication controller.
 * <p>
 * Takes care of the sign-up and sign-in processes
 */
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    /**
     * Tries to sign-up a given valid user given by the request body
     *
     * @param createUserDto the create user dto
     * @return the response entity
     */
    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody @Validated SignupRequestDTO createUserDto) {
        authenticationService.signup(createUserDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Tries to sign-in a given valid user given by the request body.
     *
     * @param loginRequestDTO the login request dto
     * @return the jwt response dto
     */
    @PostMapping("/signin")
    public JwtResponseDTO signin(@RequestBody @Validated LoginRequestDTO loginRequestDTO) {
        return authenticationService.signin(loginRequestDTO);
    }

}
