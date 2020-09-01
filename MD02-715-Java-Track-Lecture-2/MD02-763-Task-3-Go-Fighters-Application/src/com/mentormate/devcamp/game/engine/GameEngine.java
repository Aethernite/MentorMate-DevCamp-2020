package com.mentormate.devcamp.game.engine;

import com.mentormate.devcamp.game.hero.Hero;

import static java.lang.Thread.sleep;

/**
 * The Game engine that runs the Fight Game.
 */
public class GameEngine {

    /**
     * Fight method that takes two heroes as parameter and makes them fight to death!.
     *
     * @param hero  the hero
     * @param enemy the enemy
     * @throws InterruptedException Thread.sleep is used to slow the processing
     */
    public void fight(Hero hero, Hero enemy) throws InterruptedException {
        int round = 1;
        while (hero.isAlive() && enemy.isAlive()) {
            printRound(round++);
            hero.attack(enemy);
            System.out.println("Player 2 remaining health: " + enemy.getHealth());
            if (!enemy.isAlive()) {
                System.out.println("Player 1 is winner!");
                return;
            }
            System.out.println("Player 2 attacks Player 1!");
            enemy.attack(hero);
            System.out.println("Player 1 remaining health: " + hero.getHealth());
            if (!hero.isAlive()) {
                System.out.println("Player 2 is winner!");
                return;
            }
            sleep(1000);
        }
    }

    private void printRound(int round) {
        System.out.println("\nROUND " + round);
        System.out.println("======================");
        System.out.println("Player 1 attacks Player 2!");
    }

}
