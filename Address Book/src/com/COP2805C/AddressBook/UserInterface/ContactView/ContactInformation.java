package com.COP2805C.AddressBook.UserInterface.ContactView;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by abirfaisal on 6/13/15.
 */
public class ContactInformation {

    private int key;
    private String group;

    private Image profileImage;
    private ImageView profileImageView;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickname;

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;

    private String notes;

    private ArrayList<String> phoneNumbers;
    private ArrayList<String> emails;
    private ArrayList<String> workPlaces;

    private Calendar birthday;

}
