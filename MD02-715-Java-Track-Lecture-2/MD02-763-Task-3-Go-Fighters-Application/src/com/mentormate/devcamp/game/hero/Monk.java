package com.mentormate.devcamp.game.hero;

/**
 * The type Monk subclass of Hero.
 */
public class Monk extends Hero {

    /**
     * Instantiates a new Monk.
     *
     * @param health the health
     * @param attack the attack
     * @param armor  the armor
     */
    public Monk(int health, int attack, int armor) {
        super(health, attack, armor);
        this.BLOCK_CHANCE = 0.3000; //30% Block Chance
    }

    @Override
    public void takeDamage(long points) {
        if (isBlocking()) {
            System.out.println("He blocks!");
            return;
        }
        long damageTaken = points - Math.round(randomizeValueByPercentage(armor));
        if (damageTaken < 0) {
            damageTaken = 0;
        }
        System.out.println(String.format("He takes: %d damage!", damageTaken));
        health -= damageTaken;
    }

}
