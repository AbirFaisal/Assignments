package com.COP2805C.AddressBook.UserInterface;

import com.COP2805C.AddressBook.Main;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

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
 * Created by abirfaisal on 7/2/15.
 */ //TODO Chris does this add the images to the list view?

//Custom ListCell for listView
public class AttachmentListCell extends ListCell<String> {
    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
            setText(null);
        } else {

            Image image = Main.getContactInformationArrayList().get(getIndex()).getProfileImage();

            ImageView imageView = new ImageView(image);

            //Add clipping mask
            imageView.setClip(new Circle(17, 17, 16));



            imageView.fitWidthProperty().set(34);
            imageView.fitHeightProperty().set(34);
            setGraphic(imageView);
            setText(item);
        }
    }
}
