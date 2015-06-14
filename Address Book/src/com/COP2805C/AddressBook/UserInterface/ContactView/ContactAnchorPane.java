package com.COP2805C.AddressBook.UserInterface.ContactView;

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


    public ContactAnchorPane(ContactInformation contactInformation) {
    }

    @Override
    public AnchorPane contactView() {
        return new AnchorPane();
    }

    //TODO fx elements here

    public static AnchorPane contactViewAnchorPane(Node... FXNode){

        return new AnchorPane(FXNode);
    }


    public static FlowPane bannerFlowPane(){

        return new FlowPane();
    }

    public static ScrollPane informationScrollPane(){

        return new ScrollPane();
    }



    public static ImageView contactImageView(Image contactImage){

        return new ImageView();
    }

    public static Text nameText(){

        return new Text();
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


        return new Image();
    }


    public static String getContactName(ContactInformation contactInformation){


        return new String();
    }
}