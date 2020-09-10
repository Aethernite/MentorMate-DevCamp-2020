package com.mentormate.devcamp.application.entity;

import com.mentormate.devcamp.application.component.Color;
import com.mentormate.devcamp.application.component.SteeringWheel;
import com.mentormate.devcamp.application.component.Transmission;

import java.time.Year;

/**
 * The type Car.
 */
public class Car {
    private int doors;
    private int seats;
    private Color color;
    private Year creationYear;
    private SteeringWheel steeringWheel;
    private Transmission transmission;
    private int currentShift;
    private double weight;
    private double consumption;

    /**
     * Instantiates a new Car.
     *
     * @param doors         the doors
     * @param seats         the seats
     * @param color         the color
     * @param creationYear  the creation year
     * @param steeringWheel the steering wheel
     * @param transmission  the transmission
     * @param currentShift  the current shift
     * @param weight        the weight
     * @param consumption   the consumption
     */
    public Car(int doors, int seats, Color color, Year creationYear, SteeringWheel steeringWheel, Transmission transmission, int currentShift, double weight, double consumption) {
        this.doors = doors;
        this.seats = seats;
        this.color = color;
        this.creationYear = creationYear;
        this.steeringWheel = steeringWheel;
        this.transmission = transmission;
        this.currentShift = currentShift;
        this.weight = weight;
        this.consumption = consumption;
    }

    /**
     * Compare color boolean.
     *
     * @param color the color
     * @return true if colors are equal
     */
    public boolean compareColor(Color color) {
        return this.color==color;
    }

    /**
     * Compare shift boolean.
     *
     * @param shift the shift
     * @return true if the shifts are equal and false if they are not
     */
    public boolean compareGear(int shift) {
        return this.currentShift==shift;
    }

    /**
     * Shifts up the car increasing it's shift by one.
     */
    public void shiftUp() {
        if (currentShift < 5) {
            this.currentShift++;
        }
    }

    /**
     * Shifts down the car increasing it's shift by one.
     */
    public void shiftDown() {
        if (currentShift > 1) {
            this.currentShift--;
        }
    }

    /**
     * Checks if the car can fit certain number of passengers
     *
     * @param passengers number of the passengers
     * @return true if the car can fit certain number of passengers and false if it can't
     */
    public boolean canFitPassengers(int passengers) {
        return seats - 1 >= passengers;
    }

    /**
     * Can endure given weight calculated by number of passengers and bags.
     *
     * @param passengers the number of passengers
     * @param bags       the number of bags
     * @return true if the car can endure/fit the weight of the passengers and bags and false if it can't
     */
    public boolean canFit(int passengers, int bags) {
        return (passengers * Weights.PASSENGER_WEIGHT) + (bags * Weights.BAG_WEIGHT + weight) < 3500;
    }

    /**
     * Gets needed fuel for getting to a destination.
     *
     * @param destination the destination
     * @return the fuel for destination
     */
    public double getFuelForDestination(double destination) {
        return (destination / 100.00) * consumption;
    }


    /**
     * Gets doors.
     *
     * @return the doors
     */
    public int getDoors() {
        return doors;
    }

    /**
     * Gets seats.
     *
     * @return the seats
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Gets creation year.
     *
     * @return the creation year
     */
    public Year getCreationYear() {
        return creationYear;
    }

    /**
     * Gets steering wheel.
     *
     * @return the steering wheel
     */
    public SteeringWheel getSteeringWheel() {
        return steeringWheel;
    }

    /**
     * Gets transmission.
     *
     * @return the transmission
     */
    public Transmission getTransmission() {
        return transmission;
    }

    /**
     * Gets current shift.
     *
     * @return the current shift
     */
    public int getCurrentShift() {
        return currentShift;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Gets consumption.
     *
     * @return the consumption
     */
    public double getConsumption() {
        return consumption;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car information:").append(System.lineSeparator())
                .append("Color: ").append(this.color.toString()).append(System.lineSeparator())
                .append("Doors: ").append(this.doors).append(System.lineSeparator())
                .append("Seats: ").append(this.seats).append(System.lineSeparator())
                .append("Year of production: ").append(this.creationYear.getValue()).append(System.lineSeparator())
                .append("Weight: ").append(this.weight).append(System.lineSeparator())
                .append("Steering wheel: ").append(this.steeringWheel).append(System.lineSeparator())
                .append("Transmission: ").append(this.transmission).append(System.lineSeparator())
                .append("Current shift: ").append(this.currentShift).append(System.lineSeparator())
                .append("Consumption: ").append(this.consumption).append(System.lineSeparator());

        return sb.toString();
    }

}
