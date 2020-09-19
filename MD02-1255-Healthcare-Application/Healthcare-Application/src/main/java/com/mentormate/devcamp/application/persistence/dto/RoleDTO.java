package com.mentormate.devcamp.application.persistence.dto;

import com.mentormate.devcamp.application.persistence.entity.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * The Role DTO.
 * <p>
 * Contains the role name and the id is excluded
 */
@Schema(description = "The username of the client", allowableValues = "name")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Validated
public class RoleDTO {
    @NotNull
    @Schema(description = "The name of the role")
    private Role.RoleType name;

    /**
     * The enum Role type.
     */
    public enum RoleType {
        /**
         * Customer role type.
         */
        CUSTOMER,
        /**
         * Doctor role type.
         */
        DOCTOR;
    }
}
