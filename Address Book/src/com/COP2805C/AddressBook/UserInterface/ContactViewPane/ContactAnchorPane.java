package com.COP2805C.AddressBook.UserInterface.ContactViewPane;

import com.COP2805C.AddressBook.ContactInformation;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
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



        TextFlow informationTextFlow = informationTextFlow();



        return contactViewAnchorPane(bannerFlowPane, informationTextFlow);
    }


    public static AnchorPane contactViewAnchorPane(Node... FXNode){
        AnchorPane contactViewAnchorPane = new AnchorPane(FXNode);
        AnchorPane.setTopAnchor(contactViewAnchorPane, 0.0);
        AnchorPane.setTopAnchor(contactViewAnchorPane, 0.0);
        AnchorPane.setTopAnchor(contactViewAnchorPane, 0.0);
        AnchorPane.setTopAnchor(contactViewAnchorPane, 0.0);


        return contactViewAnchorPane;
    }


    public static FlowPane bannerFlowPane(Node... FXNode){
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

//    public static ScrollPane informationScrollPane(Node... FXNode){
//        AnchorPane anchorPane = new AnchorPane(FXNode);
//
//        ScrollPane informationScrollPane = new ScrollPane(anchorPane);
//
//        AnchorPane.setTopAnchor(informationScrollPane, 120.0);
//        AnchorPane.setBottomAnchor(informationScrollPane, 0.0);
//        AnchorPane.setLeftAnchor(informationScrollPane, 0.0);
//        AnchorPane.setRightAnchor(informationScrollPane, 0.0);
//
//        //informationScrollPane.getChildrenUnmodifiable().addAll(FXNode);
//
//        return informationScrollPane;
//    }



    public static ImageView contactImageView(ContactInformation contactInformation){


        try {
            ImageView contactImageView = new ImageView(contactInformation.getProfileImage());

            contactImageView.fitHeightProperty().set(100.0);
            contactImageView.fitWidthProperty().set(100.0);

            return contactImageView;

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
            name = name + " " + contactInformation.getMiddleName();
        }catch (Exception e){System.out.println("No Middle Name");}

        try {
                name = name + " " + contactInformation.getLastName();
        }catch (Exception e){System.out.println("No Last Name");}

        try {
                name = name + " (" + contactInformation.getNickname() + ")";
        }catch (Exception e){System.out.println("No Nickname");}

        System.out.println(name);

        Text nameText = new Text(name);
        nameText.setFont(Font.font(24.0));
        return nameText;
    }



    public static FlowPane informationFlowPane(){

        return new FlowPane();
    }

    public static TextFlow informationTextFlow(){

        TextFlow informationTextFlow = new TextFlow();

        AnchorPane.setTopAnchor(informationTextFlow, 140.0);
        AnchorPane.setBottomAnchor(informationTextFlow, 0.0);
        AnchorPane.setLeftAnchor(informationTextFlow, 0.0);
        AnchorPane.setRightAnchor(informationTextFlow, 0.0);

        return new TextFlow();
    }

    public static TextArea notesTextArea(){

        return new TextArea();
    }

    public static Text informationText(){
        return new Text();
    }


    public static String getInformationText(ContactInformation contactInformation){

        String informationText = "";



        return informationText;
    }


    public static String getInformationNotes(ContactInformation contactInformation){


        return new String();
    }


//    public static Image getImage(ContactInformation contactInformation){
//        if (contactInformation.getProfileImage() != null){
//            return contactInformation.getProfileImage();
//        }
//        //TODO return with default image
//        return null;
//    }
}