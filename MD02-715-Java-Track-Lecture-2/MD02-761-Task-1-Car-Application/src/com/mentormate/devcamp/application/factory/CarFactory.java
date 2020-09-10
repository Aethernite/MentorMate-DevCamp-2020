package com.mentormate.devcamp.application.factory;

import com.mentormate.devcamp.application.builder.Builder;
import com.mentormate.devcamp.application.component.Color;
import com.mentormate.devcamp.application.component.SteeringWheel;
import com.mentormate.devcamp.application.component.Transmission;

import java.time.Year;

/**
 * The Car factory.
 */
public class CarFactory implements Factory {

    public void constructSportsCar(Builder builder) {
        builder.setColor(Color.RED);
        builder.setDoors(2);
        builder.setSeats(2);
        builder.setYear(Year.now());
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setSteeringWheel(SteeringWheel.RIGHT_STEERING_WHEEL);
        builder.setCurrentShift(5);
        builder.setWeight(1500);
        builder.setConsumption(12.00);
    }

    public void constructCityCar(Builder builder) {
        builder.setColor(Color.BLACK);
        builder.setDoors(4);
        builder.setSeats(4);
        builder.setYear(Year.of(2015));
        builder.setTransmission(Transmission.MANUAL);
        builder.setSteeringWheel(SteeringWheel.LEFT_STEERING_WHEEL);
        builder.setCurrentShift(3);
        builder.setWeight(1900);
        builder.setConsumption(7.00);
    }

    public void constructSUV(Builder builder) {
        builder.setColor(Color.GREEN);
        builder.setDoors(5);
        builder.setSeats(6);
        builder.setYear(Year.of(2018));
        builder.setTransmission(Transmission.MANUAL);
        builder.setSteeringWheel(SteeringWheel.LEFT_STEERING_WHEEL);
        builder.setCurrentShift(4);
        builder.setWeight(2500);
        builder.setConsumption(9.00);
    }
}
