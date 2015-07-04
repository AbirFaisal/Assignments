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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.sqlite.Function;

import javax.swing.*;
import java.sql.SQLException;
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
    public static ObservableList<String> groupObservableList = FXCollections.observableArrayList();
    static ChoiceBox<String> groupChoiceBox;
    public static ArrayList<String> groupsArrayList = new ArrayList<>();

    static ListView<String> contactListView;
    static ObservableList<String> contactObservableList = FXCollections.observableArrayList();
    public static ArrayList<ContactInformation> contactInformationArrayList = new ArrayList<ContactInformation>();


    public static Database database = Database.getDatabase();
    public static AnchorPane rightAnchorPane;
    public static int selectedIndex;
    public static String previousGroupUserWasOn;
    public Stage mainStage = new Stage(); //TODO needed for switching to the form

    public static void main(String[] args) throws SQLException {

        //Check if database exists if not create it
        database.initialize();

        //Check if username column is empty in table accounts in column account
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
            //Launch main window if user is authenticated
            launch(args);
        }else {
            try {
                throw new IllegalAccessException("Why u tryn ta hack brah");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }finally {
                credentials[0] = null;
                credentials[1] = null;
                database.closeDB();
            }
        }

        //Close database and end program
        credentials[0] = null;
        credentials[1] = null;
        database.closeDB();
    }


        @Override
        public void start(Stage primaryStage)throws Exception {

            //Checks to see if user has contacts to load from the database.
            if(database.numberOfContacts(credentials)>0) {
                contactInformationArrayList = database.populateContactList(credentials, "Main");
            }

            ContactViewFactory contactViewFactory = new ContactViewFactory();

            //TODO the bellow code needs to go into MainWindow.java
            //Right side Anchor Pane
            //Initial contact load.
            //If the user has contacts to load from the database, this will load the first contact as an introduction
            if(database.numberOfContacts(credentials)>0) {
                rightAnchorPane = contactViewFactory.contact(contactInformationArrayList.get(0)).contactView();
            }else{//If the user has no contacts, it will load a sample contactView
                rightAnchorPane = new AnchorPane(new Text("No Contacts"));
            }
            Functions.zeroAnchor(rightAnchorPane);

            SplitMenuButton editMenuButton = MainWindow.editMenuButton();


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

            //Search Box
            TextField searchTextField = MainWindow.searchTextField();

            //Contact List
            contactListView = MainWindow.contactListView(contactObservableList);

            for(int i = 0; i < contactInformationArrayList.size();i++){
                contactObservableList.add(contactInformationArrayList.get(i).getFirstName()+ " " + contactInformationArrayList.get(i).getMiddleName() + " " +
                contactInformationArrayList.get(i).getLastName());
            }
            //This sets the customImageListView
            contactListView.setCellFactory(list -> new AttachmentListCell());
            contactListView.setFixedCellSize(40.0);
            contactListView.getSelectionModel().selectFirst();



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




    public static String[] getCredentials() {
        return credentials;
    }

    public static void setCredentials(String[] credentials) {
        Main.credentials = credentials;
    }

    public static ObservableList<String> getGroupObservableList() {
        return groupObservableList;
    }

    public static void setGroupObservableList(ObservableList<String> groupObservableList) {
        Main.groupObservableList = groupObservableList;
    }

    public static ChoiceBox<String> getGroupChoiceBox() {
        return groupChoiceBox;
    }

    public static void setGroupChoiceBox(ChoiceBox<String> groupChoiceBox) {
        Main.groupChoiceBox = groupChoiceBox;
    }

    public static ArrayList<String> getGroupsArrayList() {
        return groupsArrayList;
    }

    public static void setGroupsArrayList(ArrayList<String> groupsArrayList) {
        Main.groupsArrayList = groupsArrayList;
    }

    public static ListView<String> getContactListView() {
        return contactListView;
    }

    public static void setContactListView(ListView<String> contactListView) {
        Main.contactListView = contactListView;
    }

    public static ObservableList<String> getContactObservableList() {
        return contactObservableList;
    }

    public static void setContactObservableList(ObservableList<String> contactObservableList) {
        Main.contactObservableList = contactObservableList;
    }

    public static ArrayList<ContactInformation> getContactInformationArrayList() {
        return contactInformationArrayList;
    }

    public static void setContactInformationArrayList(ArrayList<ContactInformation> contactInformationArrayList) {
        Main.contactInformationArrayList = contactInformationArrayList;
    }

    public static Database getDatabase() {
        return database;
    }

    public static void setDatabase(Database database) {
        Main.database = database;
    }

    public static AnchorPane getRightAnchorPane() {
        return rightAnchorPane;
    }

    public void setRightAnchorPane(AnchorPane rightAnchorPane) {
        this.rightAnchorPane = rightAnchorPane;
    }

    public static int getSelectedIndex() {
        return selectedIndex;
    }

    public static void setSelectedIndex(int selectedIndex) {
        Main.selectedIndex = selectedIndex;
    }

    public static String getPreviousGroupUserWasOn() {
        return previousGroupUserWasOn;
    }

    public static void setPreviousGroupUserWasOn(String previousGroupUserWasOn) {
        Main.previousGroupUserWasOn = previousGroupUserWasOn;
    }

    public Stage getMainStage() {
        return mainStage;
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }
}

