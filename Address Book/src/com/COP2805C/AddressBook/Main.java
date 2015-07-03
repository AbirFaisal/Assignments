package com.COP2805C.AddressBook;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import com.COP2805C.AddressBook.Database.Crypto;
import com.COP2805C.AddressBook.Database.Database;
import com.COP2805C.AddressBook.UserInterface.AttachmentListCell;
import com.COP2805C.AddressBook.UserInterface.ContactForms.FormFactory;
import com.COP2805C.AddressBook.UserInterface.ContactViewPane.ContactViewFactory;
import com.COP2805C.AddressBook.UserInterface.LoginWindow;
import com.COP2805C.AddressBook.UserInterface.MainWindow;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.Era;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.ValueRange;
import java.util.*;


public class Main extends Application {

    private static String[] credentials = new String[2]; //Username and password
    static ObservableList<String> groupObservableList = FXCollections.observableArrayList();
    static ChoiceBox<String> groupChoiceBox;
    static ArrayList<String> groups = new ArrayList<>();

    static ListView<String> contactListView;
    static ObservableList<String> contactObservableList = FXCollections.observableArrayList();
    public static ArrayList<ContactInformation> contactInformationArrayList = new ArrayList<ContactInformation>();


    public static Database database = Database.getDatabase();
    public AnchorPane rightAnchorPane;
    public static int selectedIndex;

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

            Chronology testChronology = new Chronology() {
                @Override
                public String getId() {
                    return null;
                }

                @Override
                public String getCalendarType() {
                    return null;
                }

                @Override
                public ChronoLocalDate date(int prolepticYear, int month, int dayOfMonth) {
                    return null;
                }

                @Override
                public ChronoLocalDate dateYearDay(int prolepticYear, int dayOfYear) {
                    return null;
                }

                @Override
                public ChronoLocalDate dateEpochDay(long epochDay) {
                    return null;
                }

                @Override
                public ChronoLocalDate date(TemporalAccessor temporal) {
                    return null;
                }

                @Override
                public boolean isLeapYear(long prolepticYear) {
                    return false;
                }

                @Override
                public int prolepticYear(Era era, int yearOfEra) {
                    return 0;
                }

                @Override
                public Era eraOf(int eraValue) {
                    return null;
                }

                @Override
                public List<Era> eras() {
                    return null;
                }

                @Override
                public ValueRange range(ChronoField field) {
                    return null;
                }

                @Override
                public ChronoLocalDate resolveDate(Map<TemporalField, Long> fieldValues, ResolverStyle resolverStyle) {
                    return null;
                }

                @Override
                public int compareTo(Chronology other) {
                    return 0;
                }
            };

            ContactInformation contactInformation = new ContactInformation(
                    1, "group",
                    testImage,
                    "First", "Middle", "Last", "Sample",
                    "addr1", "addr2", "city", "state", "zip", "country",
                    "notes",
                    phone, email, work,
                    testChronology);


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


            editMenuButton.setOnAction(e->{
               System.out.println("Edit button pressed");
            });
            //TODO This is the functionality for the delete Button. I did not know how to access the menuItem.
            editMenuButton.setOnMouseClicked(e -> {
                database.deleteCONTACTID(contactInformationArrayList.get(selectedIndex).getKey());
                contactInformationArrayList.remove(selectedIndex);
                refreshListView();
                groups = database.getGroups(credentials);
                refreshGroupList();
                groupChoiceBox.getSelectionModel().selectFirst();
            });


            //Add contact button
            //TODO move button to Mainwindow.java and put even handler inside before returning add button
            Button addButton = MainWindow.addButton(this.mainStage);



            //TODO clear search bar button (Optional)
            Button clearSearchButton = new Button("X");
            AnchorPane.setTopAnchor(clearSearchButton, 8.0);
            AnchorPane.setRightAnchor(clearSearchButton, 8.0);


            //Group selection
            //ObservableList<String> groupObservableList = FXCollections.observableArrayList();
            groupChoiceBox = MainWindow.groupChoiceBox(groupObservableList);

            //TODO move into event handlers
            groups = database.getGroups(credentials);
            refreshGroupList();
            groupChoiceBox.getSelectionModel().selectFirst(); // select first by default

            groupChoiceBox.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue)->{
                contactInformationArrayList = database.populateContactList(credentials,newValue);
                refreshListView();
            });


            //Search Box
            TextField searchTextField = MainWindow.searchTextField();

            //Contact List
            //ObservableList<String> contactObservableList = FXCollections.observableArrayList ();


            contactListView = MainWindow.contactListView(contactObservableList);
            for(int i = 0; i < contactInformationArrayList.size();i++){
                contactObservableList.add(contactInformationArrayList.get(i).getFirstName()+ " " + contactInformationArrayList.get(i).getMiddleName() + " " +
                contactInformationArrayList.get(i).getLastName());
            }
            //This sets the customImageListView
            contactListView.setCellFactory(list -> new AttachmentListCell());
            contactListView.setFixedCellSize(40.0);
            contactListView.getSelectionModel().selectFirst();
            contactListView.getSelectionModel().selectedIndexProperty().addListener((v,oldValue,newValue)->{
                selectedIndex = 0;
                //error checking necessary to avoid array Out Of Bounds.
                if(newValue.intValue()!=-1)selectedIndex = newValue.intValue();
                //TODO DEPRECIATED
                AnchorPane newRightAnchorPane = contactViewFactory.contact(contactInformationArrayList.get(selectedIndex)).contactView();
                rightAnchorPane.getChildren().clear();
                rightAnchorPane.getChildren().add(newRightAnchorPane);
                        //contactViewFactory.contact(contactInformationArrayList.get(selectedIndex)).contactView());
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

    public void refreshListView(){
        contactObservableList.clear();
        for(int i = 0; i < contactInformationArrayList.size();i++){
            //contactObservableList.add(contactInformationArrayList.get(i).getFirstName());

            //TODO use function I built in contactAncorPane do do the below in a more proper way
            //todo since it checks for null and everything

            contactObservableList.add(contactInformationArrayList.get(i).getFirstName()+ " " + contactInformationArrayList.get(i).getMiddleName() + " " +
                    contactInformationArrayList.get(i).getLastName());
        }
        contactListView.getSelectionModel().selectFirst();
    }

    public void refreshGroupList(){
        groupObservableList.clear();
        groupObservableList.add("Main");
        groupObservableList.addAll(groups);
    }


    public static ArrayList<ContactInformation> getContactInformationArrayList() {
        return contactInformationArrayList;
    }

    public static ObservableList<String> getGroupObservableList() {
        return groupObservableList;
    }

    public static String[] getCredentials() {
        return credentials;
    }

    public static Database getDatabase() {
        return database;
    }
}

