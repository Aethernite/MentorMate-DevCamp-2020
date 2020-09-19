package com.mentormate.devcamp.application.presentation.controller;

import com.mentormate.devcamp.application.business.service.AppointmentService;
import com.mentormate.devcamp.application.persistence.dto.AppointmentDTO;
import com.mentormate.devcamp.application.persistence.dto.FullAppointmentDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * The Appointment controller.
 */
@RequiredArgsConstructor
@RequestMapping("/api/v1/appointments")
@RestController
public class AppointmentController {

    private final AppointmentService appointmentService;

    /**
     * Create appointment response entity.
     *
     * @param appointmentDTO the appointment dto
     * @return the response entity
     */
    @Operation(summary = "This request method is used for creating new appointment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Appointment is created successfully"),
            @ApiResponse(responseCode = "400", description = "The request body is not correct"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @PostMapping
    public ResponseEntity<FullAppointmentDTO> createAppointment(@RequestBody @Valid AppointmentDTO appointmentDTO) {
        return new ResponseEntity<>(appointmentService.createAppointment(appointmentDTO), HttpStatus.CREATED);
    }

    /**
     * Gets appointment by id.
     *
     * @param appointmentID the appointment id
     * @return the appointment by id
     */
    @Operation(summary = "This request method return appointment by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return appointment"),
            @ApiResponse(responseCode = "404", description = "Appointment not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @GetMapping("/{appointmentId}")
    public ResponseEntity<FullAppointmentDTO> getAppointmentById(@PathVariable("appointmentId") @Min(value = 1) Long appointmentID) {
        return new ResponseEntity<>(appointmentService.getAppointmentById(appointmentID), HttpStatus.OK);
    }

    /**
     * Update appointment by id.
     *
     * @param appointmentId  the appointment id
     * @param appointmentDTO the appointment dto
     * @return the updated appointment dto
     */
    @Operation(summary = "This request method update appointment by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return updated appointment"),
            @ApiResponse(responseCode = "400", description = "The request body is not correct"),
            @ApiResponse(responseCode = "404", description = "Appointment not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @PutMapping("/{appointmentId}")
    public ResponseEntity<FullAppointmentDTO> updateAppointmentById(@PathVariable("appointmentId") @Min(value = 1) @NotNull Long appointmentId, @Valid @RequestBody AppointmentDTO appointmentDTO) {
        return new ResponseEntity<>(appointmentService.updateAppointmentById(appointmentId, appointmentDTO), HttpStatus.OK);
    }

    /**
     * Delete appointment by id.
     *
     * @param appointmentId the appointment id
     * @return the deleted appointment dto
     */
    @Operation(summary = "This request method delete appointment by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted appointment"),
            @ApiResponse(responseCode = "404", description = "Appointment not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<FullAppointmentDTO> deleteAppointmentById(@PathVariable("appointmentId") @Min(value = 1) @NotNull Long appointmentId) {
        return new ResponseEntity<>(appointmentService.deleteAppointmentById(appointmentId), HttpStatus.OK);
    }

    /**
     * Gets all appointments.
     *
     * @param page the page
     * @return all the appointments
     */
    @Operation(summary = "This request method return all of the appointments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return page of appointments"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @GetMapping(params = {"page"})
    public ResponseEntity<Page<FullAppointmentDTO>> getAll(@RequestParam("page") int page) {
        return new ResponseEntity<>(appointmentService.findPaginated(page), HttpStatus.OK);
    }
    
}
