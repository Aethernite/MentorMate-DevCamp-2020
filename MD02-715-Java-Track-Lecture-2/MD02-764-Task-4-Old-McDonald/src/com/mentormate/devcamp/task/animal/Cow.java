package com.mentormate.devcamp.task.animal;

/**
 * The type Cow.
 */
public class Cow extends Animal {
    /**
     * Instantiates a new Cow.
     */
    public Cow() {
        this.type = "Cow";
    }

    @Override
    public String getSound() {
        return "Moo";
    }
}
