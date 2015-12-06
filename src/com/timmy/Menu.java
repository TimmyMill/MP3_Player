package com.timmy;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import java.awt.event.*;

public class Menu extends JMenuBar implements ActionListener, KeyListener {

    protected JMenu fileMenu, controlsMenu, helpMenu;
    protected JMenuItem fOpen, fAdd, fClose;
    protected JMenuItem cPlay, cPrevious, cNext;
    protected JMenuItem hAbout;
    protected JFileChooser fc;

    public Menu() {

        /* Create the menu bar that will hold each dropdown menu */
//        menuBar = new JMenuBar();

        /* Create each menu that will be in the menu bar:
        */

        //File Menu
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic('f');
        fileMenu.addActionListener(this);
        this.add(fileMenu);

        //Controls Menu
        controlsMenu = new JMenu("Controls");
        controlsMenu.setMnemonic('c');
        controlsMenu.addActionListener(this);
        this.add(controlsMenu);

        //Help Menu
        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('h');
        helpMenu.addActionListener(this);
        this.add(helpMenu);

        /* Create menu items that each menu will hold */

        /* File items:
        */

        //open
        fOpen = new JMenuItem("Open");
        fOpen.setMnemonic('o');
        fOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        fOpen.addActionListener(this);
        fOpen.setActionCommand("Open");
        fileMenu.add(fOpen);

        fc = new JFileChooser();
        fc.setCurrentDirectory(new java.io.File(System.getProperty("user.home")));
        fc.setDialogTitle("Open File");
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);


        //add
        fAdd = new JMenuItem("Add Music");
        fileMenu.add(fAdd);

        //close
        fClose = new JMenuItem("Close Player");
        fClose.setMnemonic('x');
        fClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        fClose.addActionListener(this);
        fClose.setActionCommand("Close");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch(actionCommand) {
            case "Open": {
                System.out.println("Open");
                fc.showOpenDialog(fOpen);
                break;
            }
            case "Close": {
                System.out.println("Close");
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Blah");
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
