package com.timmy;

/**
 *
 */

import javazoom.jlgui.basicplayer.BasicPlayerException;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class AudioPlayer extends JFrame implements Serializable {

    private JPanel playerPanel;
    private JPanel northPanel;
    private JPanel eastPanel;
    private JPanel westPanel;
    private JPanel centerPanel;
    private JTree tree1;
    private JLabel currentlyPlayingLabel;
    private JButton playButton;
    private JButton stopButton;
    private JButton previousButton;
    private JButton nextButton;
    private JTable table;
    private DefaultTableModel tableModel;
    private ListSelectionModel tableListModel;
    private DefaultTableColumnModel columnModel;
    private TableRowSorter<DefaultTableModel> rowSorter;

    //Custom Built Objects needed by the Music Player
    protected Menu menu;
    protected AudioControls audioControls;
    protected Database library;

    public AudioPlayer(final Menu menu, final AudioControls audioControls) {
        this.menu = menu;
        this.audioControls = audioControls;
        String[] columnHeadings = {"Title", "Artist", "Album", "Path"};

        //Run login method before database is initialized to ensure database connection is made
        loginDB();
        library = new Database(); //initialize database object
        library.loadDriver();

        library.initDB();         //run method to connect and create the database if it doesn't already exist

        //JFrame Settings
        setJMenuBar(menu); //set our custom menu bar to the JFrame
        setContentPane(playerPanel);
        setTitle("AudioPlayer");
        setPreferredSize(new Dimension(600, 600));
        pack();
        setResizable(true);
        setFocusable(true);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Set Control Button Mnemonics
        playButton.setMnemonic(KeyEvent.VK_P);
        stopButton.setMnemonic(KeyEvent.VK_S);
        previousButton.setMnemonic(KeyEvent.VK_LEFT);
        nextButton.setMnemonic(KeyEvent.VK_RIGHT);

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
        if (Database.getLibraryList() != null) {
            for (AudioFile file : Database.getLibraryList()) { //iterate the library list created in Database
//            tableModel.addRow(file.getSongInfo().toArray());
                ArrayList<String> lst = file.getSongInfo();
                lst.add(file.getPath());
                Object[] str = lst.toArray();
                tableModel.addRow(str);
            /* for each audio file, use the getSongInfo method to extract the metadata and then add it to an array */
            /* use the array to add a new row to the table */
            }
        }

        //Table List Model
        tableListModel = new DefaultListSelectionModel();

//        tableListModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //Table Column Model
        columnModel = new DefaultTableColumnModel();
        columnModel.setSelectionModel(tableListModel);


        rowSorter = new TableRowSorter<>();
        rowSorter.setModel(tableModel);

        table.setModel(tableModel);
        table.setSelectionModel(tableListModel);
        table.setRowSorter(rowSorter);

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

        //Action Listener for previous button
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO implement skipping to previous song
            }
        });

        //Action Listener for next button
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO implement skipping to next song
            }
        });

        menu.fAdd.addActionListener(new ActionListener() { // FIXME: 12/13/15
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add");
                Menu.setAdd(true);
                FileChooser fc = new FileChooser();
//                fc.addActionListener(this);
                fc.selectSong(menu.fAdd);
//                Menu.setAdd(false);
                if (Menu.isFileAdded()) {
                    System.out.println("Add row called");
//            Database.addToSongs();
                    addRowToTable();
                    Menu.setFileAdded(false);
                }
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                //If mouse is double clicked, get the row that's selected to play song
                if (e.getClickCount() == 2) {
//                    System.out.println("Double Click");
//                    Object f = tableModel.getValueAt(table.getSelectedRow(), 3);
//                    Object selectedSong = table.getModel().getValueAt(table.convertRowIndexToView(table.getSelectedRow(), 3));
                    int i = rowSorter.convertRowIndexToModel(table.getSelectedRow());
                    Object f = tableModel.getValueAt(i, 3);
                    //create a new object to hold information about the selected row and that song's filepath
                    Menu.setFileSelection(new AudioFile((String) f, new File(f.toString())));
                    /* create a new music file using our throwaway object so we can load the file to play
                     * set the selected file in the Menu class */
                    playControls();
                    System.out.println(f.toString());

                }
                System.out.println(e.getButton());

            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (e.getClickCount() == 2) {
                    System.out.println("Double tap");
                }
            }
        });

        table.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                super.componentAdded(e);
                System.out.println(e.getID());

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
        if (Menu.getFileSelection() != null) {
            try {
                //If song isn't playing AND isn't paused, start playback
                if (!audioControls.isPlaying() && !audioControls.isPaused()) {
                    audioControls.play();
                    currentlyPlayingLabel.setText(Menu.getFileSelection().toString());
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

    public void addRowToTable() {
//            tableModel.addRow(file.getSongInfo().toArray());
//            ArrayList<String> lst = file.getSongInfo();
//            lst.add(file.getPath());
        Database.getLibraryList();
//        ArrayList<String> lst = file.getSongInfo();
        ArrayList<String> lst = Menu.getFileSelection().getSongInfo();
        lst.add(Menu.getFileSelection().getPath());
        Object[] str = lst.toArray();
        tableModel.addRow(str);
        /* for each audio file, use the getSongInfo method to extract the metadata and then add it to an array */
        /* use the array to add a new row to the table */


    }

    public static void loginDB() {
        Pwd dialog = new Pwd();
        dialog.pack();
        dialog.setVisible(true);
//        Database.loadDriver();
    }

}


