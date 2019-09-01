import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Board {
    private Constants.VALUES[][] board;
    private Random rand;

    public Board() {
        rand = new Random();
        board = new Constants.VALUES[6][7];
        for (Constants.VALUES[] row : board) {
            Arrays.fill(row, Constants.VALUES.NONE);
        }
    }

    public void place(Constants.VALUES piece, int col)  {
        col = col % board[0].length;

        for (int i = board.length-1; i >= 0; i--) {
            if (board[i][col] == Constants.VALUES.NONE) {
                board[i][col] = piece;
                checkForWin(piece);
                return;
            }
        }
    }

    public boolean checkForWin(Constants.VALUES piece)  {
        // horizontalCheck
        for (int j = 0; j < board[0].length - 3; j++) {
            for (int i = 0; i < board.length; i++) {
                if (this.board[i][j] == piece && this.board[i][j + 1] == piece && this.board[i][j + 2] == piece && this.board[i][j + 3] == piece) {
                    return true;
                }
            }
        }
        // verticalCheck
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (this.board[i][j] == piece && this.board[i + 1][j] == piece && this.board[i + 2][j] == piece && this.board[i + 3][j] == piece) {
                    return true;
                }
            }
        }
        // ascendingDiagonalCheck
        for (int i = 3; i < board.length; i++) {
            for (int j = 0; j < board[0].length - 3; j++) {
                if (this.board[i][j] == piece && this.board[i - 1][j + 1] == piece && this.board[i - 2][j + 2] == piece && this.board[i - 3][j + 3] == piece)
                    return true;
            }
        }
        // descendingDiagonalCheck
        for (int i = 3; i < board.length; i++) {
            for (int j = 3; j < board[0].length; j++) {
                if (this.board[i][j] == piece && this.board[i - 1][j - 1] == piece && this.board[i - 2][j - 2] == piece && this.board[i - 3][j - 3] == piece)
                    return true;
            }
        }
        return false;
    }

    public void randomlyFillBoard() {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (rand.nextBoolean()) {
                    board[y][x] = Constants.VALUES.BLUE;
                } else {
                    board[y][x] = Constants.VALUES.RED;
                }
            }
        }
    }

    /**public void test() {
        place(Constants.VALUES.RED, 1);
        place(Constants.VALUES.BLUE, 2);
        place(Constants.VALUES.RED, 2);
        place(Constants.VALUES.BLUE, 3);
        place(Constants.VALUES.BLUE, 3);
        place(Constants.VALUES.RED, 3);
        place(Constants.VALUES.BLUE, 4);
        place(Constants.VALUES.BLUE, 4);
        place(Constants.VALUES.BLUE, 4);
        place(Constants.VALUES.RED, 4);

        System.out.println(Arrays.deepToString(board));
        if (checkForWin(Constants.VALUES.BLUE)) {
            System.out.println("Blue");
        } else if (checkForWin(Constants.VALUES.RED)) {
            System.out.println("Red");
        } else {
            System.out.println("Tie");
        }
    }**/
}
