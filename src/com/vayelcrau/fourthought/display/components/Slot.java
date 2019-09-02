package com.vayelcrau.fourthought.display.components;

import lib.Values;

import javax.swing.*;
import java.awt.*;

public class Slot extends JLabel {

    public Slot() {
        super("", SwingConstants.CENTER);

        setBackground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setOpaque(true);
    }

    public void updateColor(Values piece) {
        setBackground(piece.getColor());
        setForeground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        setText("");
    }

    public void showPoints(double points) {
        setText(Double.toString(((int) (points * 100))/100.0));
        Color color;
        if (points > 0) {
            color = Color.GREEN;
        } else if (points < 0) {
            color = Color.decode("#8B0000");
        } else {
            color = Color.YELLOW;
        }

        setForeground(color);
        setBorder(BorderFactory.createLineBorder(color, 3));
    }
}
