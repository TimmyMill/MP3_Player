package com.timmy;

import javazoom.jlgui.basicplayer.BasicPlayerException;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class MusicPlayer extends JFrame implements ActionListener, Serializable {

    private JPanel playerPanel;
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
    private JTable table;
    private DefaultTableModel tableModel;
    private ListSelectionModel tableListModel;
    private DefaultTableColumnModel columnModel;

    //Custom Built Objects needed by the Music Player
    protected Menu menu;
    protected PlaybackControls audioControls;
    protected Database library;

    public MusicPlayer(final Menu menu, final PlaybackControls audioControls) {
        this.menu = menu;
        this.audioControls = audioControls;
        String[] columnHeadings = {"Title", "Artist", "Album", "Path"};

        //Run login method before database is initialized to ensure database connection is made
//        loginDB();

        library = new Database(); //initialize database object
        library.initDB();         //run method to connect and create the database if it doesn't already exist

        //JFrame Settings
        setJMenuBar(menu); //set our custom menu bar to the JFrame
        setContentPane(playerPanel);
        setTitle("MusicFile");
        setPreferredSize(new Dimension(600, 600));
        pack();
        setResizable(true);
        setFocusable(true);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        /* JTable Settings
        */

        //Table Model
        tableModel = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };

        //Create columns
        tableModel.setColumnIdentifiers(columnHeadings); //use a string array to give each column a name

        //Create rows
        for (MusicFile file : Database.getLibraryList()) { //iterate the library list created in Database
//            tableModel.addRow(file.getSongInfo().toArray());
            ArrayList<String> lst = file.getSongInfo();
            lst.add(file.getPath());
            Object[] str = lst.toArray();
            tableModel.addRow(str);
            /* for each audio file, use the getSongInfo method to extract the metadata and then add it to an array */
            /* use the array to add a new row to the table */
        }

        //Table List Model
        tableListModel = new DefaultListSelectionModel();
//        tableListModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //Table Column Model
        columnModel = new DefaultTableColumnModel();
        columnModel.setSelectionModel(tableListModel);


        table.setModel(tableModel);
        table.setSelectionModel(tableListModel);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowSelectionAllowed(true);
        final TableColumn filePathColumn = table.getColumnModel().getColumn(3);
        table.getColumnModel().removeColumn(filePathColumn);



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

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2) {
                    System.out.println("Double Click");
                    Object g = tableModel.getValueAt(table.getSelectedRow(), 3);
                    Menu.setSelectedFile(new MusicFile((String) g, new File(g.toString())));
                    playControls();
                    System.out.println(g.toString());

                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }
        });

        table.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                super.componentAdded(e);
            }

            @Override
            public void componentRemoved(ContainerEvent e) {
                super.componentRemoved(e);
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


