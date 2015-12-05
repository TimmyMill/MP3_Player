package com.timmy;

import javax.swing.*;
import java.awt.*;

public class MP3_GUI extends JFrame {
    private JPanel playerPanel;
    private JPanel menuPanel;
    private JTable table1;
    private JButton playButtonButton;

    public MP3_GUI () {
        super("MP3");

        //JFrame Settings
        setContentPane(playerPanel);
        setPreferredSize(new Dimension(500, 500));
        setResizable(true);
        setFocusable(true);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        /* Menu Bar */
        JMenuBar menuBar = new JMenuBar();
        /* Menus */
        JMenu fileMenu = new JMenu("File");
        JMenu controlsMenu = new JMenu("Controls");
        JMenu helpMenu = new JMenu("Help");
        /* Menu Items */
        JMenuItem openFile = new JMenuItem("Open");
        
        JMenuItem addFile = new JMenuItem("Add Music");
        JMenuItem closeFile = new JMenuItem("Close");
        JMenuItem playControl = new JMenuItem("Play");
        JMenuItem backControl = new JMenuItem("Previous Song");
        JMenuItem forwardControl = new JMenuItem("Next Song");
        JMenuItem aboutHelp = new JMenuItem("About");
        //file
        fileMenu.add(openFile);
        fileMenu.add(addFile);
        fileMenu.add(closeFile);
        menuBar.add(fileMenu);
        //controls
        controlsMenu.add(playControl);
        controlsMenu.add(backControl);
        controlsMenu.add(forwardControl);
        menuBar.add(controlsMenu);
        //help
        helpMenu.add(aboutHelp);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
        setVisible(true);

    }
}
