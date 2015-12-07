package com.timmy;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
    private JLabel currentlyPlayingLabel;
    private JPanel eastPanel;
    private boolean playing = false;
    protected Menu menu; //= new Menu();
    protected PlaybackControls audioControls; // = new PlaybackControls(this);

    public MusicPlayer(Menu menu, PlaybackControls audioControls) {
        this.menu = menu;
        this.audioControls = audioControls;
//        super("MP3");

        //JFrame Settings
//        menu = new Menu(); //create the menu built in the menu class so we can add it to the JFrame
        setJMenuBar(menu); //set our menu bar to the JFrame
        setContentPane(playerPanel);
        setTitle("MP3");
        setPreferredSize(new Dimension(500, 500));
        pack();
        setResizable(true);
        setFocusable(true);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


//                new javafx.embed.swing.JFXPanel();
//                String file = ("file://" + );
////                String file = ("file://" + Menu.getSelectedOpenFile());
//                System.out.println(file);
//                Media song = new Media(file);
//                MediaPlayer player = new MediaPlayer(song);
//                if (! playing) {
//                    player.play();
//                    playing = true;
//                }
//                else {
//                    player.pause();
//                    playing = false;
//                }
//                if (menu.playing) {
//                    player.play();
//                }
//                if (! menu.playing) {
//                    player.pause();
//                }
            }
        });

        playButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });
    }
}
