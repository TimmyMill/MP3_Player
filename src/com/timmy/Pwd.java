package com.timmy;

import javax.swing.*;
import java.awt.event.*;

public class Pwd extends JDialog {

    private JPanel contentPane;
    private JButton buttonOK;
    private JPasswordField passwordField;
    private JTextField userTextField;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private static String user;
    private static String password = "";

    public Pwd() {
        setContentPane(contentPane);
        setTitle("MySQL Login");
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        user = userTextField.getText();
        for (char c : passwordField.getPassword()) {
            String str = String.valueOf(c);
            password = password + str;
        }
        System.out.println(user);
        System.out.println(password);
        dispose();
    }

    //Get & Set User
    public static String getUser() {return user;}
    public static void setUser(String user) {Pwd.user = user;}

    //Get & Set Password
    public static String getPassword() {return password;}
    public static void setPassword(String password) {Pwd.password = password;}

}
