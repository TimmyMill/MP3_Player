package com.timmy;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
//import javazoom.spi.mpeg.sampled.file.*;


public class PlaybackControls extends BasicPlayer {

    private boolean isPlaying = false;
    private boolean isPaused = false;

    public PlaybackControls() {
//        this.isPlaying = isPlaying;
//        this.isPaused = isPaused;
    }

    public void loadSong() {
//        String fileStr = ("file://" + Menu.getSelectedFile().getAbsolutePath());
        try {
//            open(new URL("file://" + Menu.getSelectedFile().getPath()));
            open(Menu.getSelectedFile().getFile());
//            open(Menu.getSelectedFile());
        }
        catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }

    public void play() throws BasicPlayerException {
        try {
            loadSong();
            startPlayback();
            isPlaying = true;
            System.out.println("Play");
        }
        catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        stopPlayback();
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

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

}
