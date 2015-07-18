package com.COP2805C.AddressBook.UserInterface;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import com.COP2805C.AddressBook.Functions;
import javafx.animation.FadeTransition;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

/*
 * Copyright (c) 2015
 * Abir Faisal
 * Chris Buruchian
 * Alex Truong-Mai
 * Will Herrin
 *
 * COP2805 Valencia College
 * Professor dsfasdfa
 */

/**
 * Created by EpiphX on 7/8/15.
 */
public class TransistionImageView extends ImageView {

    private final String STYLE_NORMAL = "-fx-background-color: transparent; -fx-padding: 4, 6, 6, 4";
    private final String STYLE_PRESSED = "-fx-background-color: transparent; -fx-padding: 6 4 4 6";

    private Image defaultImage;
    private ContactInformation contactInformation;

    public TransistionImageView(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;


        //If windows
        if (Functions.isWindows()) {
            if (contactInformation.getProfileImage() != null) {
                if (new File("src\\res\\profilePic" + contactInformation.getKey() + ".png").exists()) {
                    defaultImage = new Image("file:src/res/profilePic" + contactInformation.getKey() + ".png", 100.0, 100.0, true, true);
                } else {
                    defaultImage = new Image("file:src/res/defaultProfileImage.png", 100.0, 100.0, true, true);
                }
            } else defaultImage = new Image("file:src/res/defaultProfileImage.png", 100.0, 100.0, true, true);
        }

        //If not windows
        if (!Functions.isWindows()) {
            if (contactInformation.getProfileImage() != null) {
                if (new File("src/res/profilePic" + contactInformation.getKey() + ".png").exists()) {
                    defaultImage = new Image("file://" + Functions.workingDirectory() + "/src/res/profilePic" + contactInformation.getKey() + ".png", 100.0, 100.0, true, true);
                } else
                    defaultImage = new Image("file://" + Functions.workingDirectory() + "/src/res/defaultProfileImage.png", 100.0, 100.0, true, true);
            } else
                defaultImage = new Image("file://" + Functions.workingDirectory() + "/src/res/defaultProfileImage.png", 100.0, 100.0, true, true);
        }


        FileChooser fileChooser = fileChooser();
        setImage(defaultImage);
        clipProperty().set(new Circle(50, 50, 48));


        setOnMouseClicked(event -> {
            try {
                String filePath;
                if (Functions.isWindows()) {
                    //filePath = fileChooser.showOpenDialog(new Stage()).getAbsolutePath();
                    File tempFile = new File(fileChooser.showOpenDialog(new Stage()).getAbsolutePath());
                    filePath = tempFile.toURI().toURL().toString();
                } else {
                    filePath = "file://" + fileChooser.showOpenDialog(new Stage()).getAbsolutePath();
                }
                Image newImage = new Image(filePath, 100.0, 100.0, true, false);
                this.contactInformation.setProfileImage(newImage);
                setImage(newImage);

            } catch (Exception e) {
                System.out.println("No File selected");
                setImage(defaultImage);
            }
        });

        setOnMouseEntered(event -> {
            setCursor(Cursor.HAND); //Change cursor to hand
            FadeTransition ft = new FadeTransition(Duration.millis(225), this);
            ft.setFromValue(1.0);
            ft.setToValue(0.5);
            ft.setCycleCount(1);
            ft.setAutoReverse(false);
            ft.play();
        });

        setOnMouseExited(event -> {
            FadeTransition ft = new FadeTransition(Duration.millis(450), this);
            ft.setFromValue(0.5);
            ft.setToValue(1.0);
            ft.setCycleCount(1);
            ft.setAutoReverse(false);
            ft.play();
        });
        System.out.println("Testing if this prints");
    }


    public FileChooser fileChooser() {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("View Pictures");

        //TODO make sure this works in windows
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        return fileChooser;
    }
}

