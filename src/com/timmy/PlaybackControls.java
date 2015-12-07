package com.timmy;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class PlaybackControls extends JFXPanel {

    private MediaPlayer audioPlayer;
//    private MusicPlayer player;

    public PlaybackControls(MediaPlayer player) {
        this.audioPlayer = player;
    }

    public String loadSong() {
//        File file = player.menu.getSelectedOpenFile();
        String fileStr = ("file://" + file.getAbsolutePath());
        Media song = new Media(fileStr);
        audioPlayer = new MediaPlayer(song);
        return fileStr;
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


//public class PlaybackControls extends JFXPanel {
//
//    private static MediaPlayer audioPlayer;
//    private File file;
//
//    public PlaybackControls(File file) {
//        this.file = file;
//    }
//
//    public void loadSong() {
//        file = Menu.getSelectedOpenFile();
//        String fileStr = ("file://" + file.getAbsolutePath());
//        Media song = new Media(fileStr);
//        audioPlayer = new MediaPlayer(song);
//    }
//
//    public void play() {
//        loadSong();
//        audioPlayer.play();
//    }
//
//    public void stop() {
//        audioPlayer.stop();
//    }
//
//    public void pause() {
//        audioPlayer.pause();
//    }
//
//}