package com.vayelcrau.fourthought.game;

import com.vayelcrau.fourthought.Fourthought;
import com.vayelcrau.fourthought.Main;
import lib.Values;

public class Game {
    private Board board;
    private Values turn;

    private static Game instance;
    public static Game getInstance() {
        if (instance == null)
            instance = new Game();
        return instance;
    }

    private Game() {
        board = new Board();
        turn = Values.BLUE;
    }

    public void place(Values player, int col) {
        if (player != turn || board.colIsFull(col)) return;
        board.place(turn, col);
        if (board.checkForWin(turn)) {
            System.out.println("Game over, winner: " + turn.toString());
            turn = Values.NONE;
        } else {
            turn = turn.next();
        }

        Main.ex.updateBoard();

        if (turn == Values.RED) {
            Fourthought.getInstance().move();
        }
    }

    public Values getTurn() {
        return turn;
    }
    public Board getBoard() {
        return board;
    }
}
