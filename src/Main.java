public class Main {
    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.register(new Human());
        game.register(new Connector());

        game.init();
        /**game.place(Constants.VALUES.RED, 0);
        game.place(Constants.VALUES.BLUE, 1);
        game.place(Constants.VALUES.RED, 0);
        game.place(Constants.VALUES.BLUE, 2);
        game.place(Constants.VALUES.RED, 0);
        game.place(Constants.VALUES.BLUE, 3);
        game.place(Constants.VALUES.RED, 0);**/
    }
}
