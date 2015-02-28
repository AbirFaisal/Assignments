package com.COP2800GroupB.Project2;




import com.COP2800GroupB.Project2.Company.*;
import com.COP2800GroupB.Project2.Tools.Display;

import javax.swing.*;
import java.util.Calendar;

public class Main {


    //change these to definitions and make it accessible
    //from the entire program
    protected static final int MAX_MANAGERS = 20;
    protected static  final int MAX_EMPLOYEES = 100;
    protected  static final int MAX_PERSONS = 500;

    public static void main(String[] args) {

        //Initialize database
        Person[] personDatabase = new Person[MAX_PERSONS - 1];
        //Initialize objects in personDatabase array
        for (int i = 0; i < personDatabase.length; i++) {

            //sample data
            //create new name of Name type
            Name tempName = new Name("Abir","Ahmed","Faisal");

            //create new manager of Manager type
            Manager tempManager = new Manager(true, "manager", "title");

            Calendar tempCalendar = Calendar.getInstance();

            //tempCalendar

            //Create new a date of Date type
            Date tempDateHired = new Date(tempCalendar.get(Calendar.MONTH),tempCalendar.get(Calendar.DAY_OF_MONTH),tempCalendar.get(Calendar.YEAR));

            //create new employee of employee type
            Employee tempEmployee = new Employee(true,"position", "$15", tempManager, tempDateHired);

            //create new address of address type
            Address tempAddress = new Address("1234 street", "Line2", "Orlando", "FL", "23121", "USA");

            //add record creation date

            Date tempDate = new Date(tempCalendar.get(Calendar.MONTH),tempCalendar.get(Calendar.DAY_OF_MONTH),tempCalendar.get(Calendar.YEAR));

            //create new person of Person type
            personDatabase[i] = new Person(tempName, "abir@gmail.com", "561-232-3122", tempEmployee, tempAddress, tempDate);
        }

        //Display All People sent the method the database
        Display.displayAllPeople(personDatabase);
    }
    //Exit Confirmation
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
        System.out.print(selection + "\n");

        //Exit or return
        switch (selection){
            case 0:
                Display.displayAllPeople(array);
                break;
            case 1:
                System.exit(0);
                break;
        }
    }


}