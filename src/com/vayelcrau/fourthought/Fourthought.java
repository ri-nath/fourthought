package com.vayelcrau.fourthought;

import com.vayelcrau.fourthought.display.Application;
import com.vayelcrau.fourthought.game.Game;
import com.vayelcrau.fourthought.nodes.Node;

import java.util.Random;

public class Fourthought{
    private Game game;
    private Random rand;
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
        game.place(Constants.FOURTHOUGHT_COLOR, calculateBestMove());
    }

    public int calculateBestMove() {
        Node node = new Node(game.getBoard().getCopyOfBoard(), Constants.FOURTHOUGHT_COLOR, 1);
        node.createNewLayer();
        node.createNewLayer();
        node.createNewLayer();
        int move = node.findBestChild();
        Application.getInstance().drawPoints(node.getScores());
        return move;
    }
}
