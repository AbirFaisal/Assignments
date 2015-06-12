package com.COP2805C.AddressBook.UserInterface;

import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by abirfaisal on 6/12/15.
 */
public class ContactView implements ContactViewFactory {

    String group;

    ImageView imageView;
    String first;
    String middle;
    String last;
    String nickname;

    String addressLine1;
    String addressLine2;
    String city;
    String state;
    String zip;

    String notes;

    ArrayList<String> phoneNumbers;
    ArrayList<String> emails;
    ArrayList<String> workPlaces;

    Calendar birthday;




    @Override
    public AnchorPane bannerAnchorPane() {
        return null;
    }

    @Override
    public ScrollPane scrollPane() {
        return null;
    }

    @Override
    public AnchorPane anchorPane() {
        return null;
    }
}
