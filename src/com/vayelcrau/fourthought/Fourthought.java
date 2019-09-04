package com.vayelcrau.fourthought;

import com.vayelcrau.fourthought.display.Application;
import com.vayelcrau.fourthought.game.Game;
import com.vayelcrau.fourthought.nodes.OriginNode;

import java.util.Random;

public class Fourthought{
    private Game game;
    private Random rand;
    private final Values color = Values.RED;
    private int depth;

    private static Fourthought instance;

    public static Fourthought getInstance() {
        if (instance == null)
            instance = new Fourthought();
        return instance;
    }

    private Fourthought() {
        game = Game.getInstance();
        rand = new Random();
    }

    public void move() {
        depth = 0;
        game.place(color, calculateBestMove());
    }

    public int calculateBestMove() {
        OriginNode node = new OriginNode(game.getBoard().getCopyOfBoard());
        int move = node.findBestMove();
        Application.getInstance().drawPoints(node.scores());
        return move;
    }
}
