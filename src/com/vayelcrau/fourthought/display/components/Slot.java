package com.vayelcrau.fourthought.display.components;

import lib.Values;

import javax.swing.*;
import java.awt.*;

public class Slot extends JLabel {

    public Slot() {
        super();
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setOpaque(true);
    }

    public void updateColor(Values piece) {
        setBackground(piece.getColor());
    }
}
