package com.timmy;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileChooser extends JFileChooser implements ActionListener {

    public FileChooser() {
        setFileSelectionMode(JFileChooser.FILES_ONLY); //set File Chooser to only select files
        //TODO create a statement or method that allows a user to select a folder and add all audio files contained within it
        setFileFilter(new FileNameExtensionFilter("Mp3", "mp3")); //set File Chooser to only allow mp3 files to be selected
        //TODO implement addChoosableFileFilter when player is able to play more file types
        setCurrentDirectory(new File(System.getProperty("user.home"))); //sets File Chooser's starting directory to the user's home directory
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
