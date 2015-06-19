package com.COP2805C.AddressBook;

import com.COP2805C.AddressBook.Database.Crypto;
import com.COP2805C.AddressBook.Database.Database;
import com.COP2805C.AddressBook.UserInterface.ContactViewPane.ContactViewFactory;
import com.COP2805C.AddressBook.UserInterface.CreateAccountWindow;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Main extends Application {

    private static String[] credentials = new String[2]; //Username and password
    ObservableList<String> contactObservableList = FXCollections.observableArrayList();
    ObservableList<String> groupObservableList = FXCollections.observableArrayList();
    ArrayList<ContactInformation> contactInformationArrayList = new ArrayList<ContactInformation>();

    public static Database database = Database.getDatabase();

    public static void main(String[] args) {

        //Check if database exists if not create it
        database.initialize();

        do {
            //TODO check if username column is empty
            if (database.isColumnEmpty("ACCOUNTS", "USERNAMES")) {
                do {
                    //Get new account information
                    credentials = CreateAccountWindow.createAccount();

                    //Prompt user if account already exists
                    if (database.doesUserExist(credentials)) {
                        JOptionPane.showMessageDialog(null, "User already Exists");
                    }

                    //make sure username doesnt exist
                } while (database.doesUserExist(credentials));

                //if account doesnt exist then add it
                if (!database.doesUserExist(credentials)) {
                    database.addAccount(credentials);
                }
                //if username columlnm is not empty
            } else {
                //Prompt for user and password
                credentials = LoginWindow.loginPrompt();

                //prompt username and password are invalid
                if (Crypto.authinticateUser(credentials)) {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }
            //keep prompting while user is not authinticated
        } while (Crypto.authinticateUser(credentials));

        //populate the contactInformationArrayList
        if (Crypto.authinticateUser(credentials)) {
            //TODO populate contactInformationArrayList
        }

        //TODO Load Contact List from database into FXcollections Observable list


        //Launch main window
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        /**TEST DO NOT REMOVE ONLY COMMENT OUT**/
        Image testImage = new Image("http://i.imgur.com/0dMGQvy.jpg");
        ArrayList<String> phone = new ArrayList<>();
        ArrayList<String> email = new ArrayList<>();
        ArrayList<String> work = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            phone.add("phone" + i);
            email.add("email" + i);
            work.add("work" + i);
        }

        Calendar testCalendar = new GregorianCalendar(2015, 3, 3);

        ContactInformation contactInformation = new ContactInformation(
                1, "group",
                testImage,
                "First", "Middle", "Last", "Nick",
                "addr1", "addr2", "city", "state", "zip",
                "notes",
                phone, email, work,
                testCalendar);


        ContactViewFactory contactViewFactory = new ContactViewFactory();
        //ContactAnchorPane contactAnchorPane = contactViewFactory.contact(contactInformation).contactView();
        /**TEST DO NOT REMOVE ONLY COMMENT OUT**/


        //Right side Anchor Pane
        AnchorPane rightAnchorPane = contactViewFactory.contact(contactInformation).contactView();

        AnchorPane.setTopAnchor(rightAnchorPane, 0.0);
        AnchorPane.setBottomAnchor(rightAnchorPane, 0.0);
        AnchorPane.setLeftAnchor(rightAnchorPane, 0.0);
        AnchorPane.setRightAnchor(rightAnchorPane, 0.0);
        //TODO dynamicly generate the above

        //Something like this then re add the nodes
        //rightAnchorPane.getChildren().clear();


        SplitMenuButton editMenuButton = MainWindow.editMenuButton();

        //Add contact button
        Button addButton = new Button("+");
        AnchorPane.setTopAnchor(addButton, 8.0);
        AnchorPane.setLeftAnchor(addButton, 8.0);

        //clear search bar button (Optional)
        Button clearSearchButton = new Button("X");
        AnchorPane.setTopAnchor(clearSearchButton, 8.0);
        AnchorPane.setRightAnchor(clearSearchButton, 8.0);


        //Group selection
        //ObservableList<String> groupObservableList = FXCollections.observableArrayList();
        ChoiceBox<String> groupChoiceBox = MainWindow.groupChoiceBox(groupObservableList);

        groupObservableList.add("Main Group");//TODO for each group add to list
        groupChoiceBox.getSelectionModel().selectFirst();


        //Search Box
        TextField searchTextField = MainWindow.searchTextField();

        //Contact List
        //ObservableList<String> contactObservableList = FXCollections.observableArrayList ();
        ListView<String> contactListView = MainWindow.contactListView(contactObservableList);

        //TODO test
        contactObservableList.add("test");
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

        //TODO fix this?? what is this?
        //Login.loginScreen();//Note I intend for this to pop-up first before the user can do anything thus requiring them to log-in.
    }
}