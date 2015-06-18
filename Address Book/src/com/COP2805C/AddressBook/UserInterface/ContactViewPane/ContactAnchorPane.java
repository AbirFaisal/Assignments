package com.COP2805C.AddressBook.UserInterface.ContactViewPane;

import com.COP2805C.AddressBook.ContactInformation;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

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


        return contactViewAnchorPane(bannerFlowPane);
    }


    public static AnchorPane contactViewAnchorPane(Node... FXNode){

        return new AnchorPane(FXNode);
    }


    public static FlowPane bannerFlowPane(Node... FXNode){



        return new FlowPane(FXNode);
    }

    public static ScrollPane informationScrollPane(){

        return new ScrollPane();
    }



    public static ImageView contactImageView(ContactInformation contactInformation){


        try {

                return new ImageView(contactInformation.getProfileImage());

        }catch (Exception e){
            System.out.println("No Profile image");
        }
        //TODO return with default image
        return new ImageView();
    }

    public static Text nameText(ContactInformation contactInformation){
        String name = "";

        try {
                name = name + contactInformation.getFirstName();
        }catch (Exception e){System.out.println("No First Name");}

        try {
            name = name + contactInformation.getMiddleName();
        }catch (Exception e){System.out.println("No Middle Name");}

        try {
                name = name + contactInformation.getLastName();
        }catch (Exception e){System.out.println("No Last Name");}

        try {
                name = name + contactInformation.getNickname();
        }catch (Exception e){System.out.println("No Nickname");}


        return new Text(name);
    }



    public static FlowPane informationFlowPane(){

        return new FlowPane();
    }

    public static TextFlow informationTextFlow(){

        return new TextFlow();
    }

    public static TextArea notesTextArea(){

        return new TextArea();
    }

    public static Text informationText(){
        return new Text();
    }


    public static String getInformationText(ContactInformation contactInformation){


        return new String();
    }


    public static String getInformationNotes(ContactInformation contactInformation){


        return new String();
    }


    public static Image getImage(ContactInformation contactInformation){
        if (contactInformation.getProfileImage() != null){
            return contactInformation.getProfileImage();
        }
        //TODO return with default image
        return null;
    }


    public static String getContactFMLN(ContactInformation contactInformation){



        return new String();
    }
}