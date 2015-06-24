package com.COP2805C.AddressBook;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import com.COP2805C.AddressBook.Contacts.ContactInformationBuilder;
import com.COP2805C.AddressBook.Database.Crypto;
import com.COP2805C.AddressBook.Database.Database;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
    public static ArrayList<Integer> contactIDS = new ArrayList<>();
    public static boolean populateContacts = true;
    public Stage mainStage; //TODO needed for switching to the form

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

        //Populate the contactInformationArrayList
        if (Crypto.authenticateUser(credentials)) {

            //TODO Load Contact List from database into FXcollections Observable list
            //ContactInformation = new ContactInformation(database.generateContact);
            //ContactInformation = new ContactInformation(database.generateContact);

            //Launch main window
            launch(args);


            //TODO save contactInformationArrayList to database
        }
    }
        @Override
        public void start(Stage primaryStage)throws Exception {

            //TODO build method that repopulates contacts depending on which group is selected.
            //TODO load groups from database into an ArrayList.
            if (populateContacts) {
                try {
                    contactIDS = database.getContactIDS(credentials);

                    ContactInformationBuilder cib = new ContactInformationBuilder();
                    for (int begin = 0; begin < contactIDS.size(); begin++) {
                        contactInformationArrayList.add(cib.prepareContact(contactIDS.get(begin)));
                    }

                    //Below: For testing
                    System.out.println(contactInformationArrayList.toString());
                } catch (NullPointerException e) {
                    System.out.println(e + " No contacts are created for this user yet");
                }
                populateContacts = false;
            }
            /**TEST DO NOT REMOVE ONLY COMMENT OUT**/
            Image testImage = new Image("http://i.imgur.com/6zqQI1S.jpg");
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
                    "First", "Middle", "Last", "Nick",
                    "addr1", "addr2", "city", "state", "zip",
                    "notes",
                    phone, email, work,
                    testCalendar);


            ContactViewFactory contactViewFactory = new ContactViewFactory();
            //ContactAnchorPane contactAnchorPane = contactViewFactory.contact(contactInformation).contactView();
            /**TEST DO NOT REMOVE ONLY COMMENT OUT**/



            //TODO the bleow code needs to go into MainWindow.java
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
            addButton.setOnAction(e -> {
                CreateContactWindow createContact = new CreateContactWindow();
                createContact.display(credentials);
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

            groupObservableList.add("Main Group");//TODO for each group add to list
            groupChoiceBox.getSelectionModel().selectFirst();


            //Search Box
            TextField searchTextField = MainWindow.searchTextField();

            //Contact List
            //ObservableList<String> contactObservableList = FXCollections.observableArrayList ();
            ListView<String> contactListView = MainWindow.contactListView(contactObservableList);


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

