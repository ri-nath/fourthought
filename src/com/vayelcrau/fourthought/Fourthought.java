package com.vayelcrau.fourthought;

import com.vayelcrau.fourthought.game.Game;
import com.vayelcrau.fourthought.nodes.OriginNode;
import lib.Values;

import java.util.Random;

public class Fourthought{
    private Game game;
    private Random rand;
    private final Values color = Values.RED;
    private int depth;
    private OriginNode node;
    int move;

    private static Fourthought instance;

    public static Fourthought getInstance() {
        if (instance == null)
            instance = new Fourthought();
        return instance;
    }

    private Fourthought() {
        move = 0;
        game = Game.getInstance();
        rand = new Random();
    }

    public void move() {
        depth = 0;
        game.place(color, calculateBestMove());
    }

    public int calculateBestMove() {
        node = new OriginNode(game.getBoard().getCopyOfBoard());
        move = node.findBestMove();
        return move;
    }

    public double[] scoreMoves() {
        if (node == null) return new double[0];
        return node.scores();
    }

    public int myMove() {
        return move;
    }
}
