package com.vayelcrau.fourthought.display;

import lib.Values;

import javax.swing.*;
import java.awt.*;

public class Slot extends JLabel {

    Slot() {
        super();
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public void updateColor(Values piece) {
        setBackground(piece.getColor());
    }
}
