package com.vayelcrau.fourthought;

import com.vayelcrau.fourthought.display.Application;
import com.vayelcrau.fourthought.display.Menu;
import com.vayelcrau.fourthought.game.Game;
import com.vayelcrau.fourthought.nodes.Node;

import java.util.Random;

public class Fourthought {
    private Game game;

    private static Fourthought instance;

    public static Fourthought getInstance() {
        if (instance == null)
            instance = new Fourthought();
        return instance;
    }

    private Fourthought() {
        game = Game.getInstance();
    }

    public void move() {
        game.place(Constants.FOURTHOUGHT_COLOR, calculateBestMove());
    }

    private int calculateBestMove() {
        Node node = new Node(game.getBoard().getCopyOfBoard(), Constants.FOURTHOUGHT_COLOR, 1);
        node.createLayers(Menu.getInstance().getLayers() - 1);
        int move = node.findBestChild();
        Application.getInstance().drawPoints(node.getScores());
        return move;
    }
}
