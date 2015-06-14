package com.COP2805C.AddressBook.UserInterface.ContactView;

import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by abirfaisal on 6/12/15.
 */
public class ContactViewFactory {


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


    public Image profileImage(/**TODO image from file?**/) {
        return null;
    }

    public ImageView profileImageView() {
        return null;
    }

    public Text nameText() {
        return null;
    }

    public FlowPane bannerFlowPane() {
        return null;
    }

    public TextFlow contactInformationTextFlow() {
        return null;
    }

    public ScrollPane scrollPane() {
        return null;
    }

    public AnchorPane anchorPane() {

        return null;
    }
}