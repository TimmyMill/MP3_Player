package com.timmy;

import javazoom.jlgui.basicplayer.BasicPlayerException;

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
    protected Menu menu;
    protected PlaybackControls audioControls;

    public MusicPlayer(final Menu menu, final PlaybackControls audioControls) {
        this.menu = menu;
        this.audioControls = audioControls;

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
                try {
                    //If song isn't playing AND isn't paused, start playback
                    if ( !audioControls.isPlaying() && !audioControls.isPaused() ) {
                        audioControls.play();
                    }
                    //If song is playing AND isn't paused, pause playback
                    else if (audioControls.isPlaying() && !audioControls.isPaused() ) {
                        audioControls.pause();
                    }
                    //If song is paused, resume playback
                    else if (audioControls.isPaused()) {
                        audioControls.resume();
                    }
                } catch (BasicPlayerException bpe) {
                    bpe.printStackTrace();
                }

            }
        });

        playButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });
    }
}
