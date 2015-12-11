package com.timmy;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class MusicFile implements Serializable {

    private String artist;
    private String album;
    private String title;
    private String path;
    private File file;
    private ArrayList<String> songInfo;

    public MusicFile(String path, File file) {
        this.path = path;
        this.file = file;
        songInfo = new ArrayList<>();
        getSongData();
    }

    private void getSongData() {
        try (InputStream input = new FileInputStream(file))
        {
            DefaultHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseCon = new ParseContext();
            parser.parse(input, handler, metadata, parseCon);

            title = metadata.get("title");
            artist = metadata.get("xmpDM:artist");
            album = metadata.get("xmpDM:album");

            songInfo.add(title);
            songInfo.add(artist);
            songInfo.add(album);

            input.close();
        }

        catch (IOException | SAXException | TikaException e) {
            e.printStackTrace();
        }

    }

    //Getters
    public ArrayList<String> getSongInfo() {return songInfo;}
    public String getPath() {return path;}
    public File getFile() {return file;}
    public String getArtist() {return artist;}
    public String getAlbum() {return album;}
    public String getTitle() {return title;}
}
