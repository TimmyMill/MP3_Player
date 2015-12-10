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
    private JButton stopButton;
    private boolean playing = false;
    protected Menu menu;
    protected PlaybackControls audioControls;
    protected Database library;

    public MusicPlayer(final Menu menu, final PlaybackControls audioControls) {
        this.menu = menu;
        this.audioControls = audioControls;
        initDB();
        library = new Database();

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

        //Action Listener for play button
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playControls();
            }
        });

        //Action Listener for play menu item
        menu.cPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playControls();
            }
        });

        //Action Listener for stop button
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                audioControls.stop();
                playButton.setText("Play");
                menu.cPlay.setText("Play");
            }
        });
    }

    //Method to control how the play button and play menu item function
    public void playControls() {
        //If song has been selected, do this
        if (Menu.getSelectedFile() != null) {
            try {
                //If song isn't playing AND isn't paused, start playback
                if (!audioControls.isPlaying() && !audioControls.isPaused()) {
                    audioControls.play();
                    playButton.setText("Pause"); //song is playing so change the button to pause
                    menu.cPlay.setText("Pause");
                }
                //If song is playing AND isn't paused, pause playback
                else if (audioControls.isPlaying() && !audioControls.isPaused()) {
                    audioControls.pause();
                    playButton.setText("Play"); //song is paused, so change the button to play
                    menu.cPlay.setText("Play");
                }
                //If song is paused, resume playback
                else if (audioControls.isPaused()) {
                    audioControls.resume();
                    playButton.setText("Pause"); //song has resumed, so change the button back to pause
                    menu.cPlay.setText("Pause");
                }
            } catch (BasicPlayerException bpe) {
                bpe.printStackTrace();
            }
        }
    }

    public void initDB() {
        Pwd dialog = new Pwd();
        dialog.pack();
        dialog.setVisible(true);
        Database.loadDriver();
    }

}
