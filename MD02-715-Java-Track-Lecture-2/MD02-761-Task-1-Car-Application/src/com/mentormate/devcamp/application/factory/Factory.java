package com.mentormate.devcamp.application.factory;

import com.mentormate.devcamp.application.builder.Builder;

/**
 * The interface Factory.
 */
public interface Factory {
	
    /**
     * Construct city car.
     *
     * @param builder the builder
     */
    void constructCityCar(Builder builder);

    /**
     * Construct suv.
     *
     * @param builder the builder
     */
    void constructSUV(Builder builder);

    /**
     * Construct sports car.
     *
     * @param builder the builder
     */
    void constructSportsCar(Builder builder);
}
