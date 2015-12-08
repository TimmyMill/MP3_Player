package com.timmy;

import javafx.scene.media.MediaPlayer;

public class Main {

    static PlaybackControls audioControls = new PlaybackControls();
    static Menu menu = new Menu(audioControls);
    static MusicPlayer player;

    public static void main(String[] args) {
        player = new MusicPlayer(menu, audioControls);
    }
}
