package com.COP2800GroupB.Project2;

//


import com.COP2800GroupB.Project2.Company.*;

import javax.swing.*;

public class Main {





    //change these to definitions and make it accessable
    //from the entire program
    public final int MAX_MANAGERS = 20;
    public final int MAX_EMPLOYEES = 100;
    public final int MAX_PERSONS = 500;

    public static void main(String[] args) {

        //Initialize database
        Person[] personDatabase = new Person[500-1];

        //Initialize objects in personDatabase array
        for (int i = 0; i < personDatabase.length ; i++) {

            //create new name of Name type
            Name tempName = new Name("First","Middle","Last");

            //create new manager of Manager type
            Manager tempManager = new Manager(false, "title", "department");

            //create new employee of employe type
            Employee tempEmployee = new Employee("Position", "Rate", tempManager);

            //create new address of address type
            Address tempAddress = new Address("line1", "line2", "city", "state", "zip", "country");

            //create new person of Person type
            personDatabase[i] = new Person(tempName, "Email", "Phone", tempEmployee, tempAddress);
        }






        //Initalize.init();

        //Display mainMenu
        MainMenu.displayMenu(personDatabase);




    }

    //so we don't have to type so much

    public static void confirmExit(Person[] array){

        //Buttons to display
        String[] buttons = {"Return", "Exit"};

        //display buttons and prompt
        int selection = JOptionPane.showOptionDialog(null,
                "Are you sure you want to exit?",
                "Exit?",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[0]);
        ////////////////////////////

        //print selection value
        System.out.print(selection);

        //Exit or return
        switch (selection){
            case 0:
                MainMenu.displayMenu(array);
                break;
            case 1:
                System.exit(0);
                break;
        }
    }


}