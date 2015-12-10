package com.timmy;

import java.sql.*;

public class Main {

    static PlaybackControls audioControls = new PlaybackControls(); 
    static Menu menu = new Menu(audioControls); //create the menu built in the menu class so we can use it to build the MusicPlayer
    static MusicPlayer player;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/music_library";
    static final String USER = "root";
    static final String PASSWORD = "linuxMy$ql";


    public static void main(String[] args) {
        loadDriver();
        runDB();
        player = new MusicPlayer(menu, audioControls);
    }

    public static void loadDriver() {
        try {
            Class.forName(JDBC_DRIVER);
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("Can't instantiate driver class; check you have drivers and classpath configured correctly?");
            cnfe.printStackTrace();
            System.exit(-1);  //No driver? Need to fix before anything else will work. So quit the program
        }

    }

    public static void runDB() {
        Statement statement = null;
        PreparedStatement psStat = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
            statement = conn.createStatement();
            //Create a table in the database, if it doesn't exist
            String createTableSQL = "CREATE TABLE IF NOT EXISTS songs (title VARCHAR(30), artist VARCHAR(30), album VARCHAR (30))";
            statement.executeUpdate(createTableSQL);
            System.out.println("Created songs table");

            String fetchAllSongs = "SELECT * FROM songs";
            rs = statement.executeQuery(fetchAllSongs);
            while (rs.next()) {
                String title = rs.getString("title");
                String artist = rs.getString("artist");
                String album = rs.getString("album");
                System.out.println("" + title + "" + artist + "" + album);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
