package com.vayelcrau.fourthought.display;

import com.vayelcrau.fourthought.game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application extends JFrame {

    Slot[][] slots;
    Dropper[] droppers;
    Game game;

    public Application() {
        initUI();
    }

    private void initUI() {
        game = Game.getInstance();
        droppers = new Dropper[7];
        slots = new Slot[6][7];
        setSize(800, 900);
        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(7, 7));

        for (int i = 0; i < 7; i++) {
            Dropper dropper = new Dropper(i);
            dropper.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateBoard();
                }
            });

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

    }



}
