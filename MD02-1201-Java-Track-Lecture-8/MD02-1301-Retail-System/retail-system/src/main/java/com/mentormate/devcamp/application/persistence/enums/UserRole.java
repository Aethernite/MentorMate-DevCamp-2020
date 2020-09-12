package com.mentormate.devcamp.application.persistence.enums;

import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * The enum User role.
 */
public enum UserRole {
    /**
     * Affiliate user role.
     */
    AFFILIATE,
    /**
     * Customer user role.
     */
    CUSTOMER,
    /**
     * Employee user role.
     */
    EMPLOYEE;

    /**
     * Gets a discount percentage depending on the role of the account.
     *
     * @param role        the role
     * @param dateCreated the date of creation of the user
     * @return the discount
     */
    public static double getDiscount(UserRole role, Instant dateCreated) {
        double discount = 0.00;
        switch (role) {
            case AFFILIATE:
                discount = 0.1;
                break;
            case EMPLOYEE:
                discount = 0.3;
                break;
            case CUSTOMER:
                long customerYears = ChronoUnit.YEARS.between(dateCreated.atZone(ZoneId.systemDefault()),
                        Instant.now().atZone(ZoneId.systemDefault()));

                if (customerYears >= 2) {
                    discount = 0.05;
                }
                break;
        }
        return discount;
    }
}
