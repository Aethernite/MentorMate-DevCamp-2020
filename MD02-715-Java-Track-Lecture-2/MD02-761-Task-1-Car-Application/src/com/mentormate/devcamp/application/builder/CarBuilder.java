package com.mentormate.devcamp.application.builder;

import com.mentormate.devcamp.application.entity.Car;
import com.mentormate.devcamp.application.component.Color;
import com.mentormate.devcamp.application.component.SteeringWheel;
import com.mentormate.devcamp.application.component.Transmission;

import java.time.Year;

/**
 * The type Car builder that implements the Buiilder and completes the Builder Design Pattern.
 */
public class CarBuilder implements Builder {
    private int doors;
    private int seats;
    private Color color;
    private Year creationYear;
    private SteeringWheel steeringWheel;
    private Transmission transmission = Transmission.MANUAL;
    private int currentShift;
    private double weight;
    private double consumption;

    @Override
    public void setDoors(int doors) {
        this.doors = doors;
    }

    @Override
    public void setSeats(int seats) {
        if (seats > 8) {
            throw new IllegalArgumentException("The seats must be maximum 8.");
        }
        this.seats = seats;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public void setYear(Year year) {
        this.creationYear = year;
    }

    @Override
    public void setSteeringWheel(SteeringWheel steeringWheel) {
        this.steeringWheel = steeringWheel;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setCurrentShift(int currentShift) {
        if (currentShift > 5 || currentShift < 1) {
            throw new IllegalArgumentException("The shift must be between 1 and 5.");
        }
        this.currentShift = currentShift;

    }

    @Override
    public void setWeight(double weight) {
        if (weight < 500 || weight > 3500) {
            throw new IllegalArgumentException("The weight must be between 500 and 3500.");
        }
        this.weight = weight;
    }

    @Override
    public void setConsumption(double consumption) {
        if (consumption < 3.3 || consumption > 13.5) {
            throw new IllegalArgumentException("The consumption must be between 3.3 and 13.5.");
        }
        this.consumption = consumption;
    }

    public Car getResult() {
        return new Car(doors, seats, color, creationYear, steeringWheel, transmission, currentShift, weight, consumption);
    }
}
