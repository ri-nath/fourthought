package com.vayelcrau.fourthought;

import com.vayelcrau.fourthought.game.Board;
import com.vayelcrau.fourthought.game.Game;
import lib.Values;

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
        Board currentBoard = game.getBoard().getCopyOfBoard();
        int bestMove = testAllMoves(currentBoard);
        if (bestMove != -1) return bestMove;

        for (int i = 0; i < 7; i++) {
            if (calculateMove(currentBoard.getCopyOfBoard(), 1)) {
                return i;
            };
        }

        return rand.nextInt(7);

    }

    public boolean calculateMove(Board board, int depth) {
        int bestMove;
        int currentDepth = depth;
        if (currentDepth > 3) return false;

        for (int i = 0; i < 7; i++) {
            if (!board.colIsFull(i)) continue;
            Board copy = board.getCopyOfBoard();
            copy.place(Values.BLUE, i);
            bestMove = testAllMoves(board);
            if (bestMove != -1) return true;
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                Board copy = board.getCopyOfBoard();
                copy.place(Values.BLUE, i);
                copy.place(Values.RED, j);
                if (calculateMove(copy, currentDepth+1)) return true;
            }
        }

        return false;
    }



    public int testAllMoves(Board board) {
        for (int i = 0; i < 7; i++) {
            if (board.testMove(color, i) && !board.colIsFull(i)) {
                System.out.println("Found winning move at "+ i+ "!");
                return i;
            }
        }
        return -1;
    }
}
