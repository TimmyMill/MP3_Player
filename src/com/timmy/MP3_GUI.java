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
        menu = new Menu();
        setJMenuBar(menu);
        setContentPane(playerPanel);
        setPreferredSize(new Dimension(500, 500));
        pack();
        setResizable(true);
        setFocusable(true);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
