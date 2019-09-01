public class Game {
    Board board;
    Constants.VALUES player;

    private static Game instance;
    public static Game getInstance() {
        if (instance == null)
            instance = new Game();
        return instance;
    }

    private Game() {
        board = new Board();
        player = Constants.VALUES.RED;
    }

    public void place(Constants.VALUES turn, int col) {
        if (turn != player || board.colIsFull(col)) return;
        board.place(turn, col);
        if (board.checkForWin(turn)) {
            System.out.println("Game Won");
        }
        player = player.next();
    }
}
