/*
 * *
 *  * Project Name: Project 2
 *  * Class Name: Main
 *  *
 *  * Created by David, Nicholas, Abir, Will, Brian on 3/1/15 10:48 PM
 *
 */

package com.COP2800GroupB.Project2;


import com.COP2800GroupB.Project2.Company.Person;
import com.COP2800GroupB.Project2.Tools.Display;

import javax.swing.*;


public class Main {


    protected static final int MAX_MANAGERS = 20;
    protected static final int MAX_EMPLOYEES = 100;
    public static final int MAX_PERSONS = 500;

    public static void main(String[] args) {

        //Initialize database
        Person[] personDatabase = new Person[MAX_PERSONS - 1];

        //Initialize the array
        Initialize.initializeRecords(personDatabase);

        //Display All People sent the method the database
        Display.displayAllPeople(personDatabase);
    }


    //Exit Confirmation
    public static void confirmExit(Person[] array) {

        //display buttons and prompt
        int selection = JOptionPane.showConfirmDialog(
                null,                               //Component parentComponent
                "Are you sure you want to exit?",   //String  Object message
                "Exit?",                            //String  Title
                JOptionPane.YES_NO_OPTION,          //Message Options
                JOptionPane.QUESTION_MESSAGE);      //Message Type
        ////////////////////////////


        //Exit or return
        switch (selection) {
            case 0:
                //Exit
                System.exit(0);
                break;
            case 1:
                //Return
                //Pass array back
                Display.displayAllPeople(array);
                break;
        }
    }
}