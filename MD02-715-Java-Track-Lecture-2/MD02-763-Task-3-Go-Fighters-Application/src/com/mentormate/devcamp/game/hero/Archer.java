package com.mentormate.devcamp.game.hero;

import java.util.Random;

/**
 * The type Archer subclass of Hero.
 * 
 * 
 * The Archer is a new class not defined in the task.
 * 
 * Stats:
 * - Passive: 26% evade chance to evade all of the incoming damage.
 * 
 * - Special ability: Devastating Arrows - splits his arrow lowering the damage of his attack 
 *   but creates multiple arrows from the arrow that was split
 *   
 * - Passive: Every 4th attack unleash Devastating Arrows
 * 
 * - Passive: Every Special Ability used increases the arrow multiplier for the next Devastating Arrows
 */
public class Archer extends Hero {
    private final Random random;
    private int arrowMultiplier = 3;
    private static final double EVADE_CHANCE = 0.2600;
    private int attacks = 1;

    /**
     * Instantiates a new Archer.
     *
     * @param health the health
     * @param attack the attack
     * @param armor  the armor
     */
    public Archer(int health, int attack, int armor) {
        super(health, attack, armor);
        random = new Random();
    }

    @Override
    public void attack(Hero hero) {
        long points = Math.round(attack * (random.nextDouble() * (1.2 - 0.8) + 0.8));
        if (isDevastatingArrows()) {
            points = Math.round((this.attack * 0.5) * arrowMultiplier++);
        }
        System.out.println(String.format("He shoots for: %d damage!", points));
        hero.takeDamage(points);
        attacks++;
    }

    /**
     * Calculates a chance to shoot devastating arrows.
     *
     * @return boolean if the hero can use devastating arrows
     */
    private boolean isDevastatingArrows() {
        return attacks % 4==0;
    }

    @Override
    public void takeDamage(long points) {
        if (isEvading()) {
            System.out.println("He evades!");
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
    private boolean isEvading() {
        double chance = random.nextDouble();
        return chance <= EVADE_CHANCE;
    }

}
