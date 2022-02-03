package com.mentormate.devcamp.application.persistence.dto;

import com.mentormate.devcamp.application.persistence.entity.Drug;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The Drug DTO.
 * <p>
 * Data transfer object for the {@link Drug} excluding the Id of the entity
 */
@Schema(description = "Drug DTO is a DTO for the Drug entity. Id exclusive.", allowableValues = {"name", "chemicalName", "originCountry"})
@AllArgsConstructor
@NoArgsConstructor
@Data
@Validated
public class DrugDTO {
    @Schema(description = "The name of the drug.")
    @NotBlank
    @Size(min = 3, max = 255)
    private String name;

    @Schema(description = "The chemical name of the drug.")
    @NotBlank
    @Size(min = 3, max = 255)
    private String chemicalName;

    @Schema(description = "The country of origin of the drug.")
    @NotBlank
    @Size(min = 3, max = 255)
    private String originCountry;

    @Schema(description = "The price of the drug.")
    @NotNull
    private double price;

}
