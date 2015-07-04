package com.COP2805C.AddressBook.UserInterface.ContactForms;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import com.COP2805C.AddressBook.Database.Database;
import com.COP2805C.AddressBook.Main;
import com.COP2805C.AddressBook.UserInterface.EventHandlers;
import com.COP2805C.AddressBook.UserInterface.ImageButton;
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
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.util.ArrayList;


public class AddContactForm implements Form {

    ContactInformation contactInformation;
    String[] labelStrings;
    String[] dynamicLabelStrings;

    //Static Data
    ArrayList<Label> labels;
    ArrayList<TextField> textFields;

    //Dynamic Data
    ArrayList<TextField> phoneTextFields;
    ArrayList<TextField> emailTextFields;
    ArrayList<TextField> workplaceTextFields;

    ScrollPane scrollPane;
    FlowPane flowpane;
    TextArea notesTextArea;
    DatePicker birthDatePicker;

    public AddContactForm(ContactInformation contactInformation) {
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
    }


    @Override
    public Scene form() {

        //TODO Use the functions below to generate these
        for (int i = 0; i < labelStrings.length; i++) {
            this.labels.add(label(this.labelStrings[i]));
            this.textFields.add(textField());
        }



        //TODO simplify this
        ArrayList<Label> phonelabel = new ArrayList<Label>();
        phonelabel.add(new Label("Phone Numbers"));

        ArrayList<Label> emaillabel = new ArrayList<Label>();
        emaillabel.add(new Label("Email"));

        ArrayList<Label> workplacelabel = new ArrayList<Label>();
        workplacelabel.add(new Label("Workplaces"));



        //TODO Contact image view and selector
        //TODO simplify
        GridPane staticDataGridPane = gridPane(this.labels, this.textFields);
        GridPane phoneGridPane = gridPane(phonelabel, this.phoneTextFields);
        GridPane emailGridPane = gridPane(emaillabel, this.emailTextFields);
        GridPane workplaceGridPane = gridPane(workplacelabel, this.workplaceTextFields);

        //flow pane
        this.flowpane = flowPane(
                contactImage(),
                staticDataGridPane,
                phoneGridPane,
                addButton("Add Phone Number", phoneGridPane, this.phoneTextFields),
                emailGridPane,
                addButton("Add Email", emailGridPane, this.emailTextFields),
                workplaceGridPane,
                addButton("Add Workplace", workplaceGridPane, this.workplaceTextFields),
                this.birthDatePicker,
                this.notesTextArea,
                groupChoiceBox(Main.getGroupObservableList()));

        //anchor pane put in scroll pane
        AnchorPane scrollPaneAnchorPane = anchorPane(flowpane, saveButton(), cancelButton());



        this.scrollPane = scrollPane(scrollPaneAnchorPane);


        //AnchorPane anchorPane = anchorPane(scrollPane);
        AnchorPane anchorPane = anchorPane(this.scrollPane);



        Scene scene = new Scene(anchorPane, 400.0, 700.0);
        return scene;
    }

    public ScrollPane scrollPane(Node... FXNode){
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        for (int i = 0; i < FXNode.length; i++) {
            scrollPane = new ScrollPane(FXNode[i]);
        }

        AnchorPane.setTopAnchor(scrollPane, 10.0);
        AnchorPane.setBottomAnchor(scrollPane, 40.0);
        AnchorPane.setLeftAnchor(scrollPane, 0.0);
        AnchorPane.setRightAnchor(scrollPane, 0.0);


        //TODO stuff here
        return scrollPane;
    }


    public AnchorPane anchorPane(Node... FXNode){

        AnchorPane anchorPane = new AnchorPane();

        for (int i = 0; i < FXNode.length; i++) {
            AnchorPane.setTopAnchor(FXNode[i], 0.0);
        }

        anchorPane.getChildren().addAll(FXNode);

        //TODO stuff here


        return anchorPane;
    }


    public ImageButton contactImage(){

        //TODO THIS LOOKS SUPER RATCHET IN THE GUI
        //Get default image from file
        File file = new File("defaultProfileImage.jpg");
        FileChooser fileChooser = fileChooser();
        ImageButton imageButton = new ImageButton(file.toURI().toString());

        Circle clip = new Circle(50, 50, 48);

        imageButton.clipProperty().set(clip);


        //TODO move to event handlers
        imageButton.setOnMouseClicked(event -> {

            imageButton.setFileURL(
                    fileChooser.showOpenDialog(new Stage()).getAbsolutePath());

            //TODO remove test
            System.out.println(imageButton.getFileURL());

            if (imageButton.getFileURL() != null) {

                //TODO run image through image formatter
                Image image = new Image("file://" + imageButton.getFileURL(),
                        100.0, 100.0,   //Dimensions pixels
                        true,           //Keep aspect ratio
                        false);         //bool Smooth no idea what that means

                //change image button image
                imageButton.changePicture(image);
                //set this contact image image
                this.contactInformation.setProfileImage(image);
            }
        });
        return imageButton;
    }


    public FileChooser fileChooser(){
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("View Pictures");

        //TODO make sure this works in windows
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        return fileChooser;
    }


    public FlowPane flowPane(Node... FXNode){
        FlowPane flowPane = new FlowPane();

        flowPane.getChildren().addAll(FXNode);

        //TODO format this further
        flowPane.setAlignment(Pos.TOP_LEFT);
        flowPane.setOrientation(Orientation.VERTICAL);
        flowPane.setPrefWrapLength(FXNode.length*128);//TODO umm... seriously?
        flowPane.setVgap(8.0);

        AnchorPane.setTopAnchor(flowPane, 20.0);
        AnchorPane.setBottomAnchor(flowPane, 20.0);
        AnchorPane.setLeftAnchor(flowPane, 20.0);
        AnchorPane.setRightAnchor(flowPane, 20.0);

        return flowPane;
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


    public TextArea notesTextArea(){
        TextArea textArea = new TextArea();
        textArea.setMaxWidth(300.0);

        return textArea;
    }



    public DatePicker birthDatePicker(){
        DatePicker datePicker = new DatePicker();
        //TODO stuff here if needed
        return datePicker;
    }



    //TODO Anchor buttons into correct position
    public ChoiceBox<String> groupChoiceBox(ObservableList<String> observableList){
        ChoiceBox<String> groupChoiceBox = new ChoiceBox<>(observableList);
        groupChoiceBox.getSelectionModel().selectFirst();

        AnchorPane.setLeftAnchor(groupChoiceBox, 5.0);
        AnchorPane.setBottomAnchor(groupChoiceBox, 5.0);

        return groupChoiceBox;
    }

    public Button addButton(String buttonText, GridPane gridPane, ArrayList<TextField> textFields){
        Button button = new Button(buttonText);

        // AnchorPane.setRightAnchor(button, 35.0);
        // AnchorPane.setBottomAnchor(button, 5.0);

        button.setOnMouseClicked(e -> {
            textFields.add(new TextField());
            gridPane.addRow(textFields.size(), textFields.get(textFields.size() - 1));

        });

        return button;
    }


    public Button saveButton(){
        Button button = new Button("Save");

        AnchorPane.setBottomAnchor(button, 5.0);
        AnchorPane.setLeftAnchor(button, 50.0);


        button.setOnMouseClicked(e ->{
            //Image already set by image button
            //Group already set by group selection button

            //save static data
            //First Name
            this.contactInformation.setFirstName(
                    this.labels.get(0).getText());
            //Middle Name
            this.contactInformation.setMiddleName(
                    this.labels.get(1).getText());
            //Last Name
            this.contactInformation.setLastName(
                    this.labels.get(2).getText());

            this.contactInformation.setNickname(
                    this.labels.get(3).getText());

            //Address
            this.contactInformation.setAddressLine1(
                    this.labels.get(4).getText());

            this.contactInformation.setAddressLine2(
                    this.labels.get(5).getText());

            this.contactInformation.setCity(
                    this.labels.get(6).getText());

            this.contactInformation.setState(
                    this.labels.get(7).getText());

            this.contactInformation.setZip(
                    this.labels.get(8).getText());

            this.contactInformation.setCountry(
                    this.labels.get(9).getText());

            //Notes
            this.contactInformation.setNotes(
                    this.notesTextArea.getText());

            //Birth Date
            this.contactInformation.setBirthday(
                    this.birthDatePicker.getChronology());

            this.contactInformation.setZip(
                    this.labels.get(0).getText());

            this.contactInformation.setZip(
                    this.labels.get(0).getText());


            //save dynamic data
            //Phone Numbers
            for (int i = 0; i < this.phoneTextFields.size(); i++) {
                this.contactInformation.getPhoneNumbers().add(
                        this.phoneTextFields.get(i).getText());
            }
            //Emails
            for (int i = 0; i < this.emailTextFields.size(); i++) {
                this.contactInformation.getEmails().add(
                        this.emailTextFields.get(i).getText());
            }
            //Workplaces
            for (int i = 0; i < this.workplaceTextFields.size(); i++) {
                this.contactInformation.getWorkPlaces().add(
                        this.workplaceTextFields.get(i).getText());
            }

            //add to database
            //TODO chris is this correct???
            //Add key to contactInformation Object
            this.contactInformation.setKey(
                    Database.createContact(
                            Main.getCredentials(), this.contactInformation));

            Main.getDatabase().addContact(dkfkaslkjdfanskjdfaslkdf) //TODO

            //TODO update list view and stuff
        });



        return button;
    }


    public Button cancelButton(){
        Button button = new Button("Cancel");

        AnchorPane.setRightAnchor(button, 5.0);
        AnchorPane.setBottomAnchor(button, 5.0);

        return button;
    }
}
