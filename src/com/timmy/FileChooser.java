package com.timmy;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.KeyEvent;
import java.io.File;

public class FileChooser extends JFileChooser {

    public FileChooser() {
        setFileSelectionMode(JFileChooser.FILES_ONLY); //set File Chooser to only select files
        //TODO create a statement or method that allows a user to select a folder and add all audio files contained within it
        setFileFilter(new FileNameExtensionFilter("Mp3", "mp3")); //set File Chooser to only allow mp3 files to be selected
        //TODO implement addChoosableFileFilter when player is able to play more file types
        setCurrentDirectory(new File(System.getProperty("user.home"))); //sets File Chooser's starting directory to the user's home directory
    }

    //Method to open or add a file
    public void selectSong(JMenuItem menuItem) {

        /* Both if statements open a file chooser dialog box to allow user to select a file from their computer
         * A new audio file is created using this file
        */

        //If open file was selected, do this
        if (Menu.isOpen()) {
            setDialogTitle("Open File"); //since open was selected, title says open
            setApproveButtonText("Open");
            setApproveButtonMnemonic(KeyEvent.VK_O);
            showOpenDialog(menuItem);

            if (getSelectedFile() != null) {
                File f = getSelectedFile();
                String path = f.getPath();

                if (Menu.getFileSelection() == null) {
                    Menu.fileSelection = new MusicFile(path, f);
                    System.out.println("File has been set");
                }

                else {
                    Menu.setFileSelection(new MusicFile(path, f));
                }
            }
        }

        //If add file was selected, do this
        if (Menu.isAdd()) {
            setDialogTitle("Add File"); //since add was selected, title says add
            setApproveButtonText("Import");
            setApproveButtonMnemonic(KeyEvent.VK_I);
            showOpenDialog(menuItem);

            if (getSelectedFile() != null) {
                File f = getSelectedFile();
                String path = f.getPath();

                if (Menu.getFileSelection() == null) {
                    Menu.fileSelection = new MusicFile(path, f);
                    System.out.println("File has been set");
                }

                else {
                    Menu.setFileSelection(new MusicFile(path, f));
                }

                Menu.setFileAdded(true); //set boolean true because file is being added
                Database.addToSongs();   //calls method from Database to add file to the table in our database
            }
        }

    }
}