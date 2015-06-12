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
//
//    public static void loginScreen() {
//        Stage window;
//        Scene scene1;
//
//        window = new Stage();
//        window.initModality(Modality.APPLICATION_MODAL);
//        window.setTitle("Log-in to address Book");
//
//        Pane pane = new Pane();
//        pane.setPrefHeight(323);
//        pane.setPrefWidth(311);
//
//        TextField usernameText = new TextField();
//        usernameText.setLayoutX(111);
//        usernameText.setLayoutY(129);
//        usernameText.setPromptText("Username");
//
//        PasswordField passwordField = new PasswordField();
//        passwordField.setLayoutX(111);
//        passwordField.setLayoutY(164);
//        passwordField.setPromptText("Password");
//
//        Label usernameLabel = new Label("Username");
//        usernameLabel.setLayoutX(51);
//        usernameLabel.setLayoutY(133);
//
//        Label passwordLabel = new Label("Password");
//        passwordLabel.setLayoutX(53);
//        passwordLabel.setLayoutY(168);
//
//        Button createButton = new Button("Create Account");
//        createButton.setLayoutX(98);
//        createButton.setLayoutY(195);
//        createButton.setPrefHeight(25);
//        createButton.setPrefWidth(100);
//
//        Button signinButton = new Button("Sign-in");
//        signinButton.setLayoutX(208);
//        signinButton.setLayoutY(195);
//
//        ImageView logoImage = new ImageView();
//        Image logo = new Image("AddressBookImage.png");
//        logoImage.setImage(logo);
//        logoImage.setFitHeight(122);
//        logoImage.setFitWidth(288);
//        logoImage.setLayoutX(12);
//        logoImage.setLayoutY(14);
//        logoImage.setPickOnBounds(true);
//        logoImage.setPreserveRatio(true);
//
//
//        pane.getChildren().addAll(usernameText, usernameLabel, passwordField, passwordLabel, createButton, signinButton, logoImage);
//
//        scene1 = new Scene(pane);
//        window.setResizable(false);
//        window.setScene(scene1);
//        window.show();
//    }


    public static void loginPrompt(){
        Connection conn = Database.dbConnector();
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


        if(test == 0){
            try {
                System.out.println("Blah");
                String query = "select * from user where username =? and password =?";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, usernameJTextField.getText());
                pst.setString(2, passwordJTextField.getText());
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                    System.out.println("User Found");
                }else{
                    System.out.println("User not found");
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }else if(test == 1){
            createAccountPrompt();
        }


        //TODO TEST REMOVE
        System.out.println(usernameJTextField.getText() + passwordJTextField.getText());
        System.out.println(test);
    }


    public static void createAccountPrompt(){

    }

}
