package com.mentormate.devcamp.game.hero;


import java.util.Random;

/**
 * The type Hero abstract class.
 */
public abstract class Hero {
    protected long health;
    protected long attack;
    protected long armor;
    protected boolean isAlive;
    private Random random;

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
        random = new Random();
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
    public void attack(Hero hero){
        long points = Math.round(attack * (random.nextDouble()*(1.2-0.8) + 0.8));
        System.out.println(String.format("He deals: %d damage!",points));
        hero.takeDamage(points);
    }

    /**
     * Takes damage.
     *
     * @param points the points
     */
    public void takeDamage(long points){
        long damageTaken = points - Math.round(armor*(random.nextDouble()*(1.2-0.8) + 0.8));
        if(damageTaken < 0){
            damageTaken = 0;
        }
        System.out.println(String.format("He takes: %d damage!",damageTaken));
        health-=damageTaken;
    }
}
