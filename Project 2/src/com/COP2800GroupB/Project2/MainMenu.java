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
    public static void mainMenu(){

        //Buttons to display
        String[] buttons = {"Cancel", "Edit", "Add", "Display"};

        //display buttons and prompt
        int selection = JOptionPane.showOptionDialog(null,
                "Select a Tool",
                "programTitle",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[0]);
        ////////////////////////////
        System.out.print("Selection = " + selection + "\n");

        selection(selection);
    }

    //Call selected tool
    public static void selection(int selection){

        switch (selection){
            case 0:
                System.exit(0);
                break;
            case 1:
                Edit.displayMenu();
                break;
            case 2:
                Add.displayMenu();
                break;
            case 3:
                Display.displayMenu();
                break;
        }
    }
}
