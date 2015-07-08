package com.COP2805C.AddressBook.UserInterface.ContactForms;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import com.COP2805C.AddressBook.Functions;
import com.COP2805C.AddressBook.Main;
import com.COP2805C.AddressBook.OSUtils;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;


public class AddContactForm implements Form {

    Stage addContactStage;
    ContactInformation contactInformation;
    String[] labelStrings;
    String[] dynamicLabelStrings;

    //Static Data
    ArrayList<Label> labels;
    ArrayList<TextField> textFields;
    Image contactImage; //TODO forgot what todo

    //Dynamic Data
    ArrayList<TextField> phoneTextFields;
    ArrayList<TextField> emailTextFields;
    ArrayList<TextField> workplaceTextFields;

    FlowPane flowpane;
    TextArea notesTextArea;
    DatePicker birthDatePicker;

    public AddContactForm(ContactInformation contactInformation, Stage formStage) {
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

        this.addContactStage = formStage;
    }


    @Override
    public Scene form() {

        //add static data labels and fields
        for (int i = 0; i < labelStrings.length; i++) {
            this.labels.add(label(this.labelStrings[i]));
            this.textFields.add(textField(this.labelStrings[i]));
        }

        //TODO simplify this
        ArrayList<Label> phoneLabel = new ArrayList<Label>();
        phoneLabel.add(new Label("Phone Numbers"));

        ArrayList<Label> emailLabel = new ArrayList<Label>();
        emailLabel.add(new Label("Email"));

        ArrayList<Label> workplaceLabel = new ArrayList<Label>();
        workplaceLabel.add(new Label("Workplaces"));


        //TODO Contact image view and selector
        //TODO simplify
        GridPane staticDataGridPane = gridPane(this.labels, this.textFields);
        GridPane phoneGridPane = gridPane(phoneLabel, this.phoneTextFields);
        GridPane emailGridPane = gridPane(emailLabel, this.emailTextFields);
        GridPane workplaceGridPane = gridPane(workplaceLabel, this.workplaceTextFields);


        FlowPane buttonsFlowPane = new FlowPane(
                groupChoiceBox(Main.getGroupObservableList()),
                saveButton(),
                cancelButton());

        buttonsFlowPane.setHgap(8.0);
        buttonsFlowPane.setAlignment(Pos.TOP_LEFT);


        //flow pane
        this.flowpane = flowPane(
                buttonsFlowPane,
                contactImageView(),
                staticDataGridPane,
                phoneGridPane,
                addButton("Add Phone Number", "Phone Number", phoneGridPane, this.phoneTextFields),
                emailGridPane,
                addButton("Add Email", "Email" , emailGridPane, this.emailTextFields),
                workplaceGridPane,
                addButton("Add Workplace", "Workplace", workplaceGridPane, this.workplaceTextFields),
                this.birthDatePicker,
                this.notesTextArea);

        AnchorPane anchorPane = anchorPane(this.flowpane);
        return new Scene(anchorPane, 800, 550);
    }


    public AnchorPane anchorPane(Node FXNode){

        AnchorPane anchorPane = new AnchorPane();
        Functions.zeroAnchor(anchorPane);
        anchorPane.getChildren().addAll(FXNode);

        return anchorPane;
    }


    public ImageView contactImageView(){
        //TODO smoothout animation. To achieve the effect I desire, I may have to use two imageViews. We will discuss this in class.
        //TODO since this ImageView is very custom, we should consider making it its own class similarly to how I made the imageButton class.
        File file, editFile;
        Image defaultImage, defaultEditImage;
        ImageView imageView;
        final ImageView editImageView;
        FileChooser fileChooser;

        file = new File("src/res/defaultProfileImage.png");
        editFile = new File("src/res/defaultProfileEditImage.png");
        if(OSUtils.isWindows()) {
            System.out.println(file.getAbsolutePath());
            defaultImage = new Image("res/defaultProfileImage.png", 100.0, 100.0, true, true);
            defaultEditImage = new Image("res/defaultProfileEditImage.png", 100.0, 100.0, true, true);
        }else{
            defaultImage = new Image("file://" + file.getAbsolutePath(), 100.0, 100.0, true, true);
            defaultEditImage = new Image("file://" + editFile.getAbsolutePath(), 100.0, 100.0, true, true);
        }
        imageView = new ImageView(defaultImage);
        imageView.clipProperty().set(new Circle(50, 50, 48));

        editImageView = new ImageView(defaultEditImage);
        editImageView.clipProperty().set(new Circle(50,50,48));
        editImageView.setOpacity(0.2);
        editImageView.setVisible(false);
        fileChooser = fileChooser();

        imageView.setOnMouseClicked(event -> {
            try {
                String filePath;
                if(OSUtils.isWindows()){
                    //filePath = fileChooser.showOpenDialog(new Stage()).getAbsolutePath();
                    File tempFile = new File(fileChooser.showOpenDialog(new Stage()).getAbsolutePath());
                    filePath = tempFile.toURI().toURL().toString();
                }else{
                    filePath = "file://" + fileChooser.showOpenDialog(new Stage()).getAbsolutePath();
                }
                Image image = new Image(filePath, 100.0, 100.0, true, false);
                this.contactInformation.setProfileImage(image);
                imageView.setImage(image);

            }catch (Exception e){
                System.out.println("No File selected");
                imageView.setImage(defaultImage);
            }
        });
        imageView.setOnMouseEntered(event -> {
            imageView.setCursor(Cursor.HAND); //Change cursor to hand
            FadeTransition ft = new FadeTransition(Duration.millis(500), imageView);
            ft.setFromValue(1.0);
            ft.setToValue(0.5);
            ft.setCycleCount(1);

            ft.setOnFinished(event1 -> imageView.setImage(defaultEditImage));
            ft.setAutoReverse(false);
            ft.play();
        });

        imageView.setOnMouseExited(event -> {
            FadeTransition ft = new FadeTransition(Duration.millis(500), imageView);
            ft.setFromValue(0.5);
            ft.setToValue(1.0);
            ft.setCycleCount(1);

            ft.setOnFinished(event1 -> {
                if (this.contactInformation.getProfileImage() == null) {
                    System.out.println("No picture selected");
                    imageView.setImage(defaultImage);
                }else {
                    imageView.setImage(this.contactInformation.getProfileImage());
                }
            });
            ft.setAutoReverse(false);
            ft.play();
        });

        return imageView;
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
        flowPane.setPrefWrapLength(400);
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

    public TextField textField(String promptText){
        TextField textField = new TextField();
        textField.setPromptText(promptText);
        return textField;
    }


    public TextArea notesTextArea(){
        TextArea textArea = new TextArea();
        textArea.setMaxWidth(300.0);
        textArea.setPromptText("Notes");

        return textArea;
    }



    public DatePicker birthDatePicker(){
        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Birthday");

        datePicker.setOnAction(e->{
            LocalDate birthday = datePicker.getValue();
            //this.contactInformation.setBirthday(birthday.toString());
        });

        return datePicker;
    }


    public ChoiceBox<String> groupChoiceBox(ObservableList<String> observableList){
        ChoiceBox<String> groupChoiceBox = new ChoiceBox<>(observableList);
        groupChoiceBox.getSelectionModel().selectFirst();

        AnchorPane.setLeftAnchor(groupChoiceBox, 5.0);
        AnchorPane.setBottomAnchor(groupChoiceBox, 5.0);

        groupChoiceBox.setOnInputMethodTextChanged(e -> {
            contactInformation.setGroup( //set group
                    observableList.get(  //using string from corresponding list
                            groupChoiceBox.getSelectionModel().getSelectedIndex()));
        });

        return groupChoiceBox;
    }

    public Button addButton(String buttonText, String promptText, GridPane gridPane, ArrayList<TextField> textFields){
        Button button = new Button(buttonText);


        button.setOnMouseClicked(e -> {
            TextField textField = new TextField(); //new textfield

            textField.setPromptText(promptText);
            textFields.add(textField);

            gridPane.addRow(textFields.size(), textFields.get(textFields.size() - 1));

            gridPane.add(
                    removeButton(gridPane, textFields, textFields.get(textFields.size()-1)),
                    1,
                    textFields.size());
        });

        return button;
    }

    public Button removeButton(GridPane gridPane, ArrayList<TextField> textFields, TextField textField){
        Button button = new Button("-");

        button.setOnAction(e ->{

            gridPane.getChildren().remove(
                    gridPane.getChildren().indexOf(textField));

            gridPane.getChildren().remove(
                    gridPane.getChildren().indexOf(button));

            textFields.remove(textFields.indexOf(textField));
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
                this.contactInformation.setBirthday("2015-10-14");
            }
            //save dynamic data
            //Phone Numbers
            //System.out.println("phonetxtfields size" + this.phoneTextFields.size());
            //.out.println("phonetxt fields text " + this.phoneTextFields.get(0).getText());

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
            this.contactInformation.setKey(Main.getDatabase().createContact(Main.getCredentials(), this.contactInformation));

            //TODO this below statement is so that when they click save it immediately closes the addContactWindow. It prevents duplicates.
            addContactStage.close();
            Functions.refreshContactArray();
            Functions.refreshListView();
        });

        return button;
    }


    public Button cancelButton(){
        Button button = new Button("Cancel");

        button.setOnMouseClicked(e ->{
            addContactStage.close();
        });

        return button;
    }
}
