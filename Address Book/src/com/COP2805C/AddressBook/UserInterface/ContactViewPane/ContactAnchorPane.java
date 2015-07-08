package com.COP2805C.AddressBook.UserInterface.ContactViewPane;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        bannerFlowPane.setPrefWrapLength(0.0);

        bannerFlowPane.setOrientation(Orientation.HORIZONTAL);
        bannerFlowPane.setAlignment(Pos.CENTER);

        return bannerFlowPane;
    }


    public static ImageView contactImageView(ContactInformation contactInformation) {

        try {

            ImageView contactImageView = new ImageView(contactInformation.getProfileImage());

            //add clipping mask to makle image a circle
            contactImageView.setClip(new Circle(50, 50, 48));

            contactImageView.fitHeightProperty().set(100.0);
            contactImageView.fitWidthProperty().set(100.0);

            return contactImageView;

        } catch (Exception e) {
            System.out.println("No Profile image");
            //TODO use default image
        }

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

        AnchorPane.setTopAnchor(informationTextFlow, 160.0);
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
        String emails = getFormattedEmails(contactInformation.getEmails());
        String workPlaces = getFormattedWorkPlaces(contactInformation.getWorkPlaces());
        String address = getFormattedAddress(contactInformation);
        String birthDate = getFormattedBirthdate(contactInformation.getBirthday());

        return new String(phoneNumbers + emails + workPlaces + address + birthDate);
    }

    public static String getFormattedBirthdate(LocalDate date){
        String birthDate;

        try {
            birthDate = "\nBirthdate: " +
                    date.getMonthValue() + " / " +
                    date.getDayOfMonth() + " / " +
                    date.getYear();

        }catch (NullPointerException e){
            System.out.println("No Birthdate");
            return "";
        }

        return birthDate;
    }



    public static String getFormattedPhoneNumbers(ArrayList<String> phoneNumberArrayList) {
        String phoneNumbers = "\nPhone Numbers: \n";

        for (int i = 0; i < phoneNumberArrayList.size(); i++) {
            phoneNumbers = phoneNumbers + phoneNumberArrayList.get(i) + "\n";
        }
        return phoneNumbers;
    }

    public static String getFormattedEmails(ArrayList<String> emailsArrayList) {
        String emails = "\nEmails: \n";

        for (int i = 0; i < emailsArrayList.size(); i++) {
            emails = emails + emailsArrayList.get(i) + "\n";
        }

        return emails;
    }

    public static String getFormattedWorkPlaces(ArrayList<String> workPlacesArrayList) {
        String workplaces = "\nWorkplaces: \n";

        for (int i = 0; i < workPlacesArrayList.size(); i++) {
            workplaces = workplaces + workPlacesArrayList.get(i) + "\n";
        }

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

        return addressString;
    }
}