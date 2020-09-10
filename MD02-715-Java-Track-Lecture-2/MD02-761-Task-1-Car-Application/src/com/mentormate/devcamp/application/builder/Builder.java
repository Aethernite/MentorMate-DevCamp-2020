package com.mentormate.devcamp.application.builder;

import com.mentormate.devcamp.application.entity.Car;
import com.mentormate.devcamp.application.component.Color;
import com.mentormate.devcamp.application.component.SteeringWheel;
import com.mentormate.devcamp.application.component.Transmission;

import java.time.Year;

/**
 * The interface Builder.
 */
public interface Builder {
    void setDoors(int doors);

    void setSeats(int seats);

    void setColor(Color color);

    void setYear(Year year);

    void setSteeringWheel(SteeringWheel steeringWheel);

    void setTransmission(Transmission transmission);

    void setCurrentShift(int shift);

    void setWeight(double weight);

    void setConsumption(double consumption);

    Car getResult();
}
