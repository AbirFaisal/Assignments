package com.COP2805C.AddressBook.UserInterface;

import com.COP2805C.AddressBook.Main;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateContactWindow{
    private Desktop desktop = Desktop.getDesktop();
    private static String fileString;
    private static Stage window;
    private static Scene scene;

    public static void display(String[] credentials){
        window = new Stage();
        window.setResizable(false);
        window.setMinWidth(379);
        window.setMinHeight(535);
        window.initModality(Modality.APPLICATION_MODAL);

        Pane pane = new Pane();
        pane.setPrefHeight(535);
        pane.setPrefWidth(379);

        Label fname = new Label("First Name");
        fname.setLayoutX(13);
        fname.setLayoutY(171);

        Label lname = new Label("Last Name");
        lname.setLayoutX(13);
        lname.setLayoutY(202);

        Label phone = new Label("Phone");
        phone.setLayoutX(13);
        phone.setLayoutY(232);

        Label email = new Label("Email");
        email.setLayoutX(13);
        email.setLayoutY(261);

        Label create = new Label("Create a contact");
        create.setLayoutX(157);
        create.setLayoutY(25);

        TextField fnameText = new TextField();
        fnameText.setLayoutX(109);
        fnameText.setLayoutY(166);
        fnameText.setPrefHeight(26);
        fnameText.setPrefWidth(244);

        TextField lnameText = new TextField();
        lnameText.setLayoutX(109);
        lnameText.setLayoutY(197);
        lnameText.setPrefHeight(26);
        lnameText.setPrefWidth(244);

        TextField phoneText = new TextField();
        phoneText.setLayoutX(109);
        phoneText.setLayoutY(227);
        phoneText.setPrefHeight(26);
        phoneText.setPrefWidth(244);

        TextField emailText = new TextField();
        emailText.setLayoutX(109);
        emailText.setLayoutY(256);
        emailText.setPrefHeight(26);
        emailText.setPrefWidth(244);

        Button createButton = new Button("Create");
        createButton.setLayoutX(108);
        createButton.setLayoutY(296);
        createButton.setMnemonicParsing(false);
        createButton.setOnAction(e ->
        {
            try {
                int key = Main.database.createContact(credentials[0]);
                Main.database.addNames(key, fnameText.getText(), null, lnameText.getText(), null);
                Main.database.addDynamicData(key, emailText.getText());
                Main.database.addPicture(key, fileString);
                window.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e-> window.close());
        cancelButton.setLayoutX(227);
        cancelButton.setLayoutY(296);
        cancelButton.setMnemonicParsing(false);
        //TODO Work on passing file directory instead of website
        ImageButton imageButton = new ImageButton("http://i.imgur.com/6zqQI1S.jpg");
        imageButton.setLayoutX(145);
        imageButton.setLayoutY(46);
        imageButton.setPrefHeight(110);
        imageButton.setPrefWidth(122);
        imageButton.setMaxSize(122, 110);
        imageButton.setMnemonicParsing(false);
        imageButton.setMaxHeight(110);
        imageButton.setMaxWidth(122);

        FileChooser fileChooser = new FileChooser();
        imageButton.setOnAction(e ->
        {

            configureFileChooser(fileChooser);
            File file = fileChooser.showOpenDialog(window);
            imageButton.setFileURL(file.getAbsolutePath());
            fileString = imageButton.getFileURL();
            System.out.println(fileString);
            if (file != null) {
                Image test = new Image("file://" + file.getAbsolutePath(), 122, 110, false, false);
                imageButton.changePicture(test);
            }
        });

        System.out.println(fileString);
        VBox vb = new VBox();
        vb.setLayoutY(40);
        vb.setLayoutX(145);
        vb.setPrefHeight(110);
        vb.setPrefWidth(122);
        vb.getChildren().add(imageButton);
        vb.setMaxHeight(110);
        vb.setMaxWidth(112);
        //vb.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(fname, lname, phone, email, create, fnameText, lnameText, phoneText, emailText, createButton, cancelButton, vb);

        scene = new Scene(pane);
        window.setScene(scene);
        window.show();
    }

    private static void configureFileChooser(final FileChooser fileChooser) {
        fileChooser.setTitle("View Pictures");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
    }
}
