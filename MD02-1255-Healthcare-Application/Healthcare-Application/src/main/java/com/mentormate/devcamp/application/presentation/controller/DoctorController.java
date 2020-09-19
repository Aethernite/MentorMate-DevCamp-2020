package com.mentormate.devcamp.application.presentation.controller;

import com.mentormate.devcamp.application.business.service.DoctorService;
import com.mentormate.devcamp.application.persistence.dto.FullAppointmentDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * The Doctor controller.
 * <p>
 * This controller is responsible to list all doctor appointments and approve/decline them. You must be authenticated with role DOCTOR.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/doctors/appointments")
public class DoctorController {

    private final DoctorService doctorService;

    /**
     * Gets all appointments.
     *
     * @param page the page
     * @return all the appointments paged
     */
    @Operation(summary = "This request method return all of the appointments for the doctor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return page of appointments for the logged doctor"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @GetMapping(params = {"page"})
    public ResponseEntity<Page<FullAppointmentDTO>> getAllAppointments(@RequestParam("page") int page) {
        return new ResponseEntity<>(doctorService.findPaginated(page), HttpStatus.OK);
    }

    /**
     * Sets appointment pending.
     *
     * @param appointmentId the appointment id
     * @return the full dto appointment
     */
    @Operation(summary = "This request method sets appointment to status pending")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return updated appointment"),
            @ApiResponse(responseCode = "400", description = "The request body is not correct"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Appointment not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @PutMapping("/pending/{appointmentId}")
    public ResponseEntity<FullAppointmentDTO> setPendingId(@PathVariable("appointmentId") @Min(value = 1) @NotNull Long appointmentId) {
        return new ResponseEntity<>(doctorService.setAppointmentToPendingID(appointmentId), HttpStatus.OK);
    }

    /**
     * Sets appointment approved.
     *
     * @param appointmentId the appointment id
     * @return the full dto appointment
     */
    @Operation(summary = "This request method sets appointment to status approved")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return updated appointment"),
            @ApiResponse(responseCode = "400", description = "The request body is not correct"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Appointment not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @PutMapping("/approved/{appointmentId}")
    public ResponseEntity<FullAppointmentDTO> setApprovedId(@PathVariable("appointmentId") @Min(value = 1) @NotNull Long appointmentId) {
        return new ResponseEntity<>(doctorService.setAppointmentToApprovedID(appointmentId), HttpStatus.OK);
    }

    /**
     * Sets appointment declined.
     *
     * @param appointmentId the appointment id
     * @return the full dto appointment
     */
    @Operation(summary = "This request method sets appointment to status declined")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return updated appointment"),
            @ApiResponse(responseCode = "400", description = "The request body is not correct"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Appointment not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @PutMapping("/declined/{appointmentId}")
    public ResponseEntity<FullAppointmentDTO> setDeclinedId(@PathVariable("appointmentId") @Min(value = 1) @NotNull Long appointmentId) {
        return new ResponseEntity<>(doctorService.setAppointmentToDeclinedID(appointmentId), HttpStatus.OK);
    }


}
