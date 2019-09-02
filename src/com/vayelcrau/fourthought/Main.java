package com.vayelcrau.fourthought;

import com.vayelcrau.fourthought.display.Application;
import com.vayelcrau.fourthought.game.Game;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });

        /**Game game = Game.getInstance();
        game.register(new Human());
        game.register(new Fourthought());

        game.init();
        game.place(Constants.VALUES.RED, 0);
        game.place(Constants.VALUES.BLUE, 1);
        game.place(Constants.VALUES.RED, 0);
        game.place(Constants.VALUES.BLUE, 2);
        game.place(Constants.VALUES.RED, 0);
        game.place(Constants.VALUES.BLUE, 3);
        game.place(Constants.VALUES.RED, 0);**/
    }
}
