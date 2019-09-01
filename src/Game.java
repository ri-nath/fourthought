import java.util.ArrayList;

public class Game {
    private Board board;
    private Constants.VALUES turn;
    private ArrayList<Player> players;

    private static Game instance;
    public static Game getInstance() {
        if (instance == null)
            instance = new Game();
        return instance;
    }

    private Game() {
        players = new ArrayList<>();
        board = new Board();
        turn = Constants.VALUES.RED;
    }

    public void place(Constants.VALUES turn, int col) {
        if (turn != turn || board.colIsFull(col)) return;
        board.place(turn, col);
    }

    public void register(Player player) {
        players.add(player);
    }

    public void init() {
        loop();
    }

    private void loop() {
        for (Player player : players) {
            if (player.getColor() == turn) {
                synchronized (this) {
                    System.out.println(turn.toString() + "'s turn");
                    player.move();
                }
            }
        }

        if (board.checkForWin(turn)) {
            System.out.println("Game Won");
        } else {
            turn = turn.next();
            loop();
        }
    }
}
