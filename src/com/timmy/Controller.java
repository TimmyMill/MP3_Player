package com.timmy;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayerException;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class Controller implements BasicController {
    @Override
    public void open(InputStream inputStream) throws BasicPlayerException {

    }

    @Override
    public void open(File file) throws BasicPlayerException {

    }

    @Override
    public void open(URL url) throws BasicPlayerException {

    }

    @Override
    public long seek(long l) throws BasicPlayerException {
        return 0;
    }

    @Override
    public void play() throws BasicPlayerException {

    }

    @Override
    public void stop() throws BasicPlayerException {

    }

    @Override
    public void pause() throws BasicPlayerException {

    }

    @Override
    public void resume() throws BasicPlayerException {

    }

    @Override
    public void setPan(double v) throws BasicPlayerException {

    }

    @Override
    public void setGain(double v) throws BasicPlayerException {

    }
}
