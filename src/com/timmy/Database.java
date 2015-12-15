package com.timmy;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class Database {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = Pwd.getUser();
    private static final String PASSWORD = Pwd.getPassword();
//    private static final String USER = "root";
//    private static final String PASSWORD = "linuxMy$ql";
    private static Connection conn = null;
    private static PreparedStatement psStat = null;
    private static Statement statement = null;
    private static ResultSet rs = null;
    private static ArrayList<MusicFile> libraryList;

    public Database() {
        libraryList = new ArrayList<>();
    }

    public void loadDriver() {

        try {
            Class.forName(JDBC_DRIVER);
        }

        catch (ClassNotFoundException cnfe) {
            System.out.println("Couldn't load Driver Class. Check to see if your drivers and classpath are configured correctly?");
            cnfe.printStackTrace();
            System.exit(-1);  //If there is no driver the program won't run correctly. Quit to check configuration.
        }

    }

    public void initDB() {

        try {
//            loadDriver();
//            MusicPlayer.loginDB();
            conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);

            //Create the database if it doesn't exist
            String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS music_library";
            statement = conn.createStatement();
            statement.executeUpdate(createDatabaseSQL);
            System.out.println("Created music_library table");

            //Use the music_library database
            String useDatabaseSQL = "USE music_library";
            statement.executeUpdate(useDatabaseSQL);

            //Create songs table in the database if it doesn't exist
            String createTableSQL = "CREATE TABLE IF NOT EXISTS songs (title VARCHAR(100), artist VARCHAR(100), album VARCHAR(100), path VARCHAR(200))";
            statement.executeUpdate(createTableSQL);
            System.out.println("Created songs table");

            //Get all of the songs from the file table
            loadMusicLibrary();
        }

        catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getErrorCode());
//            if (e.getErrorCode() == 1045) {
//                Pwd.setUser("");
//                Pwd.setPassword("");
//                MusicPlayer.loginDB();
//                initDB();
//            }

        }

    }

    //Method used to add a song to the database
    public static void addToSongs() {
//        libraryList = new ArrayList<>();

        if (Menu.isFileAdded()) {
            MusicFile file = Menu.getFileSelection();
            try {
                String psStatInsert = "INSERT INTO songs VALUES (?,?,?,?)";
                psStat = conn.prepareStatement(psStatInsert);
                psStat.setString(1, file.getTitle() );
                psStat.setString(2, file.getArtist() );
                psStat.setString(3, file.getAlbum() );
                psStat.setString(4, file.getPath() );
                psStat.executeUpdate();
                System.out.println("Added song: " + file.getTitle());
                libraryList.add(file);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //Method used to load all of the songs from the songs table
    public void loadMusicLibrary() {

        try {

            String fetchAllSongs = "SELECT * FROM songs";
            rs = statement.executeQuery(fetchAllSongs);
            while (rs.next()) {
                String path = rs.getString("path");
                File f = new File(path);
                MusicFile file = new MusicFile(path, f);
                libraryList.add(file);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void getSong() {
//
//        try {
//
//            String fetchAllSongs = "SELECT * FROM songs";
//            rs = statement.executeQuery(fetchAllSongs);
//            while (rs.next()) {
//                String title = rs.getString("title");
//                String artist = rs.getString("artist");
//                String album = rs.getString("album");
//                System.out.println("" + title + "" + artist + "" + album);
//            }
//
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    //Get Library
    public static ArrayList<MusicFile> getLibraryList() {return libraryList;}
}
