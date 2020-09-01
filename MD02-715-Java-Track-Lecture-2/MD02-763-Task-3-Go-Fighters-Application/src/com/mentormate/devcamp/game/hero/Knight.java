package com.mentormate.devcamp.game.hero;

import java.util.Random;

/**
 * The type Knight subclass of Hero.
 */
public class Knight extends Hero {
    private final Random random;
    private static final double BLOCK_CHANCE = 0.2000; //20% Block Chance
    private static final double CRIT_CHANCE = 0.1000; //10% Critical Chance
    private static final int CRIT_DAMAGE_MULTIPLIER = 2; //200% Critical Damage

    /**
     * Instantiates a new Knight.
     *
     * @param health the health
     * @param attack the attack
     * @param armor  the armor
     */
    public Knight(int health, int attack, int armor) {
        super(health, attack, armor);
        random = new Random();
    }

    @Override
    public void attack(Hero hero){
        long points = Math.round(attack * (random.nextDouble()*(1.2-0.8) + 0.8));
        if(isCriticalStriking()){
            points = attack * CRIT_DAMAGE_MULTIPLIER;
        }
        System.out.println(String.format("He deals: %d damage!",points));
        hero.takeDamage(points);
    }

    /**
     * Calculates a chance to critical strike.
     *
     * @return boolean if the hero is critical striking
     */
    private boolean isCriticalStriking(){
        double chance = new Random().nextDouble();
        return chance <= CRIT_CHANCE;
    }

    @Override
    public void takeDamage(long points){
        if (isBlocking()){
            System.out.println("He blocks!");
            return;
        }
        long damageTaken = points - Math.round(armor*(random.nextDouble()*(1.2-0.8) + 0.8));
        if(damageTaken <0){
            damageTaken = 0;
        }
        System.out.println(String.format("He takes: %d damage!",damageTaken));
        health-=damageTaken;
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
