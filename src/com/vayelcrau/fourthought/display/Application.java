package com.vayelcrau.fourthought.display;

import com.vayelcrau.fourthought.Fourthought;
import com.vayelcrau.fourthought.display.components.Dropper;
import com.vayelcrau.fourthought.display.components.Slot;
import com.vayelcrau.fourthought.game.Game;
import lib.Values;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {

    private Slot[][] slots;
    private Dropper[] droppers;
    private Game game;

    public Application() {
        initUI();
    }

    private void initUI() {
        game = Game.getInstance();

        setSize(900, 900);
        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(7, 7));
        droppers = new Dropper[7];
        slots = new Slot[6][7];

        for (int i = 0; i < 7; i++) {
            Dropper dropper = new Dropper(i);
            droppers[i] = dropper;
            add(droppers[i]);
        }

        for (int y = 0; y < slots.length; y++) {
            for (int x = 0; x < slots[0].length; x++) {
                Slot slot = new Slot();
                slots[y][x] = slot;
                add(slots[y][x]);
            }
        }

        pack();
    }

    public void updateBoard() {
        for (Dropper dropper : droppers) {
            dropper.checkIfEnabled();
        }

        for (int y = 0; y < slots.length; y++) {
            for (int x = 0; x < slots[0].length; x++) {
                slots[y][x].updateColor(game.getBoard().getValue(y, x));
            }
        }

        if (game.getTurn() == Values.RED) {
            Fourthought.getInstance().move();
        }
    }
}
