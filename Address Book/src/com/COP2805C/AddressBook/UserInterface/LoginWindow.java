package com.COP2805C.AddressBook.UserInterface;

import com.COP2805C.AddressBook.Database.Database;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by EpiphX on 6/8/2015.
 */
public class LoginWindow {
//    TODO ???
//    public static String[] loginPrompt(){
//        Connection conn = Database.dbConnector();

    public static String[] loginPrompt() {

        //Username
        JLabel usernameLabel = new JLabel("Username");
        JTextField usernameJTextField = new JTextField();
        JPanel usernameJPanel = new JPanel();
        usernameJPanel.setLayout(new BoxLayout(usernameJPanel, BoxLayout.X_AXIS));
        usernameJPanel.add(usernameLabel);
        usernameJPanel.add(usernameJTextField);


        //Password
        JLabel passwordLabel = new JLabel("Password ");
        JPasswordField passwordJTextField = new JPasswordField();
        JPanel passwordJpanel = new JPanel();
        passwordJpanel.setLayout(new BoxLayout(passwordJpanel, BoxLayout.X_AXIS));
        passwordJpanel.add(passwordLabel);
        passwordJpanel.add(passwordJTextField);


        //Main JPanel
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.add(usernameJPanel);
        jPanel.add(passwordJpanel);


        //JOptionPane
        String[] buttons = {"Login", "Create Account"};
        int test = JOptionPane.showOptionDialog(
                null,
                jPanel,
                "Login",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                buttons, buttons[0]);

            //TODO does not beling in LoginWindow.java belongs in database or functions
//        if(test == 0){
//            try {
//                System.out.println("Blah");
//                String query = "select * from user where username =? and password =?";
//                PreparedStatement pst = conn.prepareStatement(query);
//                pst.setString(1, usernameJTextField.getText());
//                pst.setString(2, passwordJTextField.getText());
//                ResultSet rs = pst.executeQuery();
//                if(rs.next()){
//                    System.out.println("User Found");
//                }else{
//                    System.out.println("User not found");
//                }
//            }catch(SQLException e){
//                e.printStackTrace();
//            }
//        }else if(test == 1){
//            //createAccountPrompt();
//        }

        //TODO TEST REMOVE
        System.out.println(usernameJTextField.getText() + passwordJTextField.getText());
        System.out.println(test);

        //Login
        if (test == 0) {
            //TODO create account
        }else {
            //Return string array with username and password
            return new String[]{usernameJTextField.getText(), passwordJTextField.getText()};
        }
        return new String[]{usernameJTextField.getText(), passwordJTextField.getText()};
    }
}
