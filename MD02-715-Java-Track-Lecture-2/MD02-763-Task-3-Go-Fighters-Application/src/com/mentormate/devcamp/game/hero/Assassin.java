package com.mentormate.devcamp.game.hero;

/**
 * The type Assassin subclass of Hero.
 */
public class Assassin extends Hero {

    /**
     * Instantiates a new Assassin.
     *
     * @param health the health
     * @param attack the attack
     * @param armor  the armor
     */
    public Assassin(int health, int attack, int armor) {
        super(health, attack, armor);
        this.CRIT_CHANCE = 0.3000;
        this.CRIT_DAMAGE_MULTIPLIER = 3;
    }

    @Override
    public void attack(Hero hero) {
        long points = Math.round(randomizeValueByPercentage(attack));
        if (isCriticalStriking()) {
            points = this.attack * CRIT_DAMAGE_MULTIPLIER;
        }
        System.out.println(String.format("He deals: %d damage!", points));

        hero.takeDamage(points);
    }

}
