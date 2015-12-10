package com.timmy;

public class Main {

    static PlaybackControls audioControls = new PlaybackControls(); 
    static Menu menu = new Menu(audioControls); //create the menu built in the menu class so we can use it to build the MusicPlayer
    static MusicPlayer player;
    static Pwd dialog;

    public static void main(String[] args) {
//        loadDriver();
//        runDB();
        dialog = new Pwd();
        dialog.pack();
        dialog.setVisible(true);
        player = new MusicPlayer(menu, audioControls);
    }

}
