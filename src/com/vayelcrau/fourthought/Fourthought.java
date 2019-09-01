import java.util.Random;

public class Fourthought implements Player {
    private Game game;
    private Random rand;
    private final Constants.VALUES color = Constants.VALUES.RED;

    public Fourthought() {
        game = Game.getInstance();
        rand = new Random();
    }

    public void move() {
        game.place(color, rand.nextInt(7));
    }

    @Override
    public Constants.VALUES getColor() {
        return color;
    }
}
