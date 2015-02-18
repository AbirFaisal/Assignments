package com.COP2800GroupB.Project2.Tools;

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
                MainMenu.mainMenu();
                break;
            case 2:
                System.exit(0);
                break;
            case 3:
                System.exit(0);
                break;
            case 4:
                System.exit(0);
                break;
            case 5:
                System.exit(0);
                break;

        }
    }
}
