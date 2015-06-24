package com.COP2805C.AddressBook.UserInterface.ContactForms;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;


public class AddContactForm implements Form {


    ContactInformation contactInformation;

    String[] labelStrings = {
            "First Name", "Middle Name", "Last Name", "Nickname",
            "Address Line 1", "Address Line 2", "City", "State", "Zip"};

    ArrayList<Label> labels = new ArrayList<>();
    ArrayList<TextField> textFields = new ArrayList<>();

    ArrayList<TextField> phoneTextFields = new ArrayList<>();
    ArrayList<TextField> emailTextFields = new ArrayList<>();
    ArrayList<TextField> workplaceTextFields = new ArrayList<>();

    TextArea notesTextArea = new TextArea("Notes");


    public AddContactForm(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    @Override
    public Scene contactForm() {

        //TODO Use the functions below to generate these
        for (int i = 0; i < labelStrings.length; i++) {
            this.labels.add(label(this.labelStrings[i]));
            this.textFields.add(new TextField());
        }


        GridPane staticDataGridPane = gridPane(this.labels, this.textFields);

        GridPane phoneGridPane = gridPane(new ArrayList<Label>(), this.phoneTextFields);

        GridPane emailGridPane = gridPane(new ArrayList<Label>(), this.emailTextFields);

        GridPane workplaceGridPane = gridPane(new ArrayList<Label>(), this.workplaceTextFields);





        //flow pane

        //anchor pane

        //scroll pane

        //put scroll pane in anchor pane

        AnchorPane anchorPane = anchorPane();

        return new Scene(anchorPane, 400.0, 600.0);
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




    public FlowPane flowPane(Node... FXNode){
        FlowPane flowPane = new FlowPane();
        //TODO format this
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setOrientation(Orientation.VERTICAL);

        return flowPane;
    }



    public GridPane gridPane(ArrayList<Label> labels, ArrayList<TextField> textFields){
        GridPane gridPane = new GridPane();

        //TODO add some formatting to make it look nice

        //Add labels in column 0 row i
        for (int i = 0; i < labels.size() - 1; i++) {
            gridPane.add(labels.get(i), 0, i);
        }

        //Add texfields in column 1 row i
        for (int i = 0; i < textFields.size() - 1; i++) {
            gridPane.add(textFields.get(i), 1, i);
        }

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
