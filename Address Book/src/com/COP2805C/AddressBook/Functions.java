package com.COP2805C.AddressBook;

import com.COP2805C.AddressBook.Database.Database;
import com.COP2805C.AddressBook.UserInterface.CreateAccountWindow;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by abirfaisal on 5/28/15.
 */
public class Functions {

    public static void createAccount(String[] credentials, Database database){
        do {
            //Get new account information
            credentials = CreateAccountWindow.createAccount();

            //Prompt user if account already exists
            if (database.doesUserExist(credentials)) {
                JOptionPane.showMessageDialog(null, "User already Exists");
            }else { //create account and break the loop
                database.addAccount(credentials);
                break;
            }
            //Keep asking if user inputs existing username
        } while (database.doesUserExist(credentials));
    }




    public static boolean isPasswordStrong(String username, String password){

        if (password.contains(username)){
            JOptionPane.showMessageDialog(null, "Password cannot contain the username");
            return false;
        }

        if (password.length() < 5){
            //TODO remove
            System.out.println(password);
            JOptionPane.showMessageDialog(null, "Your password must be at least 6 characters long");
            return false;
        }

        if (!password.matches(".*\\d+.*")){
            JOptionPane.showMessageDialog(null, "Your password must contain at a number");
            return false;
        }

        //TODO this isn't working
        if (password.matches("([a-z\\d])\\1\\1\\1")){
            JOptionPane.showMessageDialog(null, "Your password cannot have more than 3 identical characters in a row");
            return false;
        }

        return true;
    }
}