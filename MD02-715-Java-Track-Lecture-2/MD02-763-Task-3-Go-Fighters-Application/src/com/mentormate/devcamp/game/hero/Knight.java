package com.mentormate.devcamp.game.hero;

/**
 * The type Knight subclass of Hero.
 */
public class Knight extends Hero {

    /**
     * Instantiates a new Knight.
     *
     * @param health the health
     * @param attack the attack
     * @param armor  the armor
     */
    public Knight(int health, int attack, int armor) {
        super(health, attack, armor);
        this.BLOCK_CHANCE = 0.2000; //20% Block Chance
        this.CRIT_DAMAGE_MULTIPLIER = 2; //200% Critical Damage
        this.CRIT_CHANCE = 0.1000; //10% Critical Chance
    }

    @Override
    public void attack(Hero hero) {
        long points = Math.round(randomizeValueByPercentage(attack));
        if (isCriticalStriking()) {
            points = attack * CRIT_DAMAGE_MULTIPLIER;
        }
        System.out.println(String.format("He deals: %d damage!", points));
        hero.takeDamage(points);
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
