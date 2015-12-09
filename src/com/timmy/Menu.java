package com.timmy;

import javazoom.jlgui.basicplayer.BasicPlayerException;

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
    private static File selectedFile;
    private static boolean open = false;
    private static boolean add = false;
    private PlaybackControls audioControls;

    public Menu(PlaybackControls audioControls) {
        this.audioControls = audioControls;
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

        //add
        fAdd = new JMenuItem("Add Music");
        fAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, (InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK) ));
        fAdd.addActionListener(this);
        fAdd.setActionCommand("Add");
        fileMenu.add(fAdd);
        fileMenu.addSeparator();

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

    public static void selectSong(JMenuItem menuItem) {
        JFileChooser fc = new JFileChooser();

        if (open) {
            fc.setDialogTitle("Open File");
        }
        if (add) {
            fc.setDialogTitle("Add File");
        }

        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setCurrentDirectory(new File(System.getProperty("user.home")));
        fc.showOpenDialog(menuItem);

        if (fc.getSelectedFile() != null) {
            selectedFile = fc.getSelectedFile();
            System.out.println("Selection: " + selectedFile.getAbsolutePath());
        }

    }

    public static File getSelectedFile() {
        return selectedFile;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch(actionCommand) {
            case "Open": {
                System.out.println("Open");
                open = true;
                selectSong(fOpen);
                open = false;
                break;

            }
            case "Add": {
                System.out.println("Add");
                add = true;
                selectSong(fAdd);
                add = false;
                break;

            }
            case "Play": {
                try {
                    audioControls.play();
                } catch (BasicPlayerException bpe) {
                    bpe.printStackTrace();
                }

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
