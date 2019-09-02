package com.vayelcrau.fourthought;

import com.vayelcrau.fourthought.game.Game;
import lib.Values;

import java.util.Random;

public class Fourthought{
    private Game game;
    private Random rand;
    private final Values color = Values.BLUE;

    public Fourthought() {
        game = Game.getInstance();
        rand = new Random();
    }

    public void move() {
        game.place(color, rand.nextInt(7));
    }
}
