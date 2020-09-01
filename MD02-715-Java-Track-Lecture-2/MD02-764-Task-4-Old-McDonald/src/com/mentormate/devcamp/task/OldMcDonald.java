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
            StringBuilder sb = new StringBuilder();
            sb.append("Old McDonald had a farm, E-I-E-I-O\n")
                    .append("And on his farm he had a ")
                    .append(animal.getType())
                    .append(", E-I-E-I-O\n")
                    .append("With a ")
                    .append(animal.getSound())
                    .append(" ")
                    .append(animal.getSound())
                    .append(" here and a ")
                    .append(animal.getSound())
                    .append(" ")
                    .append(animal.getSound())
                    .append(" there\n")
                    .append(animal.getSound()).append(" here ")
                    .append(animal.getSound()).append(" there, everywhere ")
                    .append(animal.getSound()).append(" ")
                    .append(animal.getSound());
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



