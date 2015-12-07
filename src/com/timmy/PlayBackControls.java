package com.timmy;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class PlayBackControls extends JFXPanel {

    private MediaPlayer audioPlayer;
    private File file;
    private String fileStr;
    private Media song;

    public PlayBackControls(MediaPlayer audioPlayer, File file, String fileStr, Media song) {
        this.audioPlayer = audioPlayer;
        this.file = file;
        this.fileStr = fileStr;
        this.song = song;
    }

    public void loadSong() {
        file = Menu.getSelectedOpenFile();
        fileStr = ("file://" + file.getAbsolutePath());
        song = new Media(fileStr);
        audioPlayer = new MediaPlayer(song);
    }

    public void play() {
        loadSong();
        audioPlayer.play();
    }

    public void stop() {
        audioPlayer.stop();
    }

    public void pause() {
        audioPlayer.pause();
    }

}
