package com.timmy;

import javax.swing.*;
//import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;

public class Menu extends JMenuBar { //implements ActionListener, KeyListener {

    protected JMenu fileMenu, controlsMenu, helpMenu;
    protected JMenuItem fOpen, fAdd, fClose;
    protected JMenuItem cPlay, cPrevious, cNext;
    protected JMenuItem hAbout;

    public Menu() {

        /* Create the menu bar that will hold each dropdown menu */
//        menuBar = new JMenuBar();

        /* Create each menu that will be in the menu bar:
        */

        //File Menu
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic('f');
        this.add(fileMenu);

        //Controls Menu
        controlsMenu = new JMenu("Controls");
        controlsMenu.setMnemonic('c');
        this.add(controlsMenu);

        //Help Menu
        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('h');
        this.add(helpMenu);

        /* Create menu items that each menu will hold */

        /* File items:
        */

        //open
        fOpen = new JMenuItem("Open");
        fOpen.setMnemonic('o');
        fOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));

        //add
        fAdd = new JMenuItem("Add Music");

        //close
        fClose = new JMenuItem("Close Player");
        fClose.setMnemonic('x');
        fClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));

        fileMenu.add(fOpen);
        fileMenu.add(fAdd);
        fileMenu.add(fClose);

        /* Controls items:
        */

        //play
        cPlay = new JMenuItem("Play");

        //previous
        cPrevious = new JMenuItem("Previous Song");

        //next
        cNext = new JMenuItem("Next Song");

        controlsMenu.add(cPlay);
        controlsMenu.add(cPrevious);
        controlsMenu.add(cNext);

        /* Help items:
        */

        //about
        hAbout = new JMenuItem("About");

        helpMenu.add(hAbout);
    }
}
