package com.GoupB;

import java.*;

public class Main {

    public static void main(String[] args) {

        //Display inital Menu
        int selection = displayMenu.mainMenu();

        // Somone put this in a class like mainSwitch.selection(selection)
        // send selection to the switch
        switch (selection){
            case 1:
                //call method
                break;
            case 2:
                //call method
                break:
            case 3:
                //call method
                break;
            case 4:
                //call method
                break;
            default:
                //error
                System.out.print("ERROR: selection can't be less than 1 or 4 \");
                System.exit(0);
                break;
        }

        System.out.print(selection); //Check value of slection

    }
}
