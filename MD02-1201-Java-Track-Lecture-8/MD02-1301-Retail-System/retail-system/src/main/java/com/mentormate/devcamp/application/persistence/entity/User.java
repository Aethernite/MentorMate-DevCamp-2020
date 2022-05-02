package com.mentormate.devcamp.application.persistence.entity;

import com.mentormate.devcamp.application.persistence.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

/**
 * The entity User.
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User extends BaseEntity {

    @NotNull
    @Column(name = "Username", length = 60, nullable = false)
    private String username;

    @NotNull
    @Column(name = "First_Name", length = 40, nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "Last_Name", length = 60, nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "Email", length = 60, nullable = false)
    private String email;

    @NotNull
    @Enumerated
    private UserRole userRole;

    @NotNull
    @Column(name = "Date_Created", nullable = false)
    private Instant dateCreated;

    @Column(name = "Date_Edited")
    private Instant dateEdited;

    @Column(name = "Discount")
    private double discount;

    /**
     * Instantiates a new User.
     *
     * @param username  the username
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     * @param userRole  the user role
     */
    public User(@NotNull String username, @NotNull String firstName, @NotNull String lastName, @NotNull String email, @NotNull UserRole userRole) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userRole = userRole;
        dateCreated = Instant.now();
        setDiscount();
    }

    /**
     * Sets discount depending on the role.
     */
    public void setDiscount() {
        this.discount = UserRole.getDiscount(this.userRole, dateCreated);
    }
}
