package com.COP2800GroupB.Project2;




import com.COP2800GroupB.Project2.Company.Person;
import com.COP2800GroupB.Project2.Tools.Display;

import javax.swing.*;





public class Main {



    protected static final int MAX_MANAGERS = 20;
    protected static final int MAX_EMPLOYEES = 100;
    protected static final int MAX_PERSONS = 500;

    public static void main(String[] args) {

        //Initialize database
        Person[] personDatabase = new Person[MAX_PERSONS - 1];

        //Initialize the array
        Initalize.initalizeRecords(personDatabase);

        //Display All People sent the method the database
        Display.displayAllPeople(personDatabase);
    }





    //Exit Confirmation
    public static void confirmExit(Person[] array){

        //Buttons to display
        String[] buttons = {
                "Return",   //index 0
                "Exit"};    //index 1

        //display buttons and prompt
        int selection = JOptionPane.showOptionDialog(
                null,                               //Component parentComponent
                "Are you sure you want to exit?",   //String / Object message
                "Exit?",                            //String Title
                JOptionPane.DEFAULT_OPTION,         //int optionType
                JOptionPane.QUESTION_MESSAGE,       //int messageType
                null,                               //Icon
                buttons,                            //Object[] options
                buttons[0]);                        //Start from portion
        ////////////////////////////


        //Exit or return
        switch (selection){
            case 0:
                //Return
                //Pass array back
                Display.displayAllPeople(array);
                break;
            case 1:
                //Exit
                System.exit(0);
                break;
        }
    }
}