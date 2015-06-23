package com.COP2805C.AddressBook.UserInterface.ContactForms;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by abirfaisal on 6/23/15.
 */
public class AddContactForm implements Form {


    ContactInformation contactInformation;

    String[] labelStrings = {"First Name", "Middle Name", "Last Name", "Nickname", "addressLine1", "addressLine2", "city", "state", "zip"};
    ArrayList<Label> labels = new ArrayList<>();
    ArrayList<TextField> textFields = new ArrayList<>();


    public AddContactForm(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;

    }

    @Override
    public Stage contactForm() {

        //TODO Use the functions below to generate these
        for (int i = 0; i < labelStrings.length; i++) {
            labels.add(new Label(this.labelStrings[i]));
            textFields.add(new TextField());
        }




        return null;
    }

    public ScrollPane scrollPane(){

        //TODO stuff here

        return new ScrollPane();
    }


    public AnchorPane anchorPane(){

        //TODO stuff here

        return new AnchorPane();
    }


    public ImageView contactImage(ContactInformation contactInformation){

        //TODO stuff here
        return new ImageView(contactInformation.getProfileImage());
    }




    public FlowPane flowPane(){
        FlowPane flowPane = new FlowPane();
        //TODO format this
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setOrientation(Orientation.VERTICAL);

        return flowPane;
    }



    public GridPane gridPane(){
        GridPane gridPane = new GridPane();

        gridPane.addColumn(0, null);
        gridPane.addColumn(1, null);

        return gridPane;
    }



    public Label label(){
        //TODO format labels
        return null;
    }

    public TextField textField(){
        //TODO format fields
        return null;
    }





    //TODO bottons
    public MenuButton groupSelectButton(){

        return null;
    }

    public Button addButton(){

        return null;
    }

    public Button cancelButton(){

        return null;
    }



}
