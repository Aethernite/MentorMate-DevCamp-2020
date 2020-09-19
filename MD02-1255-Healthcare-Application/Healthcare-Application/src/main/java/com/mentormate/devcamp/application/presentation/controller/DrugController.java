package com.mentormate.devcamp.application.presentation.controller;

import com.mentormate.devcamp.application.business.service.DrugService;
import com.mentormate.devcamp.application.persistence.dto.DrugDTO;
import com.mentormate.devcamp.application.persistence.dto.FullDrugDTO;
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
 * The Drug controller.
 * <p>
 * This controller is responsible for all of the CRUD operations of the {@link com.mentormate.devcamp.application.persistence.entity.Drug} entity
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/doctors/drugs")
public class DrugController {

    private final DrugService drugService;

    /**
     * Create drug response entity.
     *
     * @param drugDTO the drug dto
     * @return the response entity
     */
    @Operation(summary = "This request method is used for creating new drug")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Drug is created successfully"),
            @ApiResponse(responseCode = "400", description = "The request body is not correct"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @PostMapping
    public ResponseEntity<FullDrugDTO> createDrug(@RequestBody @Valid DrugDTO drugDTO) {
        return new ResponseEntity<>(drugService.createDrug(drugDTO), HttpStatus.CREATED);
    }

    /**
     * Get all response entity.
     *
     * @return the response entity
     */
    @Operation(summary = "This request method return all of our drugs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return page of drugs"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @GetMapping(params = {"page"})
    public ResponseEntity<Page<FullDrugDTO>> getAll(@RequestParam("page") int page) {
        return new ResponseEntity<>(drugService.findPaginated(page), HttpStatus.OK);
    }

    /**
     * Gets drug by id.
     *
     * @param drugID the drug id
     * @return the drug by id
     */
    @Operation(summary = "This request method return drug by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return drug"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Drug not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @GetMapping("/{drugId}")
    public ResponseEntity<FullDrugDTO> getDrugById(@PathVariable("drugId") @Min(value = 1) Long drugID) {
        return new ResponseEntity<>(drugService.getDrugById(drugID), HttpStatus.OK);
    }

    /**
     * Update drug by id response entity.
     *
     * @param drugId  the drug id
     * @param drugDTO the drug dto
     * @return the response entity
     */
    @Operation(summary = "This request method update drug by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return updated drug"),
            @ApiResponse(responseCode = "400", description = "The request body is not correct"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Drug not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @PutMapping("/{drugId}")
    public ResponseEntity<FullDrugDTO> updateDrugById(@PathVariable("drugId") @Min(value = 1) @NotNull Long drugId, @Valid @RequestBody DrugDTO drugDTO) {
        return new ResponseEntity<>(drugService.updateDrugByID(drugId, drugDTO), HttpStatus.OK);
    }

    /**
     * Delete drug by id response entity.
     *
     * @param drugId the drug id
     * @return the response entity
     */
    @Operation(summary = "This request method delete drug by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted drug"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Drug not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @DeleteMapping("/{drugId}")
    public ResponseEntity<FullDrugDTO> deleteDrugById(@PathVariable("drugId") @Min(value = 1) @NotNull Long drugId) {
        return new ResponseEntity<>(drugService.deleteDrugByID(drugId), HttpStatus.OK);
    }

}
