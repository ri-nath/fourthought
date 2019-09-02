package com.vayelcrau.fourthought.nodes;

import com.vayelcrau.fourthought.game.Board;
import lib.Values;

public class Node {
    private Board board;
    private Values color;
    private double multiplier;
    private int depth;
    private double points;
    private Node[] nodes;

    public Node(Board board_, Values color_, int depth_) {
        board = board_;
        color = color_;
        depth = depth_;
        nodes = new Node[7];

        points = 0;

        if (color_ == Values.BLUE) {
            multiplier = -5.0;
        } else {
            multiplier = 5.0;
        }

        multiplier *= 1.0/depth;
    }

    public double getValue() {
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

    public void createNewNodes() {
        if (depth >= 5) return;
        if (nodes[6] != null) return;

        for (int i = 0; i < 7; i++) {
            if (!board.colIsFull(i)) {
                Board copy = board.getCopyOfBoard();
                copy.place(color, i);
                if (!copy.checkForWin(color)) {
                    nodes[i] = new Node(copy, color.next(), depth+1);
                }
            }
        }

    }

    public void childrenCreateNewNodes() {
        for (Node node : nodes) {
            if (node != null) {
                node.createNewNodes();
            }
        }
    }
}
