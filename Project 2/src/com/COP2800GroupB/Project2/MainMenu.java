package com.COP2800GroupB.Project2;

import com.COP2800GroupB.Project2.Tools.Add;
import com.COP2800GroupB.Project2.Tools.Display;
import com.COP2800GroupB.Project2.Tools.Edit;

import javax.swing.*;

/**
 * Created by abirfaisal on 2/17/15.
 */
public class MainMenu {


    //Display tools
    public static void displayMenu(){

        //Buttons to display
        String[] buttons = {"Cancel", "Edit", "Add", "Display"};

        //display buttons and prompt
        int selection = JOptionPane.showOptionDialog(null,
                "Select a Tool",
                "Group B Project 2",
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

        //switch statement to call methods
        switch (selection){
            case 0:
                //Exit Program
                Main.confirmExit();
                break;
            case 1:
                //Call Edit Menu
                Edit.displayMenu();
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
}