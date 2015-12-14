package com.timmy;

import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import java.awt.event.*;

public class Menu extends JMenuBar implements ActionListener, KeyListener {

    /* create menus for file, controls, and help */
    protected JMenuItem fOpen, fAdd, fClose;
    /* create menu items for the file menu */
    protected JMenuItem cPlay, cStop, cPrevious, cNext;
    /* create menu items for the controls menu */
    protected JMenuItem hAbout;
    /* create menu items for the help menu */

    protected JMenu fileMenu, controlsMenu, helpMenu;
    protected static MusicFile fileSelection;
    private static boolean fileAdded = false;
    private static boolean open = false;
    private static boolean add = false;

    public Menu() {

        /* Create each menu that will be in the menu bar:
        */

        //File Menu
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.addActionListener(this);
        fileMenu.addKeyListener(this);
        this.add(fileMenu);

        //Controls Menu
        controlsMenu = new JMenu("Controls");
        controlsMenu.setMnemonic(KeyEvent.VK_C);
        controlsMenu.addActionListener(this);
        this.add(controlsMenu);

        //Help Menu
        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        helpMenu.addActionListener(this);
        this.add(helpMenu);

        /* Create menu items that each menu will hold */

        /* File items:
        */

        //open
        fOpen = new JMenuItem("Open");
        fOpen.setMnemonic(KeyEvent.VK_O);
        fOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        fOpen.addActionListener(this);
        fOpen.setActionCommand("Open");
        fileMenu.add(fOpen);

        //add
        fAdd = new JMenuItem("Add to Library");
        fAdd.setMnemonic(KeyEvent.VK_A);
        fAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, (InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK) ));
        //input events are added together to require both keys to be pressed to enable shortcut, so ctrl + shift + "o"

        fAdd.addActionListener(this);
        fAdd.setActionCommand("Add");
        fileMenu.add(fAdd);
        fileMenu.addSeparator();

        //close
        fClose = new JMenuItem("Close Player");
        fClose.setMnemonic(KeyEvent.VK_E);
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

        //stop
        cStop = new JMenuItem("Stop");
//        cPlay.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, InputEvent.CTRL_MASK));
        cStop.addActionListener(this);
        controlsMenu.add(cStop);

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

    //Getters & Setters
    public static MusicFile getFileSelection() {return fileSelection;}
    public static void setFileSelection(MusicFile fileSelection) {Menu.fileSelection = fileSelection;}
    public static boolean isFileAdded() {return fileAdded;}
    public static void setFileAdded(boolean fileAdded) {Menu.fileAdded = fileAdded;}
    public static boolean isOpen() {return open;}
    public static void setOpen(boolean open) {Menu.open = open;}
    public static boolean isAdd() {return add;}
    public static void setAdd(boolean add) {Menu.add = add;}

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch(actionCommand) {
            case "Open": {
                System.out.println("Open");
                setOpen(true);
                FileChooser fc = new FileChooser();
                fc.addActionListener(this);
                fc.selectSong(fOpen);
                setOpen(false);
                break;

            }
            case "Add": {
                System.out.println("Add");
                setAdd(true);
                FileChooser fc = new FileChooser();
                fc.addActionListener(this);
                fc.selectSong(fAdd);
                setAdd(false);
                break;

            }
            case "Play": {
                break;
            }
            case "Close": {
                System.out.println("Close");
                System.exit(0);

                break;
            }
            case "ApproveSelection": {
                System.out.println(e.getActionCommand());
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
