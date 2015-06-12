package com.COP2805C.AddressBook.UserInterface;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * Created by abirfaisal on 6/12/15.
 */
public interface ContactViewFactory {

    ImageView profileImageView();
    AnchorPane anchorPane();

}
