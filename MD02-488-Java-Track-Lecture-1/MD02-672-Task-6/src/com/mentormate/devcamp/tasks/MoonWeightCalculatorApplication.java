package com.mentormate.devcamp.tasks;

import java.util.Scanner;

/**
 * The Moon weight calculator application.
 */
public class MoonWeightCalculatorApplication {
    private double earthWeight;

    /**
     * The start method of the application.
     */
    public void start() {
        getUserInput();
        //Weight on the Moon = (Weight on Earth/9.81m/s2) * 1.622m/s2
        double weightOnMoon = (earthWeight / 9.81) * 1.622;
        System.out.println(String.format("Weight on moon: %.2f", weightOnMoon));

    }

    private void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Weight: ");
        earthWeight = scanner.nextDouble();
        scanner.close();
    }
}
