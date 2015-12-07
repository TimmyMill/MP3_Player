package com.timmy;

import javafx.scene.media.MediaPlayer;

public class Main {

    static Menu menu = new Menu();
    static MusicPlayer player;
    static PlaybackControls audioControls;
    static MediaPlayer mediaPlayer;

    public static void main(String[] args) {
        player = new MusicPlayer(menu, audioControls);
        audioControls = new PlaybackControls(player);
    }
}
