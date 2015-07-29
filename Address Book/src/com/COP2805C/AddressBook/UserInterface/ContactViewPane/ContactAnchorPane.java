package com.COP2805C.AddressBook.UserInterface.ContactViewPane;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import com.COP2805C.AddressBook.Functions;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.time.LocalDate;
import java.util.ArrayList;

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
 * Created by abirfaisal on 6/13/15.
 */
public class ContactAnchorPane implements ContactView {

    private ContactInformation contactInformation;

    public ContactAnchorPane(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public static AnchorPane contactViewAnchorPane(Node... FXNode) {
        AnchorPane contactViewAnchorPane = new AnchorPane(FXNode);
        AnchorPane.setTopAnchor(contactViewAnchorPane, 0.0);
        AnchorPane.setTopAnchor(contactViewAnchorPane, 0.0);
        AnchorPane.setTopAnchor(contactViewAnchorPane, 0.0);
        AnchorPane.setTopAnchor(contactViewAnchorPane, 0.0);


        //Add some color
        if (Functions.isWindows()) contactViewAnchorPane.setStyle("-fx-background-color: #2b5797");
        else contactViewAnchorPane.setStyle("-fx-background-color: #e7e7e7");


        return contactViewAnchorPane;
    }

    public static FlowPane bannerFlowPane(Node... FXNode) {
        FlowPane bannerFlowPane = new FlowPane(FXNode);
        AnchorPane.setTopAnchor(bannerFlowPane, 20.0);
        AnchorPane.setLeftAnchor(bannerFlowPane, 20.0);
        AnchorPane.setRightAnchor(bannerFlowPane, 20.0);

        bannerFlowPane.setHgap(20.0);
        bannerFlowPane.setVgap(20.0);
        bannerFlowPane.setPrefWrapLength(0.0);

        bannerFlowPane.setOrientation(Orientation.HORIZONTAL);
        bannerFlowPane.setAlignment(Pos.CENTER);

        return bannerFlowPane;
    }

    public static ImageView contactImageView(ContactInformation contactInformation) {

        try {

            ImageView contactImageView = new ImageView(contactInformation.getProfileImage());

            Circle circle = new Circle(50,50,48);
            contactImageView.setClip(circle);

            contactImageView.fitHeightProperty().set(100.0);
            contactImageView.fitWidthProperty().set(100.0);

            return contactImageView;

        } catch (Exception e) {
            System.out.println("No Profile image");
        }

        return new ImageView();
    }

    //TODO use method in functions java
    public static Text nameText(ContactInformation contactInformation) {
        String name = Functions.getFormattedNameFMLN(contactInformation);

        Text nameText = new Text(name);

        //Style
        nameText.setFont(Font.font(24.0));
        if(Functions.isWindows()) {
            nameText.setFill(Paint.valueOf("white"));
        }

        return nameText;
    }

    public static TextFlow informationTextFlow(Text text) {

        TextFlow informationTextFlow = new TextFlow(text);

        AnchorPane.setTopAnchor(informationTextFlow, 160.0);
        AnchorPane.setBottomAnchor(informationTextFlow, 20.0);
        AnchorPane.setLeftAnchor(informationTextFlow, 20.0);
        AnchorPane.setRightAnchor(informationTextFlow, 20.0);


        return informationTextFlow;
    }

    public static Text informationText(String informationText) {

        Text text = new Text(informationText);

        if(Functions.isWindows()) {
            text.setFill(Paint.valueOf("white"));
        }
        return text;
    }

    public static String getInformationString(ContactInformation contactInformation) {

        String phoneNumbers = getFormattedPhoneNumbers(contactInformation.getPhoneNumbers());

        String emails = getFormattedEmails(contactInformation.getEmails());

        String workPlaces = getFormattedWorkPlaces(contactInformation.getWorkPlaces());

        String address = getFormattedAddress(contactInformation);

        String birthDate = getFormattedBirthdate(contactInformation.getBirthday());

        String notes = getFormattedNotes(contactInformation.getNotes());

        return new String(phoneNumbers + emails + workPlaces + address + birthDate + notes);
    }

    public static String getFormattedBirthdate(LocalDate date) {
        String birthDate;

        try {
            birthDate = "\nBirthdate: " +
                    date.getMonthValue() + " / " +
                    date.getDayOfMonth() + " / " +
                    date.getYear();

        } catch (NullPointerException e) {
            System.out.println("No Birthdate");
            return "";
        }

        return birthDate;
    }

    public static String getFormattedPhoneNumbers(ArrayList<String> phoneNumberArrayList) {

        if (phoneNumberArrayList.size() > 0) {
            String phoneNumbers = "\nPhone Numbers: \n";

            for (int i = 0; i < phoneNumberArrayList.size(); i++) {
                phoneNumbers = phoneNumbers + phoneNumberArrayList.get(i) + "\n";
            }
            return phoneNumbers;
        } else return "";
    }

    public static String getFormattedEmails(ArrayList<String> emailsArrayList) {


        if (emailsArrayList.size() > 0) {

            String emails = "\nEmails: \n";

            for (int i = 0; i < emailsArrayList.size(); i++) {
                emails = emails + emailsArrayList.get(i) + "\n";
            }
            return emails;

        } else return "";

    }

    public static String getFormattedNotes(String notes) {
        if (notes.length() > 0) {
            String notesLabel = "\n\nNotes: \n";

            notesLabel = notesLabel + notes;
            return notesLabel;
        }

        return "";
    }

    public static String getFormattedWorkPlaces(ArrayList<String> workPlacesArrayList) {

        if (workPlacesArrayList.size() > 0) {

            String workplaces = "\nWorkplaces: \n";

            for (int i = 0; i < workPlacesArrayList.size(); i++) {
                workplaces = workplaces + workPlacesArrayList.get(i) + "\n";
            }

            return workplaces;

        } else return "";
    }

    public static String getFormattedAddress(ContactInformation contactInformation) {

        String addressString = new String();

        if (contactInformation.getAddressLine1().length() > 0) {
            addressString = addressString + contactInformation.getAddressLine1() + "\n";
        }

        if (contactInformation.getAddressLine2().length() > 0) {
            addressString = addressString + contactInformation.getAddressLine2() + "\n";
        }

        if (contactInformation.getCity().length() > 0) {
            addressString = addressString + contactInformation.getCity() + ", ";
        }

        if (contactInformation.getState().length() > 0) {
            addressString = addressString + contactInformation.getState() + " ";
        }

        if (contactInformation.getZip().length() > 0) {
            addressString = addressString + contactInformation.getZip() + "\n";
        }

        if (contactInformation.getCountry().length() > 0) {
            addressString = addressString + contactInformation.getCountry() + " ";
        }

        if (addressString.length() > 0) {
            addressString = "\nAddress: \n" + addressString;
        }

        return addressString;
    }

    public AnchorPane contactView() {


        FlowPane bannerFlowPane = bannerFlowPane(
                contactImageView(contactInformation),
                nameText(contactInformation));

        TextFlow informationTextFlow =
                informationTextFlow(
                        informationText(
                                getInformationString(contactInformation)));


        return contactViewAnchorPane(bannerFlowPane, informationTextFlow);
    }
}