package com.timmy;

import javafx.stage.FileChooser;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import java.awt.event.*;
import java.io.File;

public class Menu extends JMenuBar implements ActionListener, KeyListener {

    protected JMenu fileMenu, controlsMenu, helpMenu;
    protected JMenuItem fOpen, fAdd, fClose;
    protected JMenuItem cPlay, cPrevious, cNext;
    protected JMenuItem hAbout;
    protected JFileChooser openFileChooser, addFileChooser;
    private File selectedOpenFile;
    private File selectedAddFile;
    private static File selectedFile;
    protected boolean playing = false;
    protected boolean pause = false;

    public Menu() {
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

        openFileChooser = new JFileChooser();
        openFileChooser.setCurrentDirectory(new java.io.File(System.getProperty("user.home")));
        openFileChooser.setDialogTitle("Open File");
        openFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);


        //add
        fAdd = new JMenuItem("Add Music");
        fAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, (InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK) ));
        fAdd.addActionListener(this);
        fAdd.setActionCommand("Add");
        fileMenu.add(fAdd);
        fileMenu.addSeparator();

        addFileChooser = new JFileChooser();
        addFileChooser.setCurrentDirectory(new java.io.File(System.getProperty("user.home")));
        addFileChooser.setDialogTitle("Add Music");
        addFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

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
        cPlay.setActionCommand(InputEvent.getModifiersExText(KeyEvent.VK_SPACE));
//        cPlay.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, InputEvent.KEY_EVENT_MASK));
        cPlay.addActionListener(this);
        cPlay.setActionCommand("Play");
        controlsMenu.add(cPlay);

        //previous
        cPrevious = new JMenuItem("Previous Song");
        controlsMenu.add(cPrevious);

        //next
        cNext = new JMenuItem("Next Song");
        controlsMenu.add(cNext);

        /* Help items:
        */

        //about
        hAbout = new JMenuItem("About");

        helpMenu.add(hAbout);
    }

    public static String selectSong(JMenuItem menuItem) {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setCurrentDirectory(new File(System.getProperty("user.home")));
        fc.showOpenDialog(menuItem);
        selectedFile = fc.getSelectedFile();
        System.out.println("Selection: " + selectedFile.getAbsolutePath());
        return selectedFile.getAbsolutePath();
    }

    public File getSelectedOpenFile() {return this.selectedOpenFile;}

    public File getSelectedAddFile() {return selectedAddFile;}
//    public static File getSelectedOpenFile() {
//        return selectedOpenFile;
//    }
//    public static File getSelectedAddFile() {
//        return selectedAddFile;
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch(actionCommand) {
            case "Open": {
                System.out.println("Open");
                openFileChooser.showOpenDialog(fOpen);

                //If a file is selected, create a reference to it
                if (openFileChooser.getSelectedFile() != null) { //prevents null pointer exception if a file isn't selected
                    selectedOpenFile = openFileChooser.getSelectedFile();
//                    file = openFileChooser.getSelectedFile().getAbsolutePath();
                    System.out.println("Selection: " + selectedOpenFile.getAbsolutePath());
                }
                break;
            }
            case "Add": {
                System.out.println("Add");
                addFileChooser.showOpenDialog(fAdd);
                if (addFileChooser.getSelectedFile() != null) {
                    selectedAddFile = addFileChooser.getSelectedFile();
                    System.out.println("Selection: " + selectedAddFile.getAbsolutePath());
                }
                break;
            }
//            case "Play": {
//                if (cPlay.isEnabled()) {
//                    System.out.println("Play");
//                    cPlay.setEnabled(true);
//                    playing = true;
//                    pause = false;
//                }
//                if (! cPlay.isEnabled()) {
//                    System.out.println("Pause");
//                    cPlay.setEnabled(false);
//                    playing = false;
//                    pause = true;
//                }
//                break;
//            }
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
