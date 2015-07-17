package com.COP2805C.AddressBook;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import com.COP2805C.AddressBook.Database.Database;
import com.COP2805C.AddressBook.UserInterface.CreateAccountWindow;
import com.COP2805C.AddressBook.UserInterface.LoginWindow;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

/*
 * Copyright (c) 2015
 * Abir Faisal
 * Chris Buruchian
 * Alex Truong-Mai
 * Will Herrin
 *
 * COP2805 Valencia College
 * Professor dsfasdfa
 */

/**
 * Created by abirfaisal on 5/28/15.
 */
public class Functions {

    //TODO Optimize search so that it only shows relevant contacts in contactList
    public static void searchByKey(String oldValue, String newValue) {

        String previousGroup = null;

        //This method will search Googlishly for the contact typed in. When the searchfield is emptied it will return to the group the user was previously in.
        if (oldValue.length() == 0) {
            previousGroup = Main.getGroupChoiceBox().getSelectionModel().getSelectedItem();
        }

        if (newValue.length() == 0) {
            Main.getGroupChoiceBox().getSelectionModel().select(previousGroup);
            Main.getContactListView().getSelectionModel().selectFirst();
        } else {
            //When the user types, it will search through the main group because that contains all the contacts.
            Main.getGroupChoiceBox().getSelectionModel().select("Main");
            String[] parts = newValue.toUpperCase().split(" ");
            // Filter out the entries that don't contain the entered text
            String search = Main.getContactListView().getItems().get(0);
            for (Object entry : Main.getContactListView().getItems()) {
                boolean match = true;
                String entryText = (String) entry;
                for (String part : parts) {
                    // The entry needs to contain all portions of the
                    // search string *but* in any order
                    if (!entryText.toUpperCase().contains(part)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    search = entryText;
                }
            }
            Main.getContactListView().getSelectionModel().select(search);
        }
    }


    public static void refreshListView() {
        //Clear GUI list
        Main.getContactObservableList().clear();
        //Populate FX Observable list
        for (int i = 0; i < Main.getContactInformationArrayList().size(); i++) {
            Main.getContactObservableList().add(
                    getFormattedNameFMLNP(
                            Main.getContactInformationArrayList().get(i)));
        }
        Main.getContactListView().getSelectionModel().selectFirst();
    }


    public static void refreshContactArray() {
        Main.setContactInformationArrayList(
                Main.getDatabase().populateContactList(
                        Main.getCredentials(), "Main"));
    }


    public static void refreshGroupList() {
        Main.getGroupObservableList().clear();
        Main.getGroupObservableList().add("Main");
        Main.getGroupObservableList().addAll(Main.getGroupsArrayList());
    }

    public static void zeroAnchor(Node node) {
        AnchorPane.setTopAnchor(node, 0.0);
        AnchorPane.setBottomAnchor(node, 0.0);
        AnchorPane.setLeftAnchor(node, 0.0);
        AnchorPane.setRightAnchor(node, 0.0);
    }

    public static String[] createAccount(Database database) {
        String[] credentials;
        do {
            //Get new account information
            credentials = CreateAccountWindow.createAccount();

            //break if credientals null
            if (credentials == null) break;

            //Prompt user if account already exists
            if (database.doesUserExist(credentials)) JOptionPane.showMessageDialog(null, "User already Exists");
            else { //create account and break the loop
                database.addAccount(credentials);
                break;
            }
            //Keep asking if user inputs existing username
        } while (database.doesUserExist(credentials));
        //return with credentials user and password

        //return login window credentials if null
        if (credentials == null) return LoginWindow.loginPrompt();
        else return credentials; //return credentials from create account window.
    }

    //Deletes individual contactPicture
    public static void deletePictureFile(int key) {
        try {

            File file = new File("src/res/profilePic" + key + ".png");
            if (isWindows()) {
                file = new File("src\\res\\profilePic" + key + ".png");
            }
            if (file.delete()) {
                System.out.println(file.getName() + " is deleted!");
            } else {
                System.out.println("Delete operation is failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Deletes all pictureFiles of group
    public static void deleteAllPictureFile(String group) {
        ArrayList<ContactInformation> contactInformationArrayList = new ArrayList<>();
        contactInformationArrayList = Main.getDatabase().populateContactList(Main.getCredentials(), group);
        for (int i = 0; i < contactInformationArrayList.size(); i++) {
            Functions.deletePictureFile(contactInformationArrayList.get(i).getKey());
        }
    }


    public static boolean isPasswordStrong(String username, String password) {

        if (password.contains(username)) {
            JOptionPane.showMessageDialog(null, "Password cannot contain the username");
            return false;
        }

        if (password.length() < 5) {
            //TODO remove
            System.out.println(password);
            JOptionPane.showMessageDialog(null, "Your password must be at least 6 characters long");
            return false;
        }

        if (!password.matches(".*\\d+.*")) {
            JOptionPane.showMessageDialog(null, "Your password must contain at a number");
            return false;
        }

        //TODO this isn't working
        if (password.matches("([a-z\\d])\\1\\1\\1")) {
            JOptionPane.showMessageDialog(null, "Your password cannot have more than 3 identical characters in a row");
            return false;
        }

        return true;
    }

    //Make sure fields with numbers only have numbers
    public static boolean isTextFieldNumbers(TextField textField) {

        //Regex returns false if field does not have numbers.
        if (textField.getText().matches("[a-zA-Z]+")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Phone Fields cannot contain letters");

            alert.showAndWait();

            return false;
        }
        return true;
    }


    //get first, middle, last, and nickname as a single string
    public static String getFormattedNameFMLN(ContactInformation contactInformation) {

        String name = "";


        if (contactInformation.getFirstName().length() > 0) {
            name = name + contactInformation.getFirstName();
        }

        if (contactInformation.getMiddleName().length() > 0) {
            name = name + " " + contactInformation.getMiddleName();
        }

        if (contactInformation.getLastName().length() > 0) {
            name = name + " " + contactInformation.getLastName();
        }

        if (contactInformation.getNickname().length() > 0) {
            name = name + " (" + contactInformation.getNickname() + ")";
        }

        return name;
    }

    public static String getFormattedNameFMLNP(ContactInformation contactInformation) {

        String name = getFormattedNameFMLN(contactInformation);

        try {
            if (contactInformation.getPhoneNumbers().get(0).length() > 0) {
                name = name + " " + contactInformation.getPhoneNumbers().get(0);
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("No numbers saved");
        }

        return name;
    }

    public static String getOsName() {
        String OS = null;

        if (OS == null) {
            OS = System.getProperty("os.name");
        }
        return OS;
    }

    public static boolean isWindows() {
        return getOsName().startsWith("Windows");
    }

    public static String workingDirectory() {
        String workingDir = System.getProperty("user.dir");

        return workingDir;
    }

    //Sorting comparator by LastName
    public static class LastNameComparator implements Comparator<ContactInformation> {
        @Override
        public int compare(ContactInformation o1, ContactInformation o2) {
            return o1.getLastName().compareToIgnoreCase(o2.getLastName());
        }
    }

    //Sorting comparator by PhoneNumber
    public static class PhoneNumberComparator implements Comparator<ContactInformation> {
        @Override
        public int compare(ContactInformation o1, ContactInformation o2) {
            Long contact1, contact2;
            if (o1.getPhoneNumbers().size() == 0) {
                contact1 = 0L;
            } else {
                contact1 = Long.parseLong(o1.getPhoneNumbers().get(0).replace("-", ""));
            }
            if (o2.getPhoneNumbers().size() == 0) {
                contact2 = 0L;
            } else {
                contact2 = Long.parseLong(o2.getPhoneNumbers().get(0).replace("-", ""));
            }
            return Long.compare(contact1, contact2);
        }
    }
}