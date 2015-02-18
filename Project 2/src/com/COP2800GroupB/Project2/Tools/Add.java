package com.COP2800GroupB.Project2.Tools;

import com.COP2800GroupB.Project2.Company.Person;

import javax.swing.*;

/**
 * Created by abirfaisal on 2/13/15.
 */
public class Add {


    //Display tools
    public static void displayMenu(Person[] array){

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
        //selection(selection, array);
    }



    public static void addPerson(int index, Person[] array){


        //Buttons to display
        String[] buttons = {
                "Cancel",
                "Discard & Return",
                "Save"};

        
        //Create new form panel with Box Layout along y axis
        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));


        //First Name Label and field
        JLabel firstNameLabel = new JLabel("First Name: ", JLabel.TRAILING);
        form.add(firstNameLabel);

        JTextField firstNameField  = new JTextField();
        firstNameLabel.setLabelFor(firstNameField);
        form.add(firstNameField);

        //Middle Name Label and field
        JLabel middleNameLabel = new JLabel("Middle Name: ", JLabel.TRAILING);
        form.add(middleNameLabel);

        JTextField middleNameField  = new JTextField();
        firstNameLabel.setLabelFor(middleNameField);
        form.add(middleNameField);

        //First Name Label and field
        JLabel lastNameLabel = new JLabel("Last Name: ", JLabel.TRAILING);
        form.add(lastNameLabel);

        JTextField lastNameField  = new JTextField();
        lastNameLabel.setLabelFor(lastNameField);
        form.add(lastNameField);


        //Phone Number Label and field
        JLabel phoneLabel = new JLabel("Phone Number: ", JLabel.TRAILING);
        form.add(phoneLabel);

        //Phone Number Field
        JTextField phoneField  = new JTextField();
        phoneLabel.setLabelFor(phoneField);
        form.add(phoneField);

        //Phone Number Label and field
        JLabel phoneLabel = new JLabel("Phone Number: ", JLabel.TRAILING);
        form.add(phoneLabel);

        //Phone Number Field
        JTextField phoneField  = new JTextField();
        phoneLabel.setLabelFor(phoneField);
        form.add(phoneField);










        //display buttons and prompt
        int selection = JOptionPane.showOptionDialog(null,
                form,
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
        //selection(selection, array);


    }



}
