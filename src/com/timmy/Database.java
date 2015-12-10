package com.timmy;

import javax.swing.*;
import java.sql.*;

public class Database {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASSWORD = "linuxMy$ql";
    static JPasswordField pswd;
    static JPanel pwdPanel;

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

    public static void initDB() {
        Pwd pwd = new Pwd();
        pwdPanel = new JPanel();
        pwd.setContentPane(pwdPanel);
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
