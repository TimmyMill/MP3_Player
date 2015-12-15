/**
 * This is the main class used to run the program.
 * All of static objects that are needed to create the main components are instantiated here:
 *      - a controller for controlling audio playback
 *      - a menu bar containing different menu options
 *      - the audio player itself that holds all of the components
 *
 * Because the audio player is constructed using the controls and the menu, these two objects are created first.
 *
 * @Author: Timothy Milligan
 *
 */

package com.timmy;

public class Main {

    static AudioControls audioControls = new AudioControls();
    static Menu menu = new Menu(); //create the menu built in the menu class so we can use it to build the AudioPlayer
    static AudioPlayer player;

    public static void main(String[] args) {
//        Database.loadDriver();
//        runDB();
//        musicLibrary.loginDB();
        player = new AudioPlayer(menu, audioControls);
    }

}
