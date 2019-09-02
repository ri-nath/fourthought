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
            nodeMap.put(i, new Node(board, Values.BLUE, 2));
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
        double max = points[0];

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

        for (int i = 0; i < 7; i++) {
            System.out.println(i + ": " + points[i] + " points");
            if (max < points[i]) {
                max = points[i];
                index = i;
            }
        }

        return index;
    }
}
