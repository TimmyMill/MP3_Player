package com.timmy;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusicPlayer extends JFrame {
    private JPanel playerPanel;
    private JTable table1;
    private JButton playButton;
    private JPanel northPanel;
    private JTree tree1;
    private JPanel westPanel;
    private JPanel centerPanel;
    private JButton nextButton;
    private JButton previousButton;
    private Menu menu;

    public MusicPlayer() {
        super("MP3");

        //JFrame Settings
        menu = new Menu(); //create the menu built in the menu class so we can add it to the JFrame
        setJMenuBar(menu); //set our menu bar to the JFrame
        setContentPane(playerPanel);
        setPreferredSize(new Dimension(500, 500));
        pack();
        setResizable(true);
        setFocusable(true);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new javafx.embed.swing.JFXPanel();
                String file = "file:///home/timmy/Music/LastWinter-ChasingLights.mp3";
                Media song = new Media(file);
                MediaPlayer player = new MediaPlayer(song);
                player.play();
            }
        });
    }
}
