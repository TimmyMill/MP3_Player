package com.timmy;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
//import javazoom.spi.mpeg.sampled.file.*;


public class PlaybackControls extends BasicPlayer {

    private boolean isPlaying = false;
    private boolean isPaused = false;

    public PlaybackControls() {
    }

    public void loadSong() {
        try {
            open(Menu.getSelectedFile().getFile());
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

//    //playback
//    public void playButtonControls() {
//        try {
//            //If song isn't playing AND isn't paused, start playback
//            if ( isPlaying() && isPaused() ) {
//                play();
//                MusicPlayer.getPlayButton().setText("Pause"); //song is playing so change the button to pause
//            }
//            //If song is playing AND isn't paused, pause playback
//            else if (isPlaying() && isPaused() ) {
//                pause();
//                MusicPlayer.getPlayButton().setText("Play"); //song is paused, so change the button to play
//            }
//            //If song is paused, resume playback
//            else if (isPaused()) {
//                resume();
//                MusicPlayer.getPlayButton().setText("Pause"); //song has resumed, so change the button back to pause
//            }
//        } catch (BasicPlayerException bpe) {
//            bpe.printStackTrace();
//        }
//
//    }

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
