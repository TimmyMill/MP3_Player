package com.timmy;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PlaybackControls extends JFXPanel {

    private static MediaPlayer audioPlayer;

    public PlaybackControls() {
    }

    public void loadSong() {
        String fileStr = ("file://" + Menu.getSelectedFile().getAbsolutePath());
        Media song = new Media(fileStr);
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
