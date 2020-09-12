package com.mentormate.devcamp.application.persistence.dto;

import com.mentormate.devcamp.application.persistence.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * The Role DTO.
 * <p>
 * Contains the role name and the id is excluded
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleDTO {
    @Enumerated(EnumType.STRING)
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
