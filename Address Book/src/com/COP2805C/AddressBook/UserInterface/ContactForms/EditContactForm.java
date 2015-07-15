package com.COP2805C.AddressBook.UserInterface.ContactForms;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import com.COP2805C.AddressBook.Functions;
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

        addDynamicData(phoneGridPane, this.phoneTextFields, contactInformation.getPhoneNumbers());
        addDynamicData(emailGridPane, this.emailTextFields, contactInformation.getEmails());
        addDynamicData(workplaceGridPane, this.workplaceTextFields, contactInformation.getWorkPlaces());
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

    private void addDynamicData(GridPane gridPane, ArrayList<TextField> textFields, ArrayList<String> contactData){

        for(int i = 0; i < contactData.size(); i++) {
            TextField textField = new TextField();
            textField.setText(contactData.get(i));
            textFields.add(textField);

            gridPane.addRow(textFields.size(), textFields.get(textFields.size() - 1));
            gridPane.add(
                    removeButton(gridPane, textFields, textFields.get(textFields.size()-1)),
                    1,
                    textFields.size());
        }
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

    @Override
    public Button saveButton(){
        Button button = new Button("Save");

        AnchorPane.setBottomAnchor(button, 5.0);
        AnchorPane.setLeftAnchor(button, 50.0);


        button.setOnMouseClicked(e ->{
            //Image already set by image button
            //Group already set by group selection button

            //save static data
            //First Name

            Main.getDatabase().deleteCONTACTID(this.contactInformation.getKey());
            Functions.deletePictureFile(this.contactInformation.getKey());

            this.contactInformation.setFirstName(
                    this.textFields.get(0).getText());
            //Middle Name
            this.contactInformation.setMiddleName(
                    this.textFields.get(1).getText());
            //Last Name
            this.contactInformation.setLastName(
                    this.textFields.get(2).getText());

            this.contactInformation.setNickname(
                    this.textFields.get(3).getText());

            //Address
            this.contactInformation.setAddressLine1(
                    this.textFields.get(4).getText());

            this.contactInformation.setAddressLine2(
                    this.textFields.get(5).getText());

            this.contactInformation.setCity(
                    this.textFields.get(6).getText());

            this.contactInformation.setState(
                    this.textFields.get(7).getText());

            this.contactInformation.setZip(
                    this.textFields.get(8).getText());

            this.contactInformation.setCountry(
                    this.textFields.get(9).getText());

            //Notes
            this.contactInformation.setNotes(
                    this.notesTextArea.getText());

            //Birth Date is set from input by the user.
            try {
                this.contactInformation.setBirthday(birthDatePicker.getValue().toString());
            }catch(NullPointerException ex){//TODO setup a better NullValue for datePicker
                System.out.println("No dob entered: " + ex);
                //this.contactInformation.setBirthday("2015-10-14");
            }
            //save dynamic data
            //Phone Numbers
            //System.out.println("phonetxtfields size" + this.phoneTextFields.size());
            //.out.println("phonetxt fields text " + this.phoneTextFields.get(0).getText());


            //Clear existing fields
            this.contactInformation.getPhoneNumbers().clear();
            this.contactInformation.getEmails().clear();
            this.contactInformation.getWorkPlaces().clear();


            for (int i = 0; i < this.phoneTextFields.size(); i++) {
                //Make sure field is not empty
                if (this.phoneTextFields.get(i).getLength() > 0) {
                    //Add to arrayList
                    this.contactInformation.getPhoneNumbers().add(
                            this.phoneTextFields.get(i).getText());
                }
            }

            //Emails
            for (int i = 0; i < this.emailTextFields.size(); i++) {

                //Make sure field is not empty
                if (this.emailTextFields.get(i).getLength() > 0) {
                    //Add to arrayList
                    this.contactInformation.getEmails().add(
                            this.emailTextFields.get(i).getText());
                }
            }

            //Workplaces
            for (int i = 0; i < this.workplaceTextFields.size(); i++) {
                //Make sure field is not empty
                if (this.workplaceTextFields.get(i).getLength() > 0) {
                    //Add to arrayList
                    this.contactInformation.getWorkPlaces().add(
                            this.workplaceTextFields.get(i).getText());
                }
            }

            //add to database
            //Add key to contactInformation Object
            this.contactInformation.setKey(Main.getDatabase().createContact(Main.getCredentials(), this.contactInformation));

            //TODO this below statement is so that when they click save it immediately closes the addContactWindow. It prevents duplicates.
            addContactStage.close();
            Functions.refreshContactArray();
            Functions.refreshListView();
        });

        return button;
    }


    private void setDOB(){
        try {
            this.birthDatePicker.setValue(contactInformation.getBirthday());
        }catch(NullPointerException ex){
            System.out.println("No dob entered: " + ex);
        }
    }
}
