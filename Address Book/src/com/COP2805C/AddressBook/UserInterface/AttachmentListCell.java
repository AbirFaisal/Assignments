package com.COP2805C.AddressBook.UserInterface;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import com.COP2805C.AddressBook.Main;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

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

            Image fxImage = Main.getContactInformationArrayList().get(getIndex()).getProfileImage();
            ImageView imageView = new ImageView(fxImage);

            //Add clipping mask
            imageView.setClip(new Circle(17, 17, 16));

            //TODO REMOVE TEST
            System.out.println("LayoutBounds are: x:" + imageView.getLayoutX()+ ",y:"+ imageView.getLayoutY());

            imageView.fitWidthProperty().set(34);
            imageView.fitHeightProperty().set(34);
            setGraphic(imageView);
            setText(item);
        }
    }
}
