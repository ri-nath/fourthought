package com.vayelcrau.fourthought;

import com.vayelcrau.fourthought.display.Application;
import com.vayelcrau.fourthought.display.Menu;

import java.awt.*;

public class Main {
    public static Application ex;
    public static Menu menu;
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ex = Application.getInstance();
            ex.setVisible(true);

            menu = Menu.getInstance();
            menu.setVisible(true);
        });
    }
}
