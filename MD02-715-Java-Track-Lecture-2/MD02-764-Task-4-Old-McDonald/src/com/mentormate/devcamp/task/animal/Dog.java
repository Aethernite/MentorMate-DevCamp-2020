package com.mentormate.devcamp.task.animal;

/**
 * The type Dog.
 */
public class Dog extends Animal {
    /**
     * Instantiates a new Dog.
     */
    public Dog() {
        this.type = "Dog";
    }

    @Override
    public String getSound() {
        return "Woof";
    }
}
