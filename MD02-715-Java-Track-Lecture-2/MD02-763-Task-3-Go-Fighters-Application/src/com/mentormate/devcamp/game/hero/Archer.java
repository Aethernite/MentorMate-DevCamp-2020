package com.mentormate.devcamp.game.hero;

/**
 * The type Archer subclass of Hero.
 * <p>
 * <p>
 * The Archer is a new class not defined in the task.
 * <p>
 * Stats:
 * - Passive: 26% evade chance to evade all of the incoming damage.
 * <p>
 * - Special ability: Devastating Arrows - splits his arrow lowering the damage of his attack
 * but creates multiple arrows from the arrow that was split
 * <p>
 * - Passive: Every 4th attack unleash Devastating Arrows
 * <p>
 * - Passive: Every Special Ability used increases the arrow multiplier for the next Devastating Arrows
 */
public class Archer extends Hero {
    private int arrowMultiplier = 3;
    private int attacks = 1;
    private static final double SPLIT_ARROW_DAMAGE = 0.5;

    /**
     * Instantiates a new Archer.
     *
     * @param health the health
     * @param attack the attack
     * @param armor  the armor
     */
    public Archer(int health, int attack, int armor) {
        super(health, attack, armor);
        EVADE_CHANCE = 0.2600;
    }

    @Override
    public void attack(Hero hero) {
        long points = Math.round(randomizeValueByPercentage(attack));
        if (isDevastatingArrows()) {
            points = Math.round((this.attack * SPLIT_ARROW_DAMAGE) * arrowMultiplier++);
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
        long damageTaken = points - Math.round(randomizeValueByPercentage(armor));
        if (damageTaken < 0) {
            damageTaken = 0;
        }
        System.out.println(String.format("He takes: %d damage!", damageTaken));
        health -= damageTaken;
    }

}
