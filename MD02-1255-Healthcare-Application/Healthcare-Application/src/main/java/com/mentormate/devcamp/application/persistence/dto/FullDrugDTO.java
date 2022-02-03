package com.mentormate.devcamp.application.persistence.dto;

import com.mentormate.devcamp.application.persistence.entity.Drug;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The Full Drug DTO.
 * <p>
 * Data transfer object for the {@link Drug} including the Id of the entity
 */
@Schema(description = "Full Drug DTO is a DTO for the Drug entity. Id inclusive.", allowableValues = {"id", "name", "chemicalName", "originCountry"})
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class FullDrugDTO {
    @Schema(description = "The id of the drug in the database.")
    private Long id;

    @Schema(description = "The name of the drug.")
    private String name;

    @Schema(description = "The chemical name of the drug.")
    private String chemicalName;

    @Schema(description = "The country of origin of the drug.")
    private String originCountry;

    @Schema(description = "The price of the drug.")
    private double price;

    @Schema(description = "The doctor that put the drug in the database.")
    private String createdBy;
}
