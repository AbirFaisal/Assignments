package com.COP2800GroupB.Project2.Tools;



import com.COP2800GroupB.Project2.Company.Person;
import com.COP2800GroupB.Project2.Main;

import javax.swing.*;
import java.awt.*;

public class Display {


    //Display all people unsorted
    public static void displayAllPeople(Person[] array) {


        //String array to hold concat'd name string
        String[] tempStrArray = new String[array.length];


        //loop to initalize tempStrArray
        for (int i = 0; i < array.length; i++) {

            //create string to temporarily store string
            String tempStr;

            //temp string = first middle and last name combined
            tempStr = StringFormatter.getCombinedName(i, array);


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
        scrollPane.setPreferredSize(new Dimension((array.length * 2 / 3), array.length));


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


        switch (selection) {
            case 0:
                //Cancel
                Main.confirmExit(array);
                break;
            case 1:
                //View Record
                Display.displayOnePerson(index, array);
                break;
            case 2:
                //View Employees
                Display.displayAllEmployees(array);
                break;
            case 3:
                //View Managers sorted Z-A
                Display.displayAllManagers(array);
                break;
        }
    }


    //Display all Employees
    private static void displayAllEmployees(Person[] array) {

        //String array to hold concat'd name string
        String[] strArray = new String[array.length];


        //create string to temporarily store string
        String tempStr;


        //Sort A-Z
        sortAZ(array);


        //loop to initialize tempStrArray
        for (int i = 0; i < array.length; i++) {

            //Test if isEmployee
            if (array[i].getEmployee().isEmployee()) {

                //temp string = first middle and last name combined
                tempStr = StringFormatter.getCombinedName(i, array);

                //assignd concat'd name to array
                strArray[i] = tempStr;
            }
        }


        // Create JList with string array
        JList list = new JList(strArray);

        //Auto select first record
        list.setSelectedIndex(0);

        //Create new JScrollPane with JList list
        JScrollPane scrollPane = new JScrollPane(list);

        //Dimension the scroll pane praportional to
        scrollPane.setPreferredSize(new Dimension(strArray.length, strArray.length));


        //Buttons to display
        String[] buttons = {
                "Cancel",
                "View"};


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


        switch (selection) {
            case 0:
                //Cancel
                Display.displayAllPeople(array);
                break;
            case 1:
                //View Record
                Display.displayOnePerson(index, array); //+ arrayCompensator
                break;
        }
    }


    //Display All Managers
    private static void displayAllManagers(Person[] array) {
        //String array to hold concat'd name string
        String[] strArray = new String[array.length];

        //create string to temporarily store string
        String tempStr;

        //Sort Z-A
        sortZA(array);


        //loop to initalize tempStrArray
        for (int i = 0; i < array.length; i++) {


            //Test if isManager
            if (array[i].getEmployee().getManager().isManager()) {

                //temp string = first middle and last name combined
                tempStr = StringFormatter.getCombinedName(i, array);

                //assignd concat'd name to array
                strArray[i] = tempStr;
            }
        }


        // Create JList with string array
        JList list = new JList(strArray);

        //Auto select first record
        list.setSelectedIndex(0);

        //Create new JScrollPane with JList list
        JScrollPane scrollPane = new JScrollPane(list);

        //Dimension the scroll pane proportional to array
        scrollPane.setPreferredSize(
                new Dimension(array.length, array.length));


        //Buttons to display
        String[] buttons = {
                "Cancel",
                "View",};


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


        switch (selection) {
            case 0:
                //Cancel
                Display.displayAllPeople(array);
                break;
            case 1:
                //View Record
                Display.displayOnePerson(index, array);
                break;

        }
    }

    private static void displayOnePerson(int index, Person[] array) {

        //Get person details
        String details = StringFormatter.OnePerson(index, array);

        //Create person details
        String windowTitle = StringFormatter.getCombinedName(index, array);

        //Buttons to display
        String[] buttons = {
                "Cancel",
                "Clear / Add",
                "Edit"};


        //display data and get selection if button press
        int selection = JOptionPane.showOptionDialog(
                null,
                details,
                windowTitle,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                buttons,
                buttons[0]);

        switch (selection) {
            case 0:
                //cancel
                Display.displayAllPeople(array);
                break;
            case 1:
                Add.addPerson(index, array);
                break;
            case 2:
                Edit.editRecord(index, array);
                break;
        }
    }


    //Bubble sort in alphabetical order.
    private static void sortAZ(Person[] array) {


        //Hold temp string
        Person temp;


        //Move empty records to bottom
        sortEmpty(array);


        // Counter j here because if we put a deceleration
        // in a loop it wil create a new variable every time
        // it runs so to save memory we declare it once here.
        // Java garbage collection takes care of it anyways
        // but that is unnecessarily expensive.
        int j;


        //Holds Previous element
        String elementA;
        char a;


        //Holds current element
        String elementB;
        char b;


        //Sort A-Z
        //Times to run through array
        for (int i = 0; i < (array.length - 1); i++) {

            //Run through array
            for (j = 1; j < (array.length - 1); j++) {

                //Previous Element
                elementA = array[j - 1].getName().getFirst();
                a = elementA.charAt(0);

                //Current Element
                elementB = array[j].getName().getFirst();
                b = elementB.charAt(0);


                //Test if char A is greater than char B
                if (a > b) {
                    //Swap elements
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }


        //Move empty records to bottom
        sortEmpty(array);
    }


    //Bubble sort in alphabetical order. Descending
    private static void sortZA(Person[] array) {


        //Hold temp string
        Person temp;


        //Move empty records to bottom
        sortEmpty(array);


        // Counter j here because if we put a deceleration
        // in a loop it wil create a new variable every time
        // it runs so to save memory we declare it once here.
        // Java garbage collection takes care of it anyways
        // but that is unnecessarily expensive.
        int j;


        //Holds Previous element
        String elementA;
        char a;


        //Holds current element
        String elementB;
        char b;


        //Sort A-Z
        //Times to run through array
        for (int i = 0; i < (array.length - 1); i++) {

            //Run through array
            for (j = 1; j < (array.length - 1); j++) {


                //Previous Element
                elementA = array[j - 1].getName().getFirst();
                a = elementA.charAt(0);

                //Current Element
                elementB = array[j].getName().getFirst();
                b = elementB.charAt(0);


                //Test if char A is less than char B
                if (a < b) {
                    //Swap elements
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        //Move empty records to bottom
        sortEmpty(array);
    }


    //Moves empty records to bottom
    private static void sortEmpty(Person[] array) {


        //Hold temp string
        Person temp;


        //hold element
        String element;


        // Counter j here because if we put a deceleration
        // in a loop it wil create a new variable every time
        // it runs so to save memory we declare it once here.
        // Java garbage collection takes care of it anyways
        // but that is unnecessarily expensive.
        int j;


        //Move empty records to bottom
        //Times to run through array
        for (int i = 0; i < (array.length - 1); i++) {


            //Run through array
            for (j = 1; j < (array.length - 1); j++) {

                //Get Previous Element
                element = array[j - 1].getName().getFirst();


                //Test if element equals "Empty" or ""
                if (element.equals("Empty") || element.equals("")) {

                    //Swap previous array element with current element
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
