package com.mentormate.devcamp.task.animal;

/**
 * The type Duck.
 */
public class Duck extends Animal {
    /**
     * Instantiates a new Duck.
     */
    public Duck() {
        this.type = "Duck";
    }

    @Override
    public String getSound() {
        return "Quack";
    }
}
