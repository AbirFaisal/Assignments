package com.COP2805C.AddressBook.UserInterface;

import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * Created by abirfaisal on 6/12/15.
 */
public interface ContactViewFactory {

    Image profileImage();
    ImageView profileImageView();
    Text nameText();
    FlowPane bannerFlowPane();
    TextFlow contactInformationTextFlow();
    ScrollPane scrollPane();
    AnchorPane anchorPane();
    

}
