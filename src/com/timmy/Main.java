package com.timmy;

public class Main {

    static Menu menu = new Menu();
    static MusicPlayer player;
    static PlaybackControls audioControls;

    public static void main(String[] args) {
        player = new MusicPlayer(menu);
        audioControls = new PlaybackControls(player);
    }
}
