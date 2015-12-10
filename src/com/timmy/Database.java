package com.timmy;

import java.sql.*;

public class Database {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = Pwd.getUser();
    private static final String PASSWORD = Pwd.getPassword();
    Connection conn = null;
    PreparedStatement psStat = null;
    Statement statement = null;
    ResultSet rs = null;

    public Database() {

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

    public void initDB() {

        try {
            conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);

            //Create the database if it doesn't exist
            String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS music_library";
            statement = conn.createStatement();
            statement.executeUpdate(createDatabaseSQL);
            System.out.println("Created music_library table");

            //Use the music_library database
            String useDatabaseSQL = "USE music_library";
            statement.executeUpdate(useDatabaseSQL);

            //Create a table in the database, if it doesn't exist
            String createTableSQL = "CREATE TABLE IF NOT EXISTS songs (title VARCHAR(30), artist VARCHAR(30), album VARCHAR (30))";
            statement.executeUpdate(createTableSQL);
            System.out.println("Created songs table");
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addSong() {

    }

    public void runDB() {
//        Statement statement = null;
//        PreparedStatement psStat = null;
//        Connection conn = null;
//        ResultSet rs = null;

        try {
//            conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
//            statement = conn.createStatement();
//            //Create a table in the database, if it doesn't exist
//            String createTableSQL = "CREATE TABLE IF NOT EXISTS songs (title VARCHAR(30), artist VARCHAR(30), album VARCHAR (30))";
//            statement.executeUpdate(createTableSQL);
//            System.out.println("Created songs table");

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
