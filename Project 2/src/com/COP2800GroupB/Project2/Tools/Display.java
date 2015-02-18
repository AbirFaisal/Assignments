package com.COP2800GroupB.Project2.Tools;

import com.COP2800GroupB.Project2.Company.Person;
import com.COP2800GroupB.Project2.Main;
import com.COP2800GroupB.Project2.MainMenu;

import javax.swing.*;

/**
 * Created by abirfaisal on 2/13/15.
 */
public class Display {


    public static void displayMenu() {


        //Buttons to display
        String[] buttons = {
                "Cancel",
                "Return",
                "Display One Manager",
                "Display One Employee",
                "Display One Person",
                "Display All Managers",
                "Display All Employees",
                "Display All People"};

        //display buttons and prompt
        int selection = JOptionPane.showOptionDialog(null,
                "Select a Tool",
                "Display Records",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[0]);
        ////////////////////////////

        //for debugging purposes
        System.out.print("Selection = " + selection + "\n");

        //Call selection method with selection value
        selection(selection);

    }

    //Call selected tool
    public static void selection(int selection){

        switch (selection){
            case 0:
                //Exit Program
                Main.confirmExit();
                break;
            case 1:
                //Return to Main Menu
                MainMenu.displayMenu();
                break;
            case 2:
                Display.displayOneManager();
                break;
            case 3:
                Display.displayOneEmployee();
                break;
            case 4:
                Display.displayOnePerson();
                break;
            case 5:
                Display.displayAllManagers();
                break;
            case 6:
                Display.displayAllEmployees();
                break;
            case 7:
                Display.displayAllPeople(null);
                break;
        }
    }

    public static void displayAllPeople(Person[] personDatabase){
        //Buttons to display
        String[] buttons = {
                "Cancel",
                "Return",
                "Add",
                "Edit"};

        //display buttons and prompt
        int selection = JOptionPane.showOptionDialog(null,
                new JScrollPane(),
                "People",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[0]);

    }

    public static void displayAllEmployees() {
    }

    public static void displayAllManagers() {
    }

    public static void displayOnePerson() {
    }

    public static void displayOneEmployee() {
    }

    public static void displayOneManager() {
    }

    //sort in alphabetical order.
    public static void sortAZ(){

    }


}
