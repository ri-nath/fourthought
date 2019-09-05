package com.vayelcrau.fourthought.game;

import com.vayelcrau.fourthought.Constants;
import com.vayelcrau.fourthought.Fourthought;
import com.vayelcrau.fourthought.Main;
import com.vayelcrau.fourthought.Values;

import java.util.Random;

public class Game {
    private static Board board;
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
        if (player != turn || board.colIsFull(col)) {
            place(player, new Random().nextInt(7));
            return;
        }
        board.place(turn, col);
        if (board.checkForWin(turn)) {
            System.out.println("Game over, winner: " + turn.toString());
            turn = Values.NONE;
        } else {
            turn = turn.next();
        }

        Main.ex.updateBoard();

        if (turn == Constants.FOURTHOUGHT_COLOR) {
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
