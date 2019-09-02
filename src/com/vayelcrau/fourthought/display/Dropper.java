package com.vayelcrau.fourthought.display;

import com.vayelcrau.fourthought.game.Game;
import lib.Values;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dropper extends JButton implements ActionListener {
    private Game game;
    private boolean enabled;
    private int id;

    Dropper(int identification) {
        super("v");

        game = Game.getInstance();
        id = identification;
        enabled = true;
        addActionListener(this);
    }

    private void drop() {
        game.place(Values.BLUE, id);
    }

    public void checkIfEnabled() {
        if (game.getTurn() == Values.BLUE && !game.getBoard().colIsFull(id)) {
            enabled = true;
            super.setEnabled(true);
        } else {
            enabled = false;
            super.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (enabled) drop();
        System.out.println(game.getTurn());
    }
}
