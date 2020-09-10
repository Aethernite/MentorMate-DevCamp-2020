package com.mentormate.devcamp.game.hero;

import java.util.Random;

/**
 * The Hero abstract class.
 */
public abstract class Hero {
    /**
     * The Health of the hero.
     */
    protected long health;
    /**
     * The Attack of the hero.
     */
    protected long attack;
    /**
     * The Armor of the hero.
     */
    protected long armor;
    /**
     * The boolean Is Alive used for indication if a hero is alive (true) or dead (false).
     */
    protected boolean isAlive;
    /**
     * The constant random used for generating random numbers.
     */
    protected static Random random;
    /**
     * The constant MAX_PERCENTAGE used in generating random for multiplying with attack or armor.
     */
    protected static final double MAX_PERCENTAGE = 1.2; //120% multiplier
    /**
     * The constant MIN_PERCENTAGE used in generating random for multiplying with attack or armor.
     */
    protected static final double MIN_PERCENTAGE = 0.8; //80% multiplier
    /**
     * The Block chance for the hero.
     */
    protected double BLOCK_CHANCE = 0;
    /**
     * The Crit chance for the hero.
     */
    protected double CRIT_CHANCE = 0;
    /**
     * The Evade chance for the hero.
     */
    protected double EVADE_CHANCE = 0;
    /**
     * The Crit damage multiplier for the hero.
     */
    protected int CRIT_DAMAGE_MULTIPLIER = 0;

    static {
        random = new Random();
    }

    /**
     * Instantiates a new Hero subclass.
     */
    public Hero() {
    }

    /**
     * Instantiates a new Hero subclass.
     *
     * @param health the health
     * @param attack the attack
     * @param armor  the armor
     */
    protected Hero(long health, long attack, long armor) {
        this.health = health;
        this.attack = attack;
        this.armor = armor;
        this.isAlive = true;
    }

    /**
     * Is alive boolean.
     *
     * @return boolean if the hero is alive
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Gets health.
     *
     * @return the health
     */
    public long getHealth() {
        return health;
    }

    /**
     * Attacks a hero.
     *
     * @param hero the hero
     */
    public void attack(Hero hero) {
        long points = Math.round(randomizeValueByPercentage(attack));
        System.out.println(String.format("He deals: %d damage!", points));
        hero.takeDamage(points);
    }

    /**
     * Takes damage.
     *
     * @param points the points
     */
    public void takeDamage(long points) {
        long damageTaken = points - Math.round(randomizeValueByPercentage(armor));
        if (damageTaken < 0) {
            damageTaken = 0;
        }
        System.out.println(String.format("He takes: %d damage!", damageTaken));
        health -= damageTaken;
    }

    /**
     * Randomize value by percentage double.
     *
     * @param value the value
     * @return the double
     */
    protected double randomizeValueByPercentage(long value) {
        return value * (random.nextDouble() * (MAX_PERCENTAGE - MIN_PERCENTAGE) + MIN_PERCENTAGE);
    }

    /**
     * Calculates a chance to block an attack.
     *
     * @return boolean if the hero is blocking
     */
    protected boolean isBlocking() {
        double chance = random.nextDouble();
        return chance <= BLOCK_CHANCE;
    }

    /**
     * Calculates a chance to critical strike.
     *
     * @return boolean if the hero is critical striking
     */
    protected boolean isCriticalStriking() {
        double chance = random.nextDouble();
        return chance <= CRIT_CHANCE;
    }

    /**
     * Calculates a chance to block an attack.
     *
     * @return boolean if the hero is blocking
     */
    protected boolean isEvading() {
        double chance = random.nextDouble();
        return chance <= EVADE_CHANCE;
    }
}
