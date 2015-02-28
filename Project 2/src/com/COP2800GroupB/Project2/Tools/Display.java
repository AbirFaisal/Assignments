package com.COP2800GroupB.Project2.Tools;

import com.COP2800GroupB.Project2.Company.Person;
import com.COP2800GroupB.Project2.Main;

import javax.swing.*;
import java.awt.*;


/**
 * Created by abirfaisal on 2/13/15.
 */


public class Display {


    public static void displayAllPeople(Person[] array){



        //String array to hold concat'd name string
        String[] tempStrArray = new String[array.length];


        //loop to initalize tempStrArray
        for (int i = 0; i < array.length; i++) {

            //create string to temporarily store string
            String tempStr;

            //temp string = first middle and last name combined
            tempStr = array[i].getName().getFirst() + " " +
                    array[i].getName().getMiddle() + " " +
                    array[i].getName().getLast();

            //assignd concat'd name to array
            tempStrArray[i] = tempStr;
        }

        // Create JList with string array
        JList list = new JList(tempStrArray);

        //Auto select first record
        list.setSelectedIndex(0);

        //Create new JScrollPane with JList list
        JScrollPane scrollPane = new JScrollPane(list);

        //Dimension the scroll pane praportional to
        scrollPane.setPreferredSize(new Dimension((array.length*2/3),array.length));


        //Buttons to display
        String[] buttons = {
                "Cancel",
                "View Record",
        "View Employees",
        "View Managers"};


        //display buttons and prompt
        int selection = JOptionPane.showOptionDialog(null,
                scrollPane,
                "All Records",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                buttons,
                buttons[0]);

        //set index to current List selection
        int index = list.getSelectedIndex();

        System.out.print("Selection: " + selection);
        System.out.print("Index: " + index);



        switch (selection){
            case 0:
                Main.confirmExit(array);
                break;
            case 1:
                Display.displayOnePerson(index, array);
                break;
            case 2:
                Display.displayAllEmployees(array);
                break;
            case 3:
                Display.displayAllManagers(array);
                break;

        }

    }//end of displayAllPeople


    //TODO add isEmployee Checking
    public static void displayAllEmployees(Person[] array) {

        //String array to hold concat'd name string
        String[] tempStrArray = new String[array.length];

            //create string to temporarily store string
            String tempStr;


        int arrayComphensator = 0;



            //loop to initalize tempStrArray

        for (int i = 0; i < array.length; i++) {
            if (array[i].getEmployee().getManager().isManager()) {
                //temp string = first middle and last name combined
                tempStr =
                        array[i].getName().getFirst() + " " +
                                array[i].getName().getMiddle() + " " +
                                array[i].getName().getLast();


                //assignd concat'd name to array
                tempStrArray[i] = tempStr;
            }else{
                arrayComphensator++;
            }
        }//end of for



        // Create JList with string array
        JList list = new JList(tempStrArray);

        //Auto select first record
        list.setSelectedIndex(0);

        //Create new JScrollPane with JList list
        JScrollPane scrollPane = new JScrollPane(list);

        //Dimension the scroll pane praportional to
        scrollPane.setPreferredSize(new Dimension((array.length*2/3),array.length));


        //Buttons to display
        String[] buttons = {
                "Cancel",
                "View",
            "Return"};


        //display buttons and prompt
        int selection = JOptionPane.showOptionDialog(null,
                scrollPane,
                "Employee Records",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                buttons,
                buttons[0]);

        //set index to current List selection
        int index = list.getSelectedIndex();

        System.out.print("Selection: " + selection);
        System.out.print("Index: " + index);



        switch (selection){
            case 0:
                Main.confirmExit(array);
                break;
            case 1:
                Display.displayOnePerson(index+arrayComphensator-1, array);
                break;
            case 2:
            Display.displayAllPeople(array);
            break;
        }//end of switch

    }//end of displayAllEmployees

    public static void displayAllManagers(Person[] array ) {
        //String array to hold concat'd name string
        String[] tempStrArray = new String[array.length];

        //create string to temporarily store string
        String tempStr;

        int arrayComphensator = 0;


        //loop to initalize tempStrArray
        for (int i = 0; i < array.length; i++) {


            if (array[i].getEmployee().getManager().isManager()) {
                //temp string = first middle and last name combined
                tempStr =
                        array[i].getName().getFirst() + " " +
                                array[i].getName().getMiddle() + " " +
                                array[i].getName().getLast();


                //assignd concat'd name to array
                tempStrArray[i] = tempStr;
            }else{
                arrayComphensator++;
            }


        }//end of for





        // Create JList with string array
        JList list = new JList(tempStrArray);

        //Auto select first record
        list.setSelectedIndex(0);

        //Create new JScrollPane with JList list
        JScrollPane scrollPane = new JScrollPane(list);

        //Dimension the scroll pane praportional to
        scrollPane.setPreferredSize(
                new Dimension(
                        (array.length*2/3),
                        array.length)
        );


        //Buttons to display
        String[] buttons = {
                "Cancel",
                "View",
                "Return"};


        //display buttons and prompt
        int selection = JOptionPane.showOptionDialog(null,
                scrollPane,
                "Manager Records",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                buttons,
                buttons[0]);

        //set index to current List selection
        int index = list.getSelectedIndex();

        System.out.print("Selection: " + selection);
        System.out.print("Index: " + index);



        switch (selection){
            case 0:
                Main.confirmExit(array);
                break;
            case 1:
                Display.displayOnePerson(index+arrayComphensator-1, array);
                break;
            case 2:
                Display.displayAllPeople(array);
                break;
        }//end of switch

    }//end of displayAllManagers

    public static void displayOnePerson(int index, Person[] array) {

        //Get person details
        String details = StringFormatter.OnePerson(index, array);

        //Create person details
        String windowTitle = StringFormatter.getCombinedName(index, array);

        //Buttons to display
        String[] buttons = {
                "Cancel",
                "Return",
                "Clear / Add",
                "Edit"};


        //display data and get selection if button press
        int selection = JOptionPane.showOptionDialog(null,
                details,
                windowTitle,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                buttons,
                buttons[0]);

        switch (selection){
            case 0:
                //cancel
                Main.confirmExit(array);
                break;
            case 1:
                //return
                Display.displayAllPeople(array);
                break;
            case 2:
                Add.addPerson(index, array);
                break;
            case 3:
                Edit.editRecord(index, array);
                break;
        }
    }


    //sort in alphabetical order.
    public static void sortAZ(){

    }


}//end of Display class
