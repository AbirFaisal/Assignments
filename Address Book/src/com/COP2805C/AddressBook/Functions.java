package com.COP2805C.AddressBook;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import com.COP2805C.AddressBook.Database.Database;
import com.COP2805C.AddressBook.UserInterface.CreateAccountWindow;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.swing.*;

/**
 * Created by abirfaisal on 5/28/15.
 */
public class Functions {

    public static String[] createAccount(Database database) {
        String[] credentials;
        do {
            //Get new account information
            credentials = CreateAccountWindow.createAccount();

            //Prompt user if account already exists
            if (database.doesUserExist(credentials)) {
                JOptionPane.showMessageDialog(null, "User already Exists");
            } else { //create account and break the loop
                database.addAccount(credentials);
                break;
            }
            //Keep asking if user inputs existing username
        } while (database.doesUserExist(credentials));
        return credentials;
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


    //get first, middle, last, and nickname as a single string
    public static String getFormattenNameFMLN(ContactInformation contactInformation) {
        String name = "";

        try {
            name = name + contactInformation.getFirstName();
        } catch (Exception e) {
            System.out.println("No First Name");
        }

        try {
            name = name + " " + contactInformation.getMiddleName();
        } catch (Exception e) {
            System.out.println("No Middle Name");
        }

        try {
            name = name + " " + contactInformation.getLastName();
        } catch (Exception e) {
            System.out.println("No Last Name");
        }

        try {
            name = name + " (" + contactInformation.getNickname() + ")";
        } catch (Exception e) {
            System.out.println("No Nickname");
        }

        return name;
    }



}