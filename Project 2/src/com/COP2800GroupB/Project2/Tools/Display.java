package com.COP2800GroupB.Project2.Tools;

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
                Display.displayAllPeople();
                break;
        }
    }

    private static void displayAllPeople(){
    }

    private static void displayAllEmployees() {
    }

    private static void displayAllManagers() {
    }

    private static void displayOnePerson() {
    }

    private static void displayOneEmployee() {
    }

    private static void displayOneManager() {
    }


}
