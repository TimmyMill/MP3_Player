package com.timmy;

public class Main {

    static PlaybackControls audioControls = new PlaybackControls(); 
    static Menu menu = new Menu(); //create the menu built in the menu class so we can use it to build the MusicPlayer
    static MusicPlayer player;

    public static void main(String[] args) {
//        Database.loadDriver();
//        runDB();
//        musicLibrary.loginDB();
        player = new MusicPlayer(menu, audioControls);
    }

}
