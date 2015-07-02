package com.COP2805C.AddressBook.UserInterface.ContactViewPane;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;

/**
 * Created by abirfaisal on 6/13/15.
 */
public class ContactAnchorPane implements ContactView {

    private ContactInformation contactInformation;

    public ContactAnchorPane(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
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


    public static AnchorPane contactViewAnchorPane(Node... FXNode) {
        AnchorPane contactViewAnchorPane = new AnchorPane(FXNode);
        AnchorPane.setTopAnchor(contactViewAnchorPane, 0.0);
        AnchorPane.setTopAnchor(contactViewAnchorPane, 0.0);
        AnchorPane.setTopAnchor(contactViewAnchorPane, 0.0);
        AnchorPane.setTopAnchor(contactViewAnchorPane, 0.0);
        return contactViewAnchorPane;
    }


    public static FlowPane bannerFlowPane(Node... FXNode) {
        FlowPane bannerFlowPane = new FlowPane(FXNode);
        AnchorPane.setTopAnchor(bannerFlowPane, 20.0);
        AnchorPane.setLeftAnchor(bannerFlowPane, 20.0);
        AnchorPane.setRightAnchor(bannerFlowPane, 20.0);

        bannerFlowPane.setHgap(20.0);
        bannerFlowPane.setVgap(20.0);

        bannerFlowPane.setOrientation(Orientation.HORIZONTAL);
        bannerFlowPane.setAlignment(Pos.CENTER);
        //bannerFlowPane.setColumnHalignment(HPos.CENTER);
        //bannerFlowPane.setRowValignment(VPos.CENTER);

        return bannerFlowPane;
    }


    public static ImageView contactImageView(ContactInformation contactInformation) {


        try {
            Circle clip = new Circle(50,50,47);
            ImageView contactImageView = new ImageView(contactInformation.getProfileImage());
            System.out.println("LayoutBounds are: x:" + contactImageView.getLayoutX()+ ",y:"+ contactImageView.getLayoutY());
            contactImageView.setClip(clip);
            contactImageView.fitHeightProperty().set(100.0);
            contactImageView.fitWidthProperty().set(100.0);
            contactImageView.setLayoutX(50);
            contactImageView.setLayoutY(50);

            return contactImageView;

        } catch (Exception e) {
            System.out.println("No Profile image");
        }
        //TODO return with default image
        return new ImageView();
    }


    public static Text nameText(ContactInformation contactInformation) {
        String name = "";

        try {
            name = name + contactInformation.getFirstName();
        } catch (Exception e) {
            System.out.println("No First Name");
        }

        try {
            name = name + " " + contactInformation.getMiddleName();
        } catch (Exception e) {
            System.out.println("No Middle Name");
        }

        try {
            name = name + " " + contactInformation.getLastName();
        } catch (Exception e) {
            System.out.println("No Last Name");
        }

        try {
            name = name + " (" + contactInformation.getNickname() + ")";
        } catch (Exception e) {
            System.out.println("No Nickname");
        }


        Text nameText = new Text(name);
        nameText.setFont(Font.font(24.0));
        return nameText;
    }


    public static TextFlow informationTextFlow(Text text) {

        TextFlow informationTextFlow = new TextFlow(text);

        AnchorPane.setTopAnchor(informationTextFlow, 140.0);
        AnchorPane.setBottomAnchor(informationTextFlow, 20.0);
        AnchorPane.setLeftAnchor(informationTextFlow, 20.0);
        AnchorPane.setRightAnchor(informationTextFlow, 20.0);

        return informationTextFlow;
    }


    public static Text informationText(String informationText) {

        /** Do any text formatting here if needed **/

        return new Text(informationText);
    }

    public static String getInformationString(ContactInformation contactInformation) {

        String phoneNumbers = getFormattedPhoneNumbers(contactInformation.getPhoneNumbers());
        String emails = getFormattedEmails(contactInformation.getPhoneNumbers());
        String workPlaces = getFormattedWorkPlaces(contactInformation.getWorkPlaces());
        String address = getFormattedAddress(contactInformation);

        return new String(phoneNumbers + emails + workPlaces + address);
    }


    public static String getFormattedPhoneNumbers(ArrayList<String> phoneNumberArrayList) {
        String phoneNumbers = "\nPhone Numbers: \n";

        for (int i = 0; i < phoneNumberArrayList.size(); i++) {
            phoneNumbers = phoneNumbers + phoneNumberArrayList.get(i) + "\n";
        }
        //TODO REMOVE
        System.out.println(phoneNumbers);
        return phoneNumbers;
    }

    public static String getFormattedEmails(ArrayList<String> emailsArrayList) {
        String emails = "\nEmails: \n";

        for (int i = 0; i < emailsArrayList.size(); i++) {
            emails = emails + emailsArrayList.get(i) + "\n";
        }

        //TODO REMOVE
        System.out.println(emails);
        return emails;
    }

    public static String getFormattedWorkPlaces(ArrayList<String> workPlacesArrayList) {
        String workplaces = "\nWorkplaces: \n";

        for (int i = 0; i < workPlacesArrayList.size(); i++) {
            workplaces = workplaces + workPlacesArrayList.get(i) + "\n";
        }

        //TODO REMOVE
        System.out.println(workplaces);
        return workplaces;
    }

    public static String getFormattedAddress(ContactInformation contactInformation) {
        String addressString = "\nAddress: \n";

        addressString = addressString + contactInformation.getAddressLine1() + "\n";
        addressString = addressString + contactInformation.getAddressLine2() + "\n";

        addressString = addressString + contactInformation.getCity() + ", ";
        addressString = addressString + contactInformation.getState() + " ";
        addressString = addressString + contactInformation.getZip() + " ";
        addressString = addressString + contactInformation.getCountry() + " ";



        //TODO remove test
        System.out.println(addressString);

        return addressString;
    }
}