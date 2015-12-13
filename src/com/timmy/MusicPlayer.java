package com.timmy;

import javazoom.jlgui.basicplayer.BasicPlayerException;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.Arrays;

public class MusicPlayer extends JFrame implements ActionListener, Serializable {

    private JPanel playerPanel;
    private JTable musicTable;
    private JButton playButton;
    private JPanel northPanel;
    private JTree tree1;
    private JPanel westPanel;
    private JPanel centerPanel;
    private JButton nextButton;
    private JButton previousButton;
    private JLabel currentlyPlayingLabel;
    private JPanel eastPanel;
    private JButton stopButton;
    private TableModel tableModel;
    private ListSelectionModel tableListModel;

    //Custom Built Objects needed by the Music Player
    protected Menu menu;
    protected PlaybackControls audioControls;
    protected Database library;

    public MusicPlayer(final Menu menu, final PlaybackControls audioControls) {
        this.menu = menu;
        this.audioControls = audioControls;

        //Run login method before database is initialized to ensure database connection is made
        loginDB();

        library = new Database(); //initialize database object
        library.initDB();         //run method to connect and create the database if it doesn't already exist

        //JFrame Settings
        setJMenuBar(menu); //set our custom menu bar to the JFrame
        setContentPane(playerPanel);
        setTitle("MusicFile");
        setPreferredSize(new Dimension(500, 500));
        pack();
        setResizable(true);
        setFocusable(true);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        /* JTable Settings
        */

        //Table Model
        tableModel = new DefaultTableModel();
//        {
//            public boolean isCellEditable(int rowIndex, int colIndex) {
//                return false;
//            }
//        };

//        //Create columns
//        String[] columnHeadings = {"Title", "Artist", "Album"};
//        for (String str : columnHeadings) { //iterate column headings array
//            tableModel.addColumn(str);
//            /* creates the columns for the table and sets their headings
//            with the string values from array */
//        }
//
//        //Create rows
//        for (MusicFile file : Database.getLibraryList()) {
//            tableModel.addRow(file.getSongInfo().toArray());
//        }

        //Table List Model
        tableListModel = new DefaultListSelectionModel();
//        tableListModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        musicTable.setModel(tableModel);
        musicTable.setSelectionModel(tableListModel);

        musicTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        musicTable.setRowSelectionAllowed(true);


        /* Action Listeners
        **/

        //Action Listener for play button
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playControls();
            }
        });

        //Action Listener for play menu item
        menu.cPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playControls();
            }
        });

        //Action Listener for stop button
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                audioControls.stop();
                playButton.setText("Play");
                menu.cPlay.setText("Play");
            }
        });

        musicTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2) {
                    System.out.println("Double Click");
//                    musicTable.getSelectedRow();
                    System.out.println("Row= " + musicTable.getSelectedRow());
//                    System.out.println("Column= " + Arrays.toString(musicTable.getSelectedColumns()));
                    System.out.println(tableModel.getValueAt(musicTable.getSelectedRow(), 2));
                    Object f = tableModel.getValueAt(musicTable.getSelectedRow(), musicTable.getSelectedColumn());
                    System.out.println(f.toString());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }
        });
    }

    /* Method to control how the play button and play menu item function
    **/
    public void playControls() {
        //If song has been selected, do this
        if (Menu.getSelectedFile() != null) {
            try {
                //If song isn't playing AND isn't paused, start playback
                if (!audioControls.isPlaying() && !audioControls.isPaused()) {
                    audioControls.play();
                    currentlyPlayingLabel.setText(Menu.getSelectedFile().getSongInfo().toString());
                    playButton.setText("Pause"); //song is playing so change the button to pause
                    menu.cPlay.setText("Pause");
                }
                //If song is playing AND isn't paused, pause playback
                else if (audioControls.isPlaying() && !audioControls.isPaused()) {
                    audioControls.pause();
                    playButton.setText("Play"); //song is paused, so change the button to play
                    menu.cPlay.setText("Play");
                }
                //If song is paused, resume playback
                else if (audioControls.isPaused()) {
                    audioControls.resume();
                    playButton.setText("Pause"); //song has resumed, so change the button back to pause
                    menu.cPlay.setText("Pause");
                } else {
                    currentlyPlayingLabel.setText("");
                }
            } catch (BasicPlayerException bpe) {
                bpe.printStackTrace();
            }
        }
    }

    public static void loginDB() {
        Pwd dialog = new Pwd();
        dialog.pack();
        dialog.setVisible(true);
//        Database.loadDriver();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        menu.fAdd.isSelected();
    }
}


