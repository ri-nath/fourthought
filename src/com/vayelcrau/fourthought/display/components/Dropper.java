package com.vayelcrau.fourthought.display;

import com.vayelcrau.fourthought.game.Game;
import lib.Values;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Dropper extends JButton implements ActionListener, MouseListener {
    private Game game;
    private boolean enabled;
    private int id;

    Font defaultFont = new Font("Gill Sans MT",Font.BOLD,14);
    Color textColor = Color.DARK_GRAY;
    Color backgroundColor = Color.GRAY;
    Color hoverColor = Color.LIGHT_GRAY;

    Dropper(int identification) {
        game = Game.getInstance();
        id = identification;
        enabled = true;
        addActionListener(this);


        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0 , Color.BLACK));

        setFocusPainted(false);
        setText("↓");
        setForeground(textColor);
        setBackground(backgroundColor);
        setFont(defaultFont);
        setOpaque(true);
        addMouseListener(this);
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
    }

    @Override public void mouseClicked(MouseEvent me) {}
    @Override public void mouseReleased(MouseEvent me) {}
    @Override public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource()==this) {
            this.setBackground(this.hoverColor);
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource()==this) {
            this.setBackground(this.backgroundColor);
        }
    }
}
