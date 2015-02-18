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
        //Buttons to display
        String[] buttons = {
                "Cancel",
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

        //Auto select first record
        list.setSelectedIndex(0);

        //Create new JScrollPane with JList list
        JScrollPane scrollPane = new JScrollPane(list);

        //Dimension the scroll pane praportional to
        scrollPane.setPreferredSize(new Dimension((array.length*2/3),array.length));

        //display buttons and prompt
        int selection = JOptionPane.showOptionDialog(null,
                scrollPane,
                "People",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
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
        }

    }

    //Call selected tool remove this later
    public static void selection(int selection, Person[] array, int index){

        switch (selection){
            case 0:
                //Exit Program
                Main.confirmExit(array);
                break;
            case 1:
                //Return to Main Menu
                //MainMenu.displayMenu(array);
                break;
            case 2:
                //Display.displayOneManager(index, array);
                break;
            case 3:
                //Display.displayOneEmployee(index, array);
                break;
            case 4:
                Display.displayOnePerson(index, array);
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



    public static void displayAllEmployees() {
    }

    public static void displayAllManagers() {
    }

    public static void displayOnePerson(int index, Person[] array) {


        //Buttons to display
        String[] buttons = {
                "Cancel",
                "Return",
                "Clear / Add",
                "Edit"};

        //Window Title as name of person
        String windowTitle = array[index].getName().getFirst() + " " +
                array[index].getName().getMiddle() + " " +
                array[index].getName().getLast();

        //first middle and last name as name
        String name = array[index].getName().getFirst() + " " +
                array[index].getName().getMiddle() + " " +
                array[index].getName().getLast();

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

        //address formatted
        String address ="\n" +
                        line1 + "\n" +
                        line2 + "\n" +
                        city + ", " +
                        state + " " +
                        zip + "\n" +
                        country;


        //Details formatted from strings created earlier
        String details =
                "Name: " + "\n" +
                        name + "\n \n" +

                "Phone: " + "\n" +
                        phone + "\n \n" +
                "Email: " + "\n" +
                        email + "\n \n" +

                "Hourly Pay Rate: " + "\n" +
                        payRate + "\n \n" +

                "Position: " + "\n" +
                        position + "\n \n" +

                "Title: " + "\n" +
                        title + "\n \n" +

                "Department: " + "\n" +
                        department + "\n \n" +

                "Address: " +
                        address + "\n";


        //display data and get selection if button press
        int selection = JOptionPane.showOptionDialog(null,
                details,
                windowTitle,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
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
            case 4:
                Edit.editRecord(index, array);
                break;
        }


    }


    //sort in alphabetical order.
    public static void sortAZ(){

    }


}
