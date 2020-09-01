package com.mentormate.devcamp.game.hero;

import java.util.Random;

/**
 * The type Assassin subclass of Hero.
 */
public class Assassin extends Hero {
    private final Random random;
    private static final double CRIT_CHANCE = 0.3000; //30% Critical Chance
    private static final int CRIT_DAMAGE_MULTIPLIER = 3; //300% Critical Damage

    /**
     * Instantiates a new Assassin.
     *
     * @param health the health
     * @param attack the attack
     * @param armor  the armor
     */
    public Assassin(int health, int attack, int armor) {
        super(health, attack, armor);
        random = new Random();
    }


    @Override
    public void attack(Hero hero) {
        long points = Math.round(attack * (random.nextDouble() * (1.2 - 0.8) + 0.8));
        if (isCriticalStriking()) {
            points = this.attack * CRIT_DAMAGE_MULTIPLIER;
        }
        System.out.println(String.format("He deals: %d damage!", points));

        hero.takeDamage(points);
    }

    /**
     * Calculates a chance to critical strike.
     * 
     * @return boolean if the hero is critical striking
     */
    private boolean isCriticalStriking() {
        double chance = new Random().nextDouble();
        return chance <= CRIT_CHANCE;
    }
}
