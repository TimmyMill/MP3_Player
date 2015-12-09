package com.timmy;

import javazoom.jlgui.basicplayer.BasicPlayerException;

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
        setTitle("MusicFile");
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
                        playButton.setText("Pause"); //song is playing so change the button to pause
                    }
                    //If song is playing AND isn't paused, pause playback
                    else if (audioControls.isPlaying() && !audioControls.isPaused() ) {
                        audioControls.pause();
                        playButton.setText("Play"); //song is paused, so change the button to play
                    }
                    //If song is paused, resume playback
                    else if (audioControls.isPaused()) {
                        audioControls.resume();
                        playButton.setText("Pause"); //song has resumed, so change the button back to pause
                    }
                } catch (BasicPlayerException bpe) {
                    bpe.printStackTrace();
                }

            }
        });
    }
}
