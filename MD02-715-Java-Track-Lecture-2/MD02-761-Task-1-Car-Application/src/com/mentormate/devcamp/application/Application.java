package com.mentormate.devcamp.application;

import com.mentormate.devcamp.application.builder.Builder;
import com.mentormate.devcamp.application.builder.CarBuilder;
import com.mentormate.devcamp.application.component.Color;
import com.mentormate.devcamp.application.entity.Car;
import com.mentormate.devcamp.application.factory.CarFactory;
import com.mentormate.devcamp.application.factory.Factory;

/**
 * The Car Application.
 */
public class Application {
    private final Builder carBuilder;
    private final Factory carFactory;

    /**
     * Instantiates a new Application.
     */
    public Application() {
        carBuilder = new CarBuilder();
        carFactory = new CarFactory();
    }

    /**
     * The start method of the application.
     */
    public void start() {
        carFactory.constructSportsCar(carBuilder);
        Car sportCar = carBuilder.getResult();
        printCar(sportCar);
        carFactory.constructCityCar(carBuilder);
        Car cityCar = carBuilder.getResult();
        printCar(cityCar);
        testCarMethods(sportCar);
    }

    private void testCarMethods(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append("Can the car endure 3 passengers and 2 bags: ").append(car.canFit(3, 2)).append(System.lineSeparator());
        sb.append("Is the car green: ").append(car.compareColor(Color.GREEN)).append(System.lineSeparator());
        sb.append("Can the car fit 5 passengers: ").append(car.canFitPassengers(5)).append(System.lineSeparator());
        sb.append("Get fuel needed for 578km: ").append(car.getFuelForDestination(578)).append(System.lineSeparator());
        car.shiftUp();
        sb.append("Car shift after shift up: ").append(car.getCurrentShift()).append(System.lineSeparator());
        car.shiftUp();
        sb.append("Car shift after shift up: ").append(car.getCurrentShift()).append(System.lineSeparator());
        car.shiftDown();
        sb.append("Car shift after shift down: ").append(car.getCurrentShift()).append(System.lineSeparator());
        sb.append("Is the car on shift 3: ").append(car.compareGear(3)).append(System.lineSeparator());
        System.out.println(sb.toString());
    }

    private void printCar(Car car) {
        System.out.println(car.toString());
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Application application = new Application();
        application.start();
    }
}
