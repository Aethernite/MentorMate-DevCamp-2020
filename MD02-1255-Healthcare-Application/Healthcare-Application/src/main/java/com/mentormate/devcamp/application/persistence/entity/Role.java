package com.mentormate.devcamp.application.persistence.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * The entity Role.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "roles")
public class Role extends BaseEntity implements GrantedAuthority {

    @Enumerated(EnumType.STRING)
    private RoleType name;

    @Override
    public String getAuthority() {
        return name.name();
    }

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
