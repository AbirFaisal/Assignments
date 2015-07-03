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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Main extends Application {

    private static String[] credentials = new String[2]; //Username and password
    static ObservableList<String> groupObservableList = FXCollections.observableArrayList();
    static ChoiceBox<String> groupChoiceBox;
    static ArrayList<String> groups = new ArrayList<>();

    static ListView<String> contactListView;
    static ObservableList<String> contactObservableList = FXCollections.observableArrayList();
    private static ArrayList<ContactInformation> contactInformationArrayList = new ArrayList<ContactInformation>();


    public static Database database = Database.getDatabase();
    public AnchorPane rightAnchorPane;
    public static int selectedIndex;
    public static String previousGroupUserWasOn;
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
            searchTextField.textProperty().addListener((v,oldValue,newValue)->{
                searchByKey(oldValue,newValue);
            });

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
    //TODO Optimize search so that it only shows relevant contacts in contactList
    private void searchByKey(String oldValue, String newValue) {
        //This method will search Googlishly for the contact typed in. When the searchfield is emptied it will return to the group the user was previously in.
        if(oldValue.length()==0){
            previousGroupUserWasOn = groupChoiceBox.getSelectionModel().getSelectedItem();
        }
        if(newValue.length()==0) {
            groupChoiceBox.getSelectionModel().select(previousGroupUserWasOn);
            contactListView.getSelectionModel().selectFirst();
        }else{
            //When the user types, it will search through the main group because that contains all the contacts.
            groupChoiceBox.getSelectionModel().select("Main");
            String[] parts = newValue.toUpperCase().split(" ");
            // Filter out the entries that don't contain the entered text
            String search = contactListView.getItems().get(0);
            for ( Object entry: contactListView.getItems() ) {
                boolean match = true;
                String entryText = (String)entry;
                for ( String part: parts ) {
                    // The entry needs to contain all portions of the
                    // search string *but* in any order
                    if ( ! entryText.toUpperCase().contains(part) ) {
                        match = false;
                        break;
                    }
                }
                if ( match ) {
                    search = entryText;
                }
            }
            contactListView.getSelectionModel().select(search);
        }
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
}

