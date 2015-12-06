package com.timmy;

import javax.swing.*;
import java.awt.*;

public class MP3_GUI extends JFrame {
    private JPanel playerPanel;
    private JPanel menuPanel;
    private JTable table1;
    private JButton playButtonButton;
    private Menu menu;

    public MP3_GUI () {
        super("MP3");

        //JFrame Settings
        menu = new Menu(); //create the menu built in the menu class so we can add it to the JFrame
        setJMenuBar(menu); //set our menu bar to the JFrame
        setContentPane(playerPanel);
        setPreferredSize(new Dimension(500, 500));
        pack();
        setResizable(true);
        setFocusable(true);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
