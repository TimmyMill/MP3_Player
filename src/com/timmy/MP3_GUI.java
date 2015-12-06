package com.timmy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MP3_GUI extends JFrame {
    private JPanel playerPanel;
    private JPanel menuPanel;
    private JTable table1;
    private JButton playButtonButton;
    private Menu menu;

    public MP3_GUI () {
        super("MP3");

        //JFrame Settings
        setContentPane(playerPanel);
        setPreferredSize(new Dimension(500, 500));
        setResizable(true);
        setFocusable(true);
        menu = new Menu();
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
