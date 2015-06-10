package com.COP2805C.AddressBook.UserInterface;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by EpiphX on 6/8/2015.
 */
public class LoginWindow {

    public static void loginScreen() {
        Stage window;
        Scene scene1;

        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Log-in to address Book");

        Pane pane = new Pane();
        pane.setPrefHeight(323);
        pane.setPrefWidth(311);

        TextField usernameText = new TextField();
        usernameText.setLayoutX(111);
        usernameText.setLayoutY(129);
        usernameText.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setLayoutX(111);
        passwordField.setLayoutY(164);
        passwordField.setPromptText("Password");

        Label usernameLabel = new Label("Username");
        usernameLabel.setLayoutX(51);
        usernameLabel.setLayoutY(133);

        Label passwordLabel = new Label("Password");
        passwordLabel.setLayoutX(53);
        passwordLabel.setLayoutY(168);

        Button createButton = new Button("Create Account");
        createButton.setLayoutX(98);
        createButton.setLayoutY(195);
        createButton.setPrefHeight(25);
        createButton.setPrefWidth(100);

        Button signinButton = new Button("Sign-in");
        signinButton.setLayoutX(208);
        signinButton.setLayoutY(195);

        ImageView logoImage = new ImageView();
        Image logo = new Image("AddressBookImage.png");
        logoImage.setImage(logo);
        logoImage.setFitHeight(122);
        logoImage.setFitWidth(288);
        logoImage.setLayoutX(12);
        logoImage.setLayoutY(14);
        logoImage.setPickOnBounds(true);
        logoImage.setPreserveRatio(true);


        pane.getChildren().addAll(usernameText, usernameLabel, passwordField, passwordLabel, createButton, signinButton, logoImage);

        scene1 = new Scene(pane);
        window.setResizable(false);
        window.setScene(scene1);
        window.show();
    }
}
