import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Human implements Player {
    private Game game;
    private final Constants.VALUES color = Constants.VALUES.BLUE;
    int move;

    public Human() {

        game = Game.getInstance();
    }
    @Override
    public void move() {
        Scanner reader = new Scanner(System.in);
        int move = 0;
        if (reader.hasNextInt()) {
            move = reader.nextInt();
        }

        reader.close();

        game.place(color, move);
    }

    @Override
    public Constants.VALUES getColor() {
        return color;
    }
}
