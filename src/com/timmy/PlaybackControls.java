package com.timmy;

import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayer;

public class PlaybackControls extends BasicPlayer {

    private boolean isPlaying = false;
    private boolean isPaused = false;

    public PlaybackControls() {
    }

    public void loadSong() {
        try {
            open(Menu.getSelectedFile().getFile());
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }

    public void play() throws BasicPlayerException {
        try {
            loadSong();
            startPlayback();
            isPlaying = true;
            System.out.println("Play");
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        stopPlayback();
        isPlaying = false;
        System.out.println("Stop");
    }

    public void pause() {
        pausePlayback();
        isPaused = true;
        System.out.println("Pause");
    }

    public void resume() {
        resumePlayback();
        isPaused = false;
        System.out.println("Resume");
    }

    /* Get & Set */

    public boolean isPlaying() {return isPlaying;}
    public void setPlaying(boolean playing) {isPlaying = playing;}

    public boolean isPaused() {return isPaused;}
    public void setPaused(boolean paused) {isPaused = paused;}
}