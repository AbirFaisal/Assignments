package com.COP2805C.AddressBook.UserInterface.ContactForms;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import com.COP2805C.AddressBook.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by abirfaisal on 6/23/15.
 */

//TODO have this extend ContactForm instead of AddContactForm. And have AddContactForm extend ContactForm as well.
    //This is how I am thinking we should approach this.
public class EditContactForm extends AddContactForm implements Form {


    public EditContactForm(ContactInformation contactInformation, Stage formStage) {
        super(contactInformation,formStage);


    }
    @Override
    public Scene form() {

        //add static data labels and fields
        for (int i = 0; i < labelStrings.length; i++) {
            this.labels.add(label(this.labelStrings[i]));
            this.textFields.add(textField(this.labelStrings[i]));
        }
        ArrayList<Label> phoneLabel = new ArrayList<Label>();
        phoneLabel.add(new Label("Phone Numbers"));

        ArrayList<Label> emailLabel = new ArrayList<Label>();
        emailLabel.add(new Label("Email"));

        ArrayList<Label> workplaceLabel = new ArrayList<Label>();
        workplaceLabel.add(new Label("Workplaces"));

        GridPane staticDataGridPane = gridPane(this.labels, this.textFields);
        GridPane phoneGridPane = gridPane(phoneLabel, this.phoneTextFields);
        GridPane emailGridPane = gridPane(emailLabel, this.emailTextFields);
        GridPane workplaceGridPane = gridPane(workplaceLabel, this.workplaceTextFields);


        FlowPane buttonsFlowPane = new FlowPane(
                groupChoiceBox(Main.getGroupObservableList()),
                saveButton(),
                cancelButton());

        AnchorPane.setBottomAnchor(buttonsFlowPane, 8.0);
        AnchorPane.setRightAnchor(buttonsFlowPane, 8.0);
        buttonsFlowPane.setHgap(8.0);
        buttonsFlowPane.setAlignment(Pos.BOTTOM_RIGHT);


        //flow pane
        this.flowpane = flowPane(
                //buttonsFlowPane,
                new AnchorPane(circleOverlay(),editText(), contactImageView()),
                staticDataGridPane,
                this.birthDatePicker,
                this.notesTextArea,
                phoneGridPane,
                addButton("Add Phone Number", "Phone Number", phoneGridPane, this.phoneTextFields),
                emailGridPane,
                addButton("Add Email", "Email" , emailGridPane, this.emailTextFields),
                workplaceGridPane,
                addButton("Add Workplace", "Workplace", workplaceGridPane, this.workplaceTextFields));


        AnchorPane anchorPane = anchorPane(this.flowpane, buttonsFlowPane);

        setContactFields();
        return new Scene(anchorPane, 800, 625);
    }

    public GridPane gridPane(ArrayList<Label> labels, ArrayList<TextField> textFields){
        GridPane gridPane = new GridPane();

        //TODO change gaps
        gridPane.setHgap(5.0);
        gridPane.setVgap(8.0);

        //Add labels in column 0 row i
        for (int i = 0; i < labels.size(); i++) {
            gridPane.add(labels.get(i), 0, i);
        }

        //Add texfields in column 1 row i
        for (int i = 0; i < textFields.size(); i++) {
            gridPane.add(textFields.get(i), 1, i);
        }

        return gridPane;
    }

    private void setContactFields(){
       setTextFields();
       setNoteTextArea();
       setProfilePicture();
       setDOB();

    }

    private void setTextFields(){
        this.textFields.get(0).setText(contactInformation.getFirstName());
        this.textFields.get(1).setText(contactInformation.getMiddleName());
        this.textFields.get(2).setText(contactInformation.getLastName());
        this.textFields.get(3).setText(contactInformation.getNickname());
        this.textFields.get(4).setText(contactInformation.getAddressLine1());
        this.textFields.get(5).setText(contactInformation.getAddressLine2());
        this.textFields.get(6).setText(contactInformation.getCity());
        this.textFields.get(7).setText(contactInformation.getState());
        this.textFields.get(8).setText(contactInformation.getZip());
        this.textFields.get(9).setText(contactInformation.getCountry());
    }

    private void setNoteTextArea(){
        this.notesTextArea.setText(contactInformation.getNotes());
    }

    private void setProfilePicture(){

    }

    private void setDOB(){
        try {
            this.birthDatePicker.setValue(contactInformation.getBirthday());
        }catch(NullPointerException ex){
            System.out.println("No dob entered: " + ex);
        }
    }
}
