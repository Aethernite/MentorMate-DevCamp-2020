package com.mentormate.devcamp.task;

import com.mentormate.devcamp.task.animal.Animal;
import com.mentormate.devcamp.task.animal.Cow;
import com.mentormate.devcamp.task.animal.Dog;
import com.mentormate.devcamp.task.animal.Duck;

/**
 * The Old mc donald class containing the logic for generating the song from animals.
 */
public class OldMcDonald {
    private final Animal[] animals;

    /**
     * Instantiates a new Old mc donald object.
     */
    // Fixed farm size
    public OldMcDonald() {
        animals = new Animal[]{new Cow(), new Dog(), new Duck()};
    }

    /**
     * The sing method that generates the song from the animals.
     */
    public void sing() {
        for (Animal animal : animals) {
            String type = animal.getType();
            String sound = animal.getSound();
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("Old McDonald had a farm, E-I-E-I-O %n"))
                    .append(String.format("And on his farm he had a %1$s E-I-E-I-O %n", type))
                    .append(String.format("With a %1$s %1$s here and a %1$s %1$s there %n", sound))
                    .append(String.format("%1$s here %1$s there, %1$s everywhere", sound));
            System.out.println(sb.toString());
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        OldMcDonald oldMcDonald = new OldMcDonald();
        oldMcDonald.sing();
    }
}



