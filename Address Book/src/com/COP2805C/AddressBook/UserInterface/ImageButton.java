package com.COP2805C.AddressBook.UserInterface;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ImageButton extends Button {

    private final String STYLE_NORMAL = "-fx-background-color: transparent; -fx-padding: 5, 5, 5, 5;";
    private final String STYLE_PRESSED = "-fx-background-color: transparent; -fx-padding: 6 4 4 6;";
    private static String fileURL;

    public ImageButton(String imageurl) {
        ImageView test = new ImageView(new Image(imageurl,122,110,false,false));
        test.setPreserveRatio(false);
        setGraphic(test);
        setStyle(STYLE_NORMAL);

        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setStyle(STYLE_PRESSED);
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setStyle(STYLE_NORMAL);
            }
        });

        setOnMouseEntered(event -> {
            setCursor(Cursor.HAND); //Change cursor to hand
        });
    }
    public void changePicture(Image image){
        setGraphic(new ImageView(image));
    }


    public static String getFileURL() {
        return fileURL;
    }

    public static void setFileURL(String fileURL) {
        ImageButton.fileURL = fileURL;
    }
}