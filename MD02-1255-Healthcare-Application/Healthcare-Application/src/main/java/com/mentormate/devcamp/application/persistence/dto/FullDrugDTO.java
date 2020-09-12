package com.mentormate.devcamp.application.persistence.dto;

import com.mentormate.devcamp.application.persistence.entity.Drug;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The Full Drug DTO.
 * <p>
 * Data transfer object for the {@link Drug} including the Id of the entity
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class FullDrugDTO {
    private Long id;
    
    @NotNull
    @Size(min = 3, max = 255)
    private String name;

    @NotNull
    @Size(min = 3, max = 255)
    @Column(name = "chemical_name")
    private String chemicalName;

    @NotNull
    @Size(min = 3, max = 255)
    @Column(name = "country_of_origin")
    private String originCountry;

    @NotNull
    private double price;
}
