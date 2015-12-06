package com.timmy;

import javax.swing.*;
//import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;

public class Menu extends JFrame { //implements ActionListener, KeyListener {

    protected JMenuBar menuBar;
    protected JMenu fileMenu, controlsMenu, helpMenu;
    protected JMenuItem openFile, addFile, closeFile;
    protected JMenuItem playControl, backControl, forwardControl;
    protected JMenuItem aboutHelp;

    public Menu() {
        super();

        menuBar = new JMenuBar();
        /* Create the menu bar that will hold each dropdown menu
            * File
            * Controls
            * Help */

        /* Menus */

        //File Menu
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic('f');
        menuBar.add(fileMenu);
        //Controls Menu
        controlsMenu = new JMenu("Controls");
        controlsMenu.setMnemonic('c');
        menuBar.add(controlsMenu);
        //Help Menu
        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('h');
        menuBar.add(helpMenu);

        /* Menu Items */

        //file items
        openFile = new JMenuItem("Open");
        openFile.setMnemonic('o');
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));

        addFile = new JMenuItem("Add Music");

        closeFile = new JMenuItem("Exit");
        closeFile.setMnemonic('x');
        closeFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));

        fileMenu.add(openFile);
        fileMenu.add(addFile);
        fileMenu.add(closeFile);

        //controls items
        playControl = new JMenuItem("Play");
        backControl = new JMenuItem("Previous Song");
        forwardControl = new JMenuItem("Next Song");

        controlsMenu.add(playControl);
        controlsMenu.add(backControl);
        controlsMenu.add(forwardControl);

        //help items
        aboutHelp = new JMenuItem("About");

        helpMenu.add(aboutHelp);

        setJMenuBar(menuBar);
        setVisible(true);
        pack();
    }
}
