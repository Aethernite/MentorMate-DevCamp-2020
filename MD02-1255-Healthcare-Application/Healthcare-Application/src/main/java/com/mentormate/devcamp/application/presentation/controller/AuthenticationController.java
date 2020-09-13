package com.mentormate.devcamp.application.presentation.controller;

import com.mentormate.devcamp.application.business.service.AuthenticationService;
import com.mentormate.devcamp.application.persistence.dto.JwtResponseDTO;
import com.mentormate.devcamp.application.persistence.dto.LoginRequestDTO;
import com.mentormate.devcamp.application.persistence.dto.SignupRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
    @Operation(summary = "This request method signs-up an account.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully signed up an account"),
            @ApiResponse(responseCode = "400", description = "The request body is not correct"),
            @ApiResponse(responseCode = "409", description = "The username already exists"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody @Valid SignupRequestDTO createUserDto) {
        authenticationService.signup(createUserDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Tries to sign-in a given valid user given by the request body.
     *
     * @param loginRequestDTO the login request dto
     * @return the jwt response dto
     */
    @Operation(summary = "This request method signs-in an account.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully signed in with the account"),
            @ApiResponse(responseCode = "400", description = "The request body is not correct"),
            @ApiResponse(responseCode = "401", description = "Unsuccessful login/Account doesn't exist"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @PostMapping("/signin")
    public JwtResponseDTO signin(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        return authenticationService.signin(loginRequestDTO);
    }

}
