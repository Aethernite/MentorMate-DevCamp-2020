package com.mentormate.devcamp.game;

import com.mentormate.devcamp.game.engine.GameEngine;
import com.mentormate.devcamp.game.hero.Assassin;
import com.mentormate.devcamp.game.hero.Hero;
import com.mentormate.devcamp.game.hero.Knight;


/**
 * The Fight game application.
 */
public class FightGame {
    private final GameEngine engine;

    /**
     * Instantiates a new game and creates a new Game Engine.
     */
    public FightGame() {
        this.engine = new GameEngine();
    }

    /**
     * The start method of the application.
     *
     * @throws InterruptedException Thread.sleep is used to slow the processing
     */
    public void start() throws InterruptedException {
        Hero player1 = new Knight(4000, 300, 50); //Creating a new Knight as example
        Hero player2 = new Assassin(4000, 236, 50); //Creating a new Assassin as example
        engine.fight(player1, player2);
    }

    /**
     * The entry point of the program.
     *
     * @param args the input arguments
     * @throws InterruptedException Thread.sleep is used to slow the processing
     */
    public static void main(String[] args) throws InterruptedException {
        FightGame game = new FightGame();
        game.start();
    }
}
