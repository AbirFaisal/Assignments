package com.COP2800GroupB.Project2.Tools;

import com.COP2800GroupB.Project2.Company.Person;
import com.COP2800GroupB.Project2.Main;
import com.COP2800GroupB.Project2.MainMenu;

import javax.swing.*;

/**
 * Created by abirfaisal on 2/13/15.
 */
public class Display {


    public static void displayMenu(Person[] array) {


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
        selection(selection, array);

    }

    //Call selected tool
    public static void selection(int selection, Person[] array){

        switch (selection){
            case 0:
                //Exit Program
                Main.confirmExit(array);
                break;
            case 1:
                //Return to Main Menu
                MainMenu.displayMenu(array);
                break;
            case 2:
                Display.displayOneManager();
                break;
            case 3:
                Display.displayOneEmployee();
                break;
            case 4:
                //Display.displayOnePerson(0);
                break;
            case 5:
                Display.displayAllManagers();
                break;
            case 6:
                Display.displayAllEmployees();
                break;
            case 7:
                Display.displayAllPeople(array);
                break;
        }
    }

    public static void displayAllPeople(Person[] array){
        //Buttons to display
        String[] buttons = {
                "Cancel",
                "Return",
                "View"};


        String[] tempStrArray = new String[array.length];

        for (int i = 0; i < array.length; i++) {

            String tempStr = new String();

            tempStr = array[i].getName().getFirst() + " " +
                    array[i].getName().getMiddle() + " " +
                    array[i].getName().getLast();

            tempStrArray[i] = tempStr;
        }

        // Create JList with string array
        JList list = new JList(tempStrArray);

        JScrollPane scrollPane = new JScrollPane(list);


        //display buttons and prompt
        int selection = JOptionPane.showOptionDialog(null,
                scrollPane,
                "People",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[0]);

        int index = list.getSelectedIndex();

        System.out.print("Index: " + index);

        displayOnePerson(index, array);


    }

    public static void displayAllEmployees() {
    }

    public static void displayAllManagers() {
    }

    public static void displayOnePerson(int index, Person[] array) {


        //Buttons to display
        String[] buttons = {
                "Cancel",
                "Return",
                "Add",
                "Edit"};

        String windowTitle = array[index].getName().getFirst() + " " +
                array[index].getName().getMiddle() + " " +
                array[index].getName().getLast();

        String firstName = array[index].getName().getFirst();
        String middleName = array[index].getName().getMiddle();
        String lastName = array[index].getName().getLast();

        String email = array[index].getEmail();
        String phone = array[index].getPhone();

        String payRate = array[index].getEmployee().getHourlyRate();
        String position = array[index].getEmployee().getPosition();

        String department = array[index].getEmployee().getManager().getDepartment();
        String title = array[index].getEmployee().getManager().getTitle();

        String line1 = array[index].getAddress().getAddressLine1();
        String line2 = array[index].getAddress().getAddressLine2();
        String city = array[index].getAddress().getCity();
        String state = array[index].getAddress().getState();
        String zip = array[index].getAddress().getZip();
        String country = array[index].getAddress().getCountry();



        String address ="\n" +
                line1 + "\n" +
                        line2 + "\n" +
                        city + ", " +
                        state + " " +
                        zip + "\n" +
                        country;






        String details =
                "First Name: " + firstName + "\n" +
                "Middle Name: " + middleName + "\n" +
                "Last Name: " + lastName + "\n" +

                "Phone: " + phone + "\n" +
                "Email: " + email + "\n" +

                "Hourly Pay Rate: " + payRate + "\n" +

                "Position: " + position + "\n" +

                "Title: " + title + "\n" +

                "Department: " + department + "\n" +


                "Address: " + address + "\n";





        JOptionPane.showOptionDialog(null,
                details + details,
                windowTitle,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[0]);




    }

    public static void displayOneEmployee() {
    }

    public static void displayOneManager() {
    }

    //sort in alphabetical order.
    public static void sortAZ(){

    }


}
