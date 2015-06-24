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

    String[] labelStrings = {
            "First Name", "Middle Name", "Last Name", "Nickname",
            "Address Line 1", "Address Line 2", "City", "State", "Zip"};

    ArrayList<Label> labels = new ArrayList<>();
    ArrayList<TextField> textFields = new ArrayList<>();

    ArrayList<TextField> phoneLabelTextFields = new ArrayList<>();
    ArrayList<TextField> phoneTextFields = new ArrayList<>();

    ArrayList<TextField> emailLabelTextField = new ArrayList<>();
    ArrayList<TextField> emailFields = new ArrayList<>();

    ArrayList<TextField> workplaceLabelTextField = new ArrayList<>();
    ArrayList<TextField> workplaceTextFields = new ArrayList<>();


    public AddContactForm(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    @Override
    public Stage contactForm() {

        //TODO Use the functions below to generate these
        for (int i = 0; i < labelStrings.length; i++) {
            labels.add(label(this.labelStrings[i]));
            textFields.add(new TextField());
        }


        //TODO for each phone number add a label
        for (int i = 0; i < this.contactInformation.getPhoneNumbers().size() - 1; i++) {

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



    public Label label(String labelString){
        Label label = new Label(labelString);
        //Format label if needed
        return label;
    }

    public TextField textField(){
        TextField textField = new TextField();
        //Format label if needed
        return textField;
    }





    public DatePicker birthDatePicker(){
        DatePicker datePicker = new DatePicker();
        //TODO stuff here if needed
        return datePicker;
    }



    //TODO Anchor buttons into correct position
    public MenuButton groupSelectButton(){
        MenuButton menuButton = new MenuButton();

        return menuButton;
    }

    public Button addButton(){
        Button button = new Button();

        return button;
    }

    public Button cancelButton(){
        Button button = new Button();

        return button;
    }



}
