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
            System.out.println("Old McDonald had a farm, E-I-E-I-O\n"
                    + "And on his farm he had a "
                    + animal.getType()
                    + ", E-I-E-I-O\n"
                    + "With a "
                    + animal.getSound()
                    + " "
                    + animal.getSound()
                    + " here and a "
                    + animal.getSound()
                    + " "
                    + animal.getSound()
                    + " there\n"
                    + animal.getSound() + " here "
                    + animal.getSound() + " there, everywhere "
                    + animal.getSound() + " "
                    + animal.getSound()
                    + "\n" + "Old McDonald had a farm, E-I-E-I-O");
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



