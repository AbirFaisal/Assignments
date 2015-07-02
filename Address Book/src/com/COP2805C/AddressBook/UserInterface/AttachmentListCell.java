package com.COP2805C.AddressBook.UserInterface;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import com.COP2805C.AddressBook.Main;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

/**
 * Created by abirfaisal on 7/2/15.
 */ //TODO Abir, where should I put this? lol.
//Custom ListCell for listView
public class AttachmentListCell extends ListCell<String> {
    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
            setText(null);
        } else {
            Image fxImage = Main.getContactInformationArrayList().get(getIndex()).getProfileImage();
            ImageView imageView = new ImageView(fxImage);
            imageView.fitWidthProperty().set(50);
            imageView.fitHeightProperty().set(50);
            setGraphic(imageView);
            setText(item);
        }
    }
}
