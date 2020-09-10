package com.mentormate.devcamp.task.animal;

/**
 * The abstract class Animal.
 */
public abstract class Animal implements Sound {

    /**
     * Contains the type of the animal as string.
     */
    private final String type;
    private final String sound;


    /**
     * Instantiates a new Animal.
     *
     * @param type  the type of animal
     * @param sound the sound of animal
     */
    public Animal(String type, String sound) {
        this.type = type;
        this.sound = sound;
    }

    /**
     * Gets the type of animal.
     *
     * @return the type of the animal
     */
    public String getType() {
        return type;
    }

    @Override
    public String getSound() {
        return sound;
    }

}
