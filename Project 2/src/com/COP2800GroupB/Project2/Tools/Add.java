package com.COP2800GroupB.Project2.Tools;

import com.COP2800GroupB.Project2.Main;
import com.COP2800GroupB.Project2.MainMenu;

import javax.swing.*;

/**
 * Created by abirfaisal on 2/13/15.
 */
public class Add {


    //Display tools
    public static void displayMenu(){

        //Buttons to display
        String[] buttons = {
                "Cancel",
                "Return",
                "Add Employee",
                "Add Manager",
                "Add Person"};

        //display buttons and prompt
        int selection = JOptionPane.showOptionDialog(null,
                "Select a Tool",
                "Add Record",
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
    public static void selection(int selection) {

        switch (selection) {
            case 0:
                //Exit Program
                Main.confirmExit();
                break;
            case 1:
                //Call Edit Menu
                MainMenu.displayMenu();
                break;
            case 2:
                //Call Add Menu
                Add.displayMenu();
                break;
            case 3:
                //Call Display Menu
                Display.displayMenu();
                break;
        }
    }


    public static void addPerson(){


    }

    public static void addEmployee(){

    }

    public static void addManager(){

    }



}
