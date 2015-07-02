package com.COP2805C.AddressBook.UserInterface.ContactForms;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import com.COP2805C.AddressBook.UserInterface.EventHandlers;
import com.COP2805C.AddressBook.UserInterface.ImageButton;
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

        GridPane staticDataGridPane = gridPane(this.labels, this.textFields);
        GridPane phoneGridPane = gridPane(phonelabel, this.phoneTextFields);
        GridPane emailGridPane = gridPane(emaillabel, this.emailTextFields);
        GridPane workplaceGridPane = gridPane(workplacelabel, this.workplaceTextFields);

        //flow pane
        FlowPane flowpane = flowPane(
                staticDataGridPane,
                phoneGridPane,
                addButton("Add Phone Number", phoneGridPane, this.phoneTextFields),
                emailGridPane,
                workplaceGridPane,
                this.birthDatePicker,
                this.notesTextArea);
                //groupSelectButton(), addButton(), cancelButton());


        //anchor pane put in scroll pane
        AnchorPane scrollPaneAnchorPane = anchorPane(flowpane);

        //scroll pane put in pane in anchor pane
        ScrollPane scrollPane = scrollPane(scrollPaneAnchorPane);

        //AnchorPane anchorPane = anchorPane(scrollPane);
        AnchorPane anchorPane = anchorPane(scrollPane);


        //TODO change back to anchor pane
        return new Scene(anchorPane, 400.0, 600.0);
    }

    public ScrollPane scrollPane(Node... FXNode){
        ScrollPane scrollPane = new ScrollPane();

        for (int i = 0; i < FXNode.length; i++) {
            scrollPane = new ScrollPane(FXNode[i]);
        }

        AnchorPane.setTopAnchor(scrollPane, 0.0);
        AnchorPane.setBottomAnchor(scrollPane, 0.0);
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


    public ImageButton contactImage(ContactInformation contactInformation){

        //Get default image from file
        File file = new File("/defaultProfileImage.jpg");
        FileChooser fileChooser = fileChooser();
        ImageButton imageButton = new ImageButton(file.toURI().toString());


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
        flowPane.setPrefWrapLength(Double.MAX_VALUE);

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

        return textArea;
    }



    public DatePicker birthDatePicker(){
        DatePicker datePicker = new DatePicker();
        //TODO stuff here if needed
        return datePicker;
    }



    //TODO Anchor buttons into correct position
    public MenuButton groupSelectButton(){
        MenuButton menuButton = new MenuButton();

        AnchorPane.setLeftAnchor(menuButton, 5.0);
        AnchorPane.setBottomAnchor(menuButton, 5.0);

        return menuButton;
    }

    public Button addButton(String buttonText, GridPane gridPane, ArrayList<TextField> textFields){
        Button button = new Button(buttonText);

        // AnchorPane.setRightAnchor(button, 35.0);
        // AnchorPane.setBottomAnchor(button, 5.0);

        button.setOnMouseClicked(e -> {
            textFields.add(new TextField());
            gridPane.addRow(textFields.size()-1, textFields.get(textFields.size()-1));

        });



        return button;
    }

    public Button cancelButton(){
        Button button = new Button();

        AnchorPane.setRightAnchor(button, 5.0);
        AnchorPane.setBottomAnchor(button, 5.0);


        return button;
    }



}
