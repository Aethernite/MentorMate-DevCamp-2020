package com.mentormate.devcamp.application.persistence.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * The entity Drug.
 * <p>
 * This entity contains useful information about certain medicine drugs
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Drug extends BaseEntity {
    @NotBlank
    @Size(min = 3, max = 255)
    private String name;

    @NotBlank
    @Size(min = 3, max = 255)
    @Column(name = "chemical_name")
    private String chemicalName;

    @NotBlank
    @Size(min = 3, max = 255)
    @Column(name = "country_of_origin")
    private String originCountry;

    @NotNull
    private double price;

    /**
     * This method is responsible to update the {@link Drug} with new information
     *
     * @param updated {@link Drug} drug object that contains all information without databaseId
     */
    public void update(Drug updated) {
        this.name = updated.name;
        this.chemicalName = updated.chemicalName;
        this.originCountry = updated.originCountry;
        this.price = updated.price;
    }

}
