package com.timmy;

import java.io.File;
import java.io.Serializable;

public class MusicFile implements Serializable {

    private String artist;
    private String album;
    private String title;
    private String path;
    private File file;

    public MusicFile(String path, File fileName) {
        this.path = path;
        this.file = fileName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Path: " + path + " " + "File: " + file;
        /*"MusicFile{" +
        "artist='" + artist + '\'' +
        ", album='" + album + '\'' +
        ", title='" + title + '\'' +
        ", path='" + path + '\'' +
        ", file=" + file +
        '}'; */
    }
}
