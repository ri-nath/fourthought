package com.vayelcrau.fourthought.game;

import lib.Values;

import java.util.Arrays;
import java.util.Random;

public class Board {
    private Values[][] board;

    public Board() {

        board = new Values[6][7];
        for (Values[] row : board) {
            Arrays.fill(row, Values.NONE);
        }
    }

    public Board(Values[][] preset) {
        board = preset;
    }

    public void place(Values piece, int col)  {
        col = col % board[0].length;

        for (int i = board.length-1; i >= 0; i--) {
            if (board[i][col] == Values.NONE) {
                board[i][col] = piece;
                return;
            }
        }
    }

    public boolean checkForWin(Values piece)  {
        // horizontal check
        for (int j = 0; j < board[0].length - 3; j++) {
            for (int i = 0; i < board.length; i++) {
                if (this.board[i][j] == piece && this.board[i][j + 1] == piece && this.board[i][j + 2] == piece && this.board[i][j + 3] == piece) {
                    return true;
                }
            }
        }
        // vertical check
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (this.board[i][j] == piece && this.board[i + 1][j] == piece && this.board[i + 2][j] == piece && this.board[i + 3][j] == piece) {
                    return true;
                }
            }
        }
        // ascending diagonal check
        for (int i = 3; i < board.length; i++) {
            for (int j = 0; j < board[0].length - 3; j++) {
                if (this.board[i][j] == piece && this.board[i - 1][j + 1] == piece && this.board[i - 2][j + 2] == piece && this.board[i - 3][j + 3] == piece)
                    return true;
            }
        }
        // descending diagonal check
        for (int i = 3; i < board.length; i++) {
            for (int j = 3; j < board[0].length; j++) {
                if (this.board[i][j] == piece && this.board[i - 1][j - 1] == piece && this.board[i - 2][j - 2] == piece && this.board[i - 3][j - 3] == piece)
                    return true;
            }
        }
        return false;
    }

    public boolean colIsFull(int col) {
        return board[0][col] != Values.NONE;
    }

    public Values getValue(int y, int x) {
        return board[y][x];
    }

    public Board getCopyOfBoard() {
        Values [][] copy = new Values[board.length][];
        for(int i = 0; i < board.length; i++)
            copy[i] = board[i].clone();

        return new Board(copy);
    }

    public boolean testMove(Values piece, int col)  {
        col = col % board[0].length;

        Board copy = getCopyOfBoard();
        copy.place(piece, col);
        return copy.checkForWin(piece);
    }

    public int getLowestFreeSlot(int col) {
        col = col % board[0].length;

        for (int i = board.length-1; i >= 0; i--) {
            if (board[i][col] == Values.NONE) {
                return i;
            }
        }

        return -1;
    }

    public int getHighestFilledSlot(int col) {
        col = col % board[0].length;

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != Values.NONE) {
                return i;
            }
        }

        return -1;
    }
}
