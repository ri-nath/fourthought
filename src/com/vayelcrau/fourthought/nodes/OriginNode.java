package com.vayelcrau.fourthought.nodes;

import com.vayelcrau.fourthought.game.Board;
import com.vayelcrau.fourthought.nodes.Node;
import lib.Values;

import java.util.HashMap;

public class OriginNode  {
    HashMap<Integer, Node> nodeMap;
    Board board;

    public OriginNode(Board board_) {
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
        double[] points = new double[7];
        int index = 0;

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

        double max = points[0];
        System.out.println("Starting max: " + max);



        System.out.println("vvvvvvvvvvvv");

        for (int i = 0; i < 7; i++) {
            System.out.println(i + ": " + points[i] + " points");
            System.out.println("Position " + i + " with " + points[i] + " points vs position " + index + " with " + max + "points.");
            if (max < points[i]) {
                max = points[i];
                index = i;
            }
        }

        System.out.println("Best move is at "+ index+ " with " + max + " points.");

        System.out.println("^^^^^^^^^^^^");

        return index;
    }
}
