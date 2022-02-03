package com.mentormate.devcamp.application.presentation.controller;

import com.mentormate.devcamp.application.business.service.DoctorService;
import com.mentormate.devcamp.application.persistence.dto.FullDoctorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Customer controller.
 * <p>
 * This controller is responsible to list all the doctors. You must be authenticated with role CUSTOMER.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    /**
     * Gets all doctors.
     *
     * @param page the page
     * @return all the doctors
     */
    @Operation(summary = "This request method return all of the doctors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return page of doctors"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @GetMapping(params = {"page"})
    public ResponseEntity<Page<FullDoctorDTO>> getAllDoctors(@RequestParam("page") int page) {
        return new ResponseEntity<>(doctorService.findPaginated(page), HttpStatus.OK);
    }

}
