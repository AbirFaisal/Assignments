package com.COP2805C.AddressBook.UserInterface.ContactForms;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import com.COP2805C.AddressBook.Functions;
import com.COP2805C.AddressBook.Main;
import com.COP2805C.AddressBook.UserInterface.TransitionImageView;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;


/*
 * Copyright (c) 2015
 * Alex Truong-Mai
 * Will Herrin
 * Chris Buruchian
 * Abir Faisal
 *
 * COP2805C Valencia College
 * Professor Jeho Park
 */

public class AddContactForm implements Form {

    Stage addContactStage;
    ContactInformation contactInformation;
    String[] labelStrings;
    String[] dynamicLabelStrings;

    //Static Data
    ArrayList<Label> labels;
    ArrayList<TextField> textFields;
    Image contactImage; //is this used?

    //Dynamic Data
    ArrayList<TextField> phoneTextFields;
    ArrayList<TextField> emailTextFields;
    ArrayList<TextField> workplaceTextFields;
    GridPane staticDataGridPane;
    GridPane phoneGridPane;
    GridPane emailGridPane;
    GridPane workplacesGridPane;


    FlowPane flowpane;
    TextArea notesTextArea;
    DatePicker birthDatePicker;
    AnchorPane anchorPane;
    Scene scene;
    Boolean errors;

    public AddContactForm(ContactInformation contactInformation, Stage stage) {
        this.contactInformation = contactInformation;
        this.labelStrings = new String[]{
                "First Name", "Middle Name", "Last Name", "Nickname",
                "Address Line 1", "Address Line 2", "City", "State", "Zip", "Country"};
        this.dynamicLabelStrings = new String[]{
                "Phone Numbers:",
                "Emails",
                "Workplaces"
        };

        this.labels = new ArrayList<>();
        this.textFields = new ArrayList<>();
        this.phoneTextFields = new ArrayList<>();
        this.emailTextFields = new ArrayList<>();
        this.workplaceTextFields = new ArrayList<>();
        this.birthDatePicker = birthDatePicker();
        this.notesTextArea = notesTextArea();

        this.addContactStage = stage;
        this.addContactStage.setTitle("Add Contact Form");
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



        this.staticDataGridPane = gridPane(this.labels, this.textFields);
        this.phoneGridPane = gridPane(phoneLabel, this.phoneTextFields);
        this.emailGridPane = gridPane(emailLabel, this.emailTextFields);
        this.workplacesGridPane = gridPane(workplaceLabel, this.workplaceTextFields);


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
                new AnchorPane(circleOverlay(), editText(), contactImageView()),
                staticDataGridPane,
                this.birthDatePicker,
                this.notesTextArea,
                this.phoneGridPane,
                addButton("Add Phone Number", "Phone Number", this.phoneGridPane, this.phoneTextFields),
                this.emailGridPane,
                addButton("Add Email", "Email", this.emailGridPane, this.emailTextFields),
                this.workplacesGridPane,
                addButton("Add Workplace", "Workplace", this.workplacesGridPane, this.workplaceTextFields));

        this.anchorPane = anchorPane(this.flowpane, buttonsFlowPane);

        if (Functions.isWindows()) this.anchorPane.setStyle("-fx-background-color: #2b5797");
        //else this.anchorPane.setStyle("-fx-background-color: #e7e7e7");


        this.scene = new Scene(this.anchorPane, 800.0, 625.0);

        if (Functions.isWindows()) this.scene.getStylesheets().add("winStyle.css");
        else this.scene.getStylesheets().add("nixStyle.css");

        return this.scene; //new Scene(anchorPane, 800, 625);
    }


    public AnchorPane anchorPane(Node... FXNode) {

        AnchorPane anchorPane = new AnchorPane();
        Functions.zeroAnchor(anchorPane);
        anchorPane.getChildren().addAll(FXNode);

        return anchorPane;
    }


    public Circle circleOverlay() {
        Circle greyCircle = new Circle(50, 50, 50);
        greyCircle.setFill(Paint.valueOf("GRAY"));
        return greyCircle;
    }

    public Text editText() {
        Text editText = new Text(30, 80, "edit");
        editText.setFill(Paint.valueOf("WHITE"));
        editText.setFont(Font.font(25));


        return editText;
    }

    public ImageView contactImageView() {
        return new TransitionImageView(this.contactInformation);
    }

    public FlowPane flowPane(Node... FXNode) {
        FlowPane flowPane = new FlowPane();

        flowPane.getChildren().addAll(FXNode);

        flowPane.setAlignment(Pos.TOP_LEFT);
        flowPane.setOrientation(Orientation.VERTICAL);
        flowPane.setPrefWrapLength(400);
        flowPane.setVgap(8.0);
        flowPane.setHgap(8.0);

        AnchorPane.setTopAnchor(flowPane, 20.0);
        AnchorPane.setBottomAnchor(flowPane, 20.0);
        AnchorPane.setLeftAnchor(flowPane, 20.0);
        AnchorPane.setRightAnchor(flowPane, 20.0);

        return flowPane;
    }


    public GridPane gridPane(ArrayList<Label> labels, ArrayList<TextField> textFields) {
        GridPane gridPane = new GridPane();

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


    public Label label(String labelString) {
        Label label = new Label(labelString);
        //Format label if needed
        return label;
    }

    public TextField textField(String promptText) {
        TextField textField = new TextField();
        textField.setPromptText(promptText);
        return textField;
    }


    public TextArea notesTextArea() {
        TextArea textArea = new TextArea();

        textArea.setMaxSize(250.0, 100.0);

        textArea.setPromptText("Notes");

        return textArea;
    }


    public DatePicker birthDatePicker() {
        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Birthday");

        return datePicker;
    }


    public ChoiceBox<String> groupChoiceBox(ObservableList<String> observableList) {
        ChoiceBox<String> groupChoiceBox = new ChoiceBox<>(observableList);
        groupChoiceBox.getSelectionModel().selectFirst();


        AnchorPane.setLeftAnchor(groupChoiceBox, 5.0);
        AnchorPane.setBottomAnchor(groupChoiceBox, 5.0);

        groupChoiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            this.contactInformation.setGroup(newValue);
            System.out.println(this.contactInformation.getGroup());
            System.out.println();
        });

        return groupChoiceBox;
    }

    public Button addButton(String buttonText, String promptText, GridPane gridPane, ArrayList<TextField> textFields) {
        Button button = new Button(buttonText);


        button.setOnMouseClicked(e -> {
            TextField textField = new TextField(); //new textfield

            textField.setPromptText(promptText);
            textFields.add(textField);

            gridPane.addRow(textFields.size(), textFields.get(textFields.size() - 1));

            gridPane.add(
                    removeButton(gridPane, textFields, textFields.get(textFields.size() - 1)),
                    1,
                    textFields.size());
        });

        return button;
    }

    public Button removeButton(GridPane gridPane, ArrayList<TextField> textFields, TextField textField) {
        Button button = new Button("-");

        button.setOnAction(e -> {

            gridPane.getChildren().remove(
                    gridPane.getChildren().indexOf(textField));

            gridPane.getChildren().remove(
                    gridPane.getChildren().indexOf(button));

            textFields.remove(textFields.indexOf(textField));
        });

        return button;
    }


    public Button saveButton() {
        Button button = new Button("Save");
        this.errors = false;


        AnchorPane.setBottomAnchor(button, 5.0);
        AnchorPane.setLeftAnchor(button, 50.0);

        //this.contactInformation.getKey();

        //If contact already exists then delete it
        Main.getDatabase().deleteCONTACTID(this.contactInformation.getKey());
        Functions.deletePictureFile(this.contactInformation.getKey());


        button.setOnMouseClicked(e -> {
            //Image already set by image button
            //Group already set by group selection button

            //Save Static Data
            saveStaticData();

            //Save Dynamic Data
            saveDynamicData();

            //Save data and close window if there are no errors
            if (this.errors = false) {
                //add to database
                //Add key to contactInformation Object
                this.contactInformation.setKey(Main.getDatabase().createContact(Main.getCredentials(), this.contactInformation));

                //This below statement is so that when they click save it immediately closes the addContactWindow.
                // It prevents duplicates.
                addContactStage.close();
                Functions.refreshContactArray();
                Collections.sort(Main.getContactInformationArrayList(), new Functions.FirstNameComparator());
                Functions.refreshListView();
            }
        });
        return button;
    }


    public void saveStaticData() {

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

        if (checkZip()) {
            this.contactInformation.setZip(
                    this.textFields.get(8).getText());
        }else {
            this.contactInformation.setZip("");
        }

        this.contactInformation.setCountry(
                this.textFields.get(9).getText());

        //Notes
        this.contactInformation.setNotes(
                this.notesTextArea.getText());

        //Birth Date is set from input by the user.
        try {
            this.contactInformation.setBirthday(birthDatePicker.getValue().toString());
        } catch (NullPointerException ex) {
            System.out.println("No dob entered: " + ex);
        }
    }


    public void saveDynamicData() {

        //Save dynamic data

        //Clear existing fields in object
        this.contactInformation.getPhoneNumbers().clear();
        this.contactInformation.getEmails().clear();
        this.contactInformation.getWorkPlaces().clear();

        //Phone Numbers
        //TODO error checking
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
    }


    public Button cancelButton() {
        Button button = new Button("Cancel");

        button.setOnMouseClicked(e -> {
            addContactStage.close();
        });

        return button;
    }

    public boolean checkZip(){
        String string = this.textFields.get(8).getText();

        if (string.length() > 5){
            this.errors = true;
            inputErrorDialog("Zipcode must be 5 digits", string);
            return false;
        }

        if (!string.contains("^[0-9]+$")){
            this.errors = true;
            inputErrorDialog("Zip Code must contain only numbers", string);
            return false;
        }

        this.errors = false;
        return true;
    }

    public void inputErrorDialog(String message, String userInput){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(message);
        alert.setContentText("You entered: " + userInput);
        alert.showAndWait();
    }
}
