package com.COP2805C.AddressBook;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import com.COP2805C.AddressBook.Database.Crypto;
import com.COP2805C.AddressBook.Database.Database;
import com.COP2805C.AddressBook.UserInterface.ContactForms.Form;
import com.COP2805C.AddressBook.UserInterface.ContactForms.FormFactory;
import com.COP2805C.AddressBook.UserInterface.ContactViewPane.ContactViewFactory;
import com.COP2805C.AddressBook.UserInterface.CreateContactWindow;
import com.COP2805C.AddressBook.UserInterface.LoginWindow;
import com.COP2805C.AddressBook.UserInterface.MainWindow;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Main extends Application {

    private static String[] credentials = new String[2]; //Username and password
    ObservableList<String> groupObservableList = FXCollections.observableArrayList();
    static ObservableList<String> contactObservableList = FXCollections.observableArrayList();
    static ArrayList<ContactInformation> contactInformationArrayList = new ArrayList<ContactInformation>();

    public static Database database = Database.getDatabase();
    public AnchorPane rightAnchorPane;


    public Stage mainStage = new Stage(); //TODO needed for switching to the form

    public static void main(String[] args) {

        //TODO Chris can you make a database.addContact(credentials, contactInformation)?
        //I'm not sure how to approach this matter.


        //Check if database exists if not create it
        database.initialize();


        //Check if username column is empty
        if (database.isColumnEmpty("ACCOUNTS", "ACCOUNT")) {
            //Create Account
            credentials = Functions.createAccount(database);
        } else {
            do {
                //Returns null if user selects create account
                credentials = LoginWindow.loginPrompt();

                if (credentials == null) {
                    credentials = Functions.createAccount(database);
                    break;
                } else if (!Crypto.authenticateUser(credentials)) {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
                //keep prompting while user is not authenticated
            } while (!Crypto.authenticateUser(credentials));
        }

        if (Crypto.authenticateUser(credentials)) {

            //TODO Load Contact List from database into FXcollections Observable list
            //Launch main window
            launch(args);


            //TODO save contactInformationArrayList to database
        }
    }
        @Override
        public void start(Stage primaryStage)throws Exception {

            //Checks to see if user has contacts to load from the database.
            if(database.numberOfContacts(credentials)>0) {
                contactInformationArrayList = database.populateContactList(credentials, "Main");
            }
            /**TEST DO NOT REMOVE ONLY COMMENT OUT**/
            Image testImage = new Image("/res/defaultProfileImage.png");
            ArrayList<String> phone = new ArrayList<>();
            ArrayList<String> email = new ArrayList<>();
            ArrayList<String> work = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                phone.add("phone " + i);
                email.add("email " + i);
                work.add("work " + i);
            }

            Calendar testCalendar = new GregorianCalendar(2015, 3, 3);

            ContactInformation contactInformation = new ContactInformation(
                    1, "group",
                    testImage,
                    "First", "Middle", "Last", "Sample",
                    "addr1", "addr2", "city", "state", "zip", "country",
                    "notes",
                    phone, email, work,
                    testCalendar);


            ContactViewFactory contactViewFactory = new ContactViewFactory();
            //ContactAnchorPane contactAnchorPane = contactViewFactory.contact(contactInformation).contactView();
            /**TEST DO NOT REMOVE ONLY COMMENT OUT**/



            //TODO the bleow code needs to go into MainWindow.java
            //Right side Anchor Pane
            //Initial contact load.
            //If the user has contacts to load from the database, this will load the first contact as an introduction
            if(database.numberOfContacts(credentials)>0) {
                rightAnchorPane = contactViewFactory.contact(contactInformationArrayList.get(0)).contactView();
            }else{//If the user has no contacts, it will load a sample contactView
                rightAnchorPane = contactViewFactory.contact(contactInformation).contactView();
            }
            AnchorPane.setTopAnchor(rightAnchorPane, 0.0);
            AnchorPane.setBottomAnchor(rightAnchorPane, 0.0);
            AnchorPane.setLeftAnchor(rightAnchorPane, 0.0);
            AnchorPane.setRightAnchor(rightAnchorPane, 0.0);
            //rightAnchorPane = contactViewFactory.contact(contactInformationArrayList.get(0)).contactView();


            //TODO dynamicly generate the above

            //Something like this then re add the nodes
            //rightAnchorPane.getChildren().clear();


            SplitMenuButton editMenuButton = MainWindow.editMenuButton();

            FormFactory formFactory = new FormFactory();

            //Add contact button
            Button addButton = new Button("+");
            addButton.setOnMouseClicked(e -> {


                mainStage.setScene(formFactory.getForm(contactInformationArrayList.get(0), "ADD").form());

                mainStage.show();

            });
            AnchorPane.setTopAnchor(addButton, 8.0);
            AnchorPane.setLeftAnchor(addButton, 8.0);

            //TODO clear search bar button (Optional)
            Button clearSearchButton = new Button("X");
            AnchorPane.setTopAnchor(clearSearchButton, 8.0);
            AnchorPane.setRightAnchor(clearSearchButton, 8.0);


            //Group selection
            //ObservableList<String> groupObservableList = FXCollections.observableArrayList();
            ChoiceBox<String> groupChoiceBox = MainWindow.groupChoiceBox(groupObservableList);

            //TODO move into event handlers
            ArrayList<String> groups = database.getGroups(credentials);
            groupObservableList.add("Main");
            groupObservableList.addAll(groups);
            groupChoiceBox.getSelectionModel().selectFirst();
            groupChoiceBox.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue)->{
                contactInformationArrayList = database.populateContactList(credentials,newValue);
                contactObservableList.clear();
                for(int i = 0; i < contactInformationArrayList.size();i++){
                    //contactObservableList.add(contactInformationArrayList.get(i).getFirstName());
                    contactObservableList.add(contactInformationArrayList.get(i).getFirstName()+ " " + contactInformationArrayList.get(i).getMiddleName() + " " +
                            contactInformationArrayList.get(i).getLastName());
                }
            });


            //Search Box
            TextField searchTextField = MainWindow.searchTextField();

            //Contact List
            //ObservableList<String> contactObservableList = FXCollections.observableArrayList ();


            ListView<String> contactListView = MainWindow.contactListView(contactObservableList);
            for(int i = 0; i < contactInformationArrayList.size();i++){
                contactObservableList.add(contactInformationArrayList.get(i).getFirstName()+ " " + contactInformationArrayList.get(i).getMiddleName() + " " +
                contactInformationArrayList.get(i).getLastName());
            }
            //This sets the customImageListView
            contactListView.setCellFactory(list -> new AttachmentListCell());

            contactListView.setFixedCellSize(40.0);
            contactListView.getSelectionModel().selectFirst();
            contactListView.getSelectionModel().selectedIndexProperty().addListener((v,oldValue,newValue)->{
                int index = 0;
                //error checking necessary to avoid array Out Of Bounds.
                if(newValue.intValue()!=-1)index = newValue.intValue();
                AnchorPane newRightAnchorPane = contactViewFactory.contact(contactInformationArrayList.get(index)).contactView();
                rightAnchorPane.getChildren().clear();
                rightAnchorPane.getChildren().add(newRightAnchorPane);
            });


            //Left side Anchor Pane
            AnchorPane leftAnchorPane = MainWindow.leftAnchorPane(
                    addButton,
                    searchTextField,
                    contactListView,
                    groupChoiceBox,
                    editMenuButton);

            //Split Pane
            SplitPane splitPane = MainWindow.splitPane(leftAnchorPane, rightAnchorPane);

            //Main Window Anchor Pane
            AnchorPane mainWindowAnchorPane = new AnchorPane(splitPane);
            mainWindowAnchorPane.setPrefSize(800, 600);
            Scene primaryScene = new Scene(mainWindowAnchorPane);
            primaryStage.setScene(primaryScene);
            primaryStage.setTitle("Contacts Manager");
            primaryStage.show();

        }
    }
//TODO Abir, where should I put this? lol.
//Custom ListCell for listView
class AttachmentListCell extends ListCell<String> {
    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
            setText(null);
        } else {
            Image fxImage = Main.contactInformationArrayList.get(getIndex()).getProfileImage();
            ImageView imageView = new ImageView(fxImage);
            imageView.fitWidthProperty().set(50);
            imageView.fitHeightProperty().set(50);
            setGraphic(imageView);
            setText(item);
        }
    }
}

