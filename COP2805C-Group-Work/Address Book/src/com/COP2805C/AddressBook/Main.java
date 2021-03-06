package com.COP2805C.AddressBook;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import com.COP2805C.AddressBook.Database.Crypto;
import com.COP2805C.AddressBook.Database.Database;
import com.COP2805C.AddressBook.UserInterface.ContactViewPane.ContactViewFactory;
import com.COP2805C.AddressBook.UserInterface.LoginWindow;
import com.COP2805C.AddressBook.UserInterface.MainWindow;
import com.sun.javafx.css.StyleManager;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.sql.SQLException;
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

public class Main extends Application {

    public static ArrayList<ContactInformation> contactInformationArrayList;
    private static String[] credentials; //Username and password
    private static ObservableList<String> groupObservableList;
    private static ChoiceBox<String> groupChoiceBox;
    private static ArrayList<String> groupsArrayList;
    private static ListView<String> contactListView;
    private static ObservableList<String> contactObservableList;
    private static Database database;
    private static AnchorPane rightAnchorPane;
    private static Stage mainStage;

    //Main
    public static void main(String[] args) throws SQLException {
        credentials = new String[2];
        database = Database.getDatabase();

        contactObservableList = FXCollections.observableArrayList();
        groupObservableList = FXCollections.observableArrayList();
        contactInformationArrayList = new ArrayList<ContactInformation>();
        groupsArrayList = new ArrayList<>();


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
        } else {
            try {
                throw new IllegalAccessException("Why u tryn ta hack brah");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } finally {
                Functions.deleteAllPictureFile("Main");
                credentials[0] = null;
                credentials[1] = null;
                database.closeDB();
            }
        }

        //Deletes Pictures, Nulls credentials, and closes Database
        Functions.deleteAllPictureFile("Main");
        credentials[0] = null;
        credentials[1] = null;
        database.closeDB();
    }

    //Setters and Getters
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

    public static Stage getMainStage() {
        return mainStage;
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    //Java FX
    public void start(Stage primaryStage) throws Exception {
        mainStage = new Stage();

        //Declare JavaFX components
        SplitMenuButton editMenuButton;
        TextField searchTextField;
        ChoiceBox<String> sortButton;
        AnchorPane leftAnchorPane;
        SplitPane splitPane;
        AnchorPane mainWindowAnchorPane;
        Scene primaryScene;


        //Checks to see if user has contacts to load from the database.
        if (database.numberOfContacts(credentials) > 0) {
            contactInformationArrayList = database.populateContactList(credentials, "Main");
        }


        //TODO the bellow code needs to go into MainWindow.java
        //Right side Anchor Pane
        //Initial contact load.
        //If the user has contacts to load from the database, this will load the first contact as an introduction
        if (database.numberOfContacts(credentials) > 0) {

            rightAnchorPane = ContactViewFactory.contact(contactInformationArrayList.get(0)).contactView();

        } else {//If the user has no contacts, it will load a sample contactView

            Text text = new Text("No Contacts");
            Functions.zeroAnchor(text);

            rightAnchorPane = new AnchorPane(text);

            if (Functions.isWindows())
            rightAnchorPane.setStyle("-fx-background-color: #2d89ef");
            else rightAnchorPane.setStyle("-fx-background-color: #e7e7e7");


        }
        Functions.zeroAnchor(rightAnchorPane);

        //Edit Button
        editMenuButton = MainWindow.editMenuButton();

        //Add contact button
        Button addButton = MainWindow.addButton();


        //TODO clear search bar button (Optional)
        Button clearSearchButton = new Button("X");
        AnchorPane.setTopAnchor(clearSearchButton, 8.0);
        AnchorPane.setRightAnchor(clearSearchButton, 8.0);


        //Group selection
        groupChoiceBox = MainWindow.groupChoiceBox(groupObservableList);

        //Search Box
        searchTextField = MainWindow.searchTextField();

        sortButton = MainWindow.sortChoiceBox();

        //Contact List
        contactListView = MainWindow.contactListView(contactObservableList);

        for (int i = 0; i < contactInformationArrayList.size(); i++) {
            contactObservableList.add(Functions.getFormattedNameFMLNP(contactInformationArrayList.get(i)));
        }



        //Left side Anchor Pane //TODO add group add button
        leftAnchorPane = MainWindow.leftAnchorPane(
                addButton,
                searchTextField,
                sortButton,
                contactListView,
                MainWindow.groupFlowPane(),
                editMenuButton);

        //Split Pane
        splitPane = MainWindow.splitPane(leftAnchorPane, rightAnchorPane);

        //Main Window Anchor Pane
        mainWindowAnchorPane = new AnchorPane(splitPane);
        mainWindowAnchorPane.setPrefSize(800, 600);
        primaryScene = new Scene(mainWindowAnchorPane);


        //Windows Theme
        if (Functions.isWindows()) primaryScene.getStylesheets().add("/winStyle.css");
        //*nix Theme
        if (!Functions.isWindows()) primaryScene.getStylesheets().add("/nixStyle.css");

        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Contacts Manager");
        Collections.sort(contactInformationArrayList, new Functions.FirstNameComparator());
        Functions.refreshListView();
        primaryStage.show();
    }
}

