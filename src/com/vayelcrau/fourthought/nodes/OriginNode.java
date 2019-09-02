package com.vayelcrau.fourthought.nodes;

import com.vayelcrau.fourthought.game.Board;
import com.vayelcrau.fourthought.nodes.Node;
import lib.Values;

import java.util.HashMap;
import java.util.Random;

public class OriginNode  {
    private HashMap<Integer, Node> nodeMap;
    private Board board;
    private double[] points;


    public OriginNode(Board board_) {
        points = new double[7];
        board = board_;
        nodeMap = new HashMap<>();

        for (int i = 0; i < 7; i++) {
            Board copy = board.getCopyOfBoard();
            copy.place(Values.RED, i);
            nodeMap.put(i, new Node(copy, Values.BLUE, 2));
        }
    }

    private int checkForImmediateWin() {
        for (int i = 0; i < 7; i++) {
            if (board.testMove(Values.RED, i) && !board.colIsFull(i)) {
                return i;
            }
        }

        return -1;
    }

    public int findBestMove() {

        if (checkForImmediateWin() != -1) return checkForImmediateWin();

        for (int i = 0; i < 7; i++) {
            nodeMap.get(i).createNewNodes();
        }

        for (int i = 0; i < 7; i++) {
            nodeMap.get(i).childrenCreateNewNodes();
        }

        for (int i = 0; i < 7; i++) {
            points[i] = nodeMap.get(i).getValue();
        }

        int index = new Random().nextInt(7);
        double max = points[index];

        for (int i = 0; i < 7; i++) {
            if (max < points[i]) {
                max = points[i];
                index = i;
            }
        }

        return index;
    }

    public double[] scores() {
        return points;
    }
}
