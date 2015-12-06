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
        /* Create Menus */
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('f');
        JMenu controlsMenu = new JMenu("Controls");
        JMenu helpMenu = new JMenu("Help");

        /* Create Menu Items
        */
        //File Menu
        JMenuItem openFile = new JMenuItem("Open");
        openFile.setMnemonic('o');
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        JMenuItem addFile = new JMenuItem("Add Music");

        JMenuItem closeFile = new JMenuItem("Exit");
        closeFile.setMnemonic('x');
        closeFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        //Controls Menu
        JMenuItem playControl = new JMenuItem("Play");
        JMenuItem backControl = new JMenuItem("Previous Song");
        JMenuItem forwardControl = new JMenuItem("Next Song");
        JMenuItem aboutHelp = new JMenuItem("About");
        //file
        fileMenu.add(openFile);
        fileMenu.add(addFile);
        fileMenu.add(closeFile);
        //controls
        controlsMenu.add(playControl);
        controlsMenu.add(backControl);
        controlsMenu.add(forwardControl);
        //help
        helpMenu.add(aboutHelp);

        menuBar.add(fileMenu);
        menuBar.add(controlsMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
        setVisible(true);

    }
}
