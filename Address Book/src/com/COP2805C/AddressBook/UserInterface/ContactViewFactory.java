package com.COP2805C.AddressBook.UserInterface;

import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * Created by abirfaisal on 6/12/15.
 */
public interface ContactViewFactory {
    AnchorPane bannerAnchorPane();
    ScrollPane scrollPane();
    AnchorPane anchorPane();
}
