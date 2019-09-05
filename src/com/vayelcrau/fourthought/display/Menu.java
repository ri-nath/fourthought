package com.vayelcrau.fourthought.display;

import com.vayelcrau.fourthought.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    private static Menu mInstance;

    private JButton plus, minus;
    private JLabel label;

    private int layers;

    private Menu() {
        setLayout(new FlowLayout());

        layers = Constants.DEFAULT_LAYERS;

        label = new JLabel("Layers: " + layers);
        plus = new JButton("+");
        minus = new JButton("-");

        plus.addActionListener(e -> {
            layers++;
            if (layers > Constants.MAX_LAYERS) layers = Constants.MAX_LAYERS;

            label.setText("Layers: " + Integer.toString(layers));

        });

        minus.addActionListener(e -> {
            layers--;
            if (layers < Constants.MIN_LAYERS) layers = Constants.MIN_LAYERS;

            label.setText("Layers: " + Integer.toString(layers));
        });

        add(plus);
        add(label);
        add(minus);

        pack();
    }

    public static Menu getInstance() {
        if (mInstance == null) {
            mInstance = new Menu();
        }
        return mInstance;
    }

    public int getLayers() {
        return layers;
    }
}
