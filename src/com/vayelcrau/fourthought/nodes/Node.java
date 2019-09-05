package com.vayelcrau.fourthought.nodes;

import com.vayelcrau.fourthought.game.Board;
import com.vayelcrau.fourthought.Values;

public class Node {
    private Board board;
    private Values color;

    private double multiplier;
    private int depth;

    private Node[] nodes;
    private double[] scores;

    public Node(Board board_, Values color_, int depth_) {
        board = board_;
        color = color_;
        depth = depth_;
        nodes = new Node[7];
        scores = new double[7];

        if (color_ == Values.BLUE) {
            multiplier = -5.0;
        } else {
            multiplier = 5.0;
        }

        multiplier *= 1.0/(depth*depth*depth);
    }

    private double getValue() {
        double points = 0;

        for (int i = 0; i < 7; i++) {
            if (board.testMove(color, i) && !board.colIsFull(i)) {
                points += multiplier;
            }
        }

        for (Node node : nodes) {
            if (node != null) {
                points += node.getValue();
            }
        }

        return points;
    }

    private void createNewLayer() {
        if (nodes[0] == null) {
            for (int i = 0; i < 7; i++) {
                Board copy = board.getCopyOfBoard();
                copy.place(color, i);
                nodes[i] = new Node(copy, color.next(), depth+1);
            }
        } else {
            for (Node node : nodes) {
                node.createNewLayer();
            }
        }
    }

    public int findBestChild() {
        int col = 0;

        double max = Integer.MIN_VALUE;

        for (int i = 0; i < 7; i++) {
            scores[i] = nodes[i].getValue();
            if (max < scores[i]) {
                max = scores[i];
                col = i;
            }
        }

        return col;
    }

    public double[] getScores() {
        return scores;
    }

    public void createLayers(int x) {
        for (int i = 0; i < x; i++) {
            createNewLayer();
        }
    }
}
