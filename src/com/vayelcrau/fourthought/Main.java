package com.vayelcrau.fourthought;

import com.vayelcrau.fourthought.display.Application;

import java.awt.*;

public class Main {
    public static Application ex;
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ex = Application.getInstance();
            ex.setVisible(true);
        });
    }
}
