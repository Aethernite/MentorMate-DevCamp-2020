package com.mentormate.devcamp.application.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

/**
 * The entity Bill.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private Instant date;
    @OneToOne
    private User user;
    private static final int FIVE_DOLLARS = 5;

    /**
     * Instantiates a new Bill.
     *
     * @param price  the price
     * @param logged the logged account
     */
    public Bill(double price, User logged) {
        this.price = price;
        this.user = logged;
    }

    /**
     * Calculate with discount by user double.
     *
     * @param user the user
     * @return the double
     */
    public double calculateWithDiscountByUser(User user) {
        if (user.getDiscount()==0.00) {
            int bills = (int) Math.floor(this.price / 100);
            return price - bills * FIVE_DOLLARS;
        }
        return price -= price * user.getDiscount();
    }
}
