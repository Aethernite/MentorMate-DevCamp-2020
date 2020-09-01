package com.mentormate.devcamp.game.hero;

import java.util.Random;

/**
 * The type Monk subclass of Hero.
 */
public class Monk extends Hero {
    private final Random random;
    private static final double BLOCK_CHANCE = 0.3000; //30% Block Chance

    /**
     * Instantiates a new Monk.
     *
     * @param health the health
     * @param attack the attack
     * @param armor  the armor
     */
    public Monk(int health, int attack, int armor) {
        super(health, attack, armor);
        random = new Random();
    }

    @Override
    public void takeDamage(long points) {
        if (isBlocking()) {
            System.out.println("He blocks!");
            return;
        }
        long damageTaken = points - Math.round(armor * (random.nextDouble() * (1.2 - 0.8) + 0.8));
        if (damageTaken < 0) {
            damageTaken = 0;
        }
        System.out.println(String.format("He takes: %d damage!", damageTaken));
        health -= damageTaken;
    }

    /**
     * Calculates a chance to block an attack.
     *
     * @return boolean if the hero is blocking
     */
    private boolean isBlocking() {
        double chance = random.nextDouble();
        return chance <= BLOCK_CHANCE;
    }
}
