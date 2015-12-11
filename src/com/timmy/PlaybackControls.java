package com.timmy;

import javazoom.jlgui.basicplayer.*;

import java.util.Map;

public class PlaybackControls extends BasicPlayer implements BasicPlayerListener{

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

    @Override
    public void opened(Object o, Map map) {

    }

    @Override
    public void progress(int i, long l, byte[] bytes, Map map) {

    }

    @Override
    public void stateUpdated(BasicPlayerEvent basicPlayerEvent) {

    }

    @Override
    public void setController(BasicController basicController) {

    }
}