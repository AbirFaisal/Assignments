package com.COP2800GroupB.Project2.Tools;

import com.COP2800GroupB.Project2.Company.Person;
import com.COP2800GroupB.Project2.Main;

import javax.swing.*;

/**
 * Created by abirfaisal on 2/13/15.
 */
public class Add {

    public static void addPerson(int index, Person[] array){
        
        //Create new form panel with Box Layout along y axis
        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));

        //First Name Label
        JLabel firstNameLabel = new JLabel("First Name: ", JLabel.TRAILING);
        form.add(firstNameLabel);
        //First Name Field
        JTextField firstNameField  = new JTextField();
        firstNameLabel.setLabelFor(firstNameField);
        form.add(firstNameField);

        //Middle Name Label
        JLabel middleNameLabel = new JLabel("Middle Name: ", JLabel.TRAILING);
        form.add(middleNameLabel);
        //Middle Name Field
        JTextField middleNameField  = new JTextField();
        firstNameLabel.setLabelFor(middleNameField);
        form.add(middleNameField);

        //First Name Label
        JLabel lastNameLabel = new JLabel("Last Name: ", JLabel.TRAILING);
        form.add(lastNameLabel);
        //Middle Name Field
        JTextField lastNameField  = new JTextField();
        lastNameLabel.setLabelFor(lastNameField);
        form.add(lastNameField);

        //Phone Number Label
        JLabel phoneLabel = new JLabel("Phone Number: ", JLabel.TRAILING);
        form.add(phoneLabel);
        //Phone Number Field
        JTextField phoneField  = new JTextField();
        phoneLabel.setLabelFor(phoneField);
        form.add(phoneField);

        //Email Label
        JLabel emailLabel = new JLabel("E-Mail: ", JLabel.TRAILING);
        form.add(emailLabel);
        //Email Field
        JTextField emailField  = new JTextField();
        emailLabel.setLabelFor(emailField);
        form.add(emailField);

        //Hourly Pay Rate Label
        JLabel hrPayRateLabel = new JLabel("Hourly Pay Rate: ", JLabel.TRAILING);
        form.add(hrPayRateLabel);
        //Hourly Pay Rate Field
        JTextField hrPayRateField  = new JTextField();
        hrPayRateLabel.setLabelFor(hrPayRateField);
        form.add(hrPayRateField);

        //Position Label
        JLabel positionLabel = new JLabel("Position: ", JLabel.TRAILING);
        form.add(positionLabel);
        //Position Field
        JTextField positionField  = new JTextField();
        positionLabel.setLabelFor(positionField);
        form.add(positionField);

        //Title Label
        JLabel titleLabel = new JLabel("Title: ", JLabel.TRAILING);
        form.add(titleLabel);
        //Title Field
        JTextField titleField  = new JTextField();
        titleLabel.setLabelFor(titleField);
        form.add(titleField);

        //Department Label
        JLabel departmentLabel = new JLabel("Department: ", JLabel.TRAILING);
        form.add(departmentLabel);
        //Department Field
        JTextField departmentField  = new JTextField();
        departmentLabel.setLabelFor(departmentField);
        form.add(departmentField);

        //////////////////////// Address Label ////////////////////////////////

        //Address Line 1 Label
        JLabel line1Label = new JLabel("Address Line 1: ", JLabel.TRAILING);
        form.add(line1Label);
        //Address Line 2 Field
        JTextField line1Field  = new JTextField();
        line1Label.setLabelFor(line1Field);
        form.add(line1Field);

        //Address Line 2 Label
        JLabel line2Label = new JLabel("Address Line 2: ", JLabel.TRAILING);
        form.add(line2Label);
        //Address Line 2 Field
        JTextField line2Field  = new JTextField();
        line2Label.setLabelFor(line2Field);
        form.add(line2Field);

        //City Label
        JLabel cityLabel = new JLabel("City: ", JLabel.TRAILING);
        form.add(cityLabel);
        //City Field
        JTextField cityField  = new JTextField();
        cityLabel.setLabelFor(cityField);
        form.add(cityField);

        //State Label
        JLabel stateLabel = new JLabel("State: ", JLabel.TRAILING);
        form.add(stateLabel);
        //State Field
        JTextField stateField  = new JTextField();
        stateLabel.setLabelFor(stateField);
        form.add(stateField);

        //Zip Label
        JLabel zipLabel = new JLabel("Zip: ", JLabel.TRAILING);
        form.add(zipLabel);
        //Department Field
        JTextField zipField  = new JTextField();
        zipLabel.setLabelFor(zipField);
        form.add(zipField);

        //Country Label
        JLabel countryLabel = new JLabel("Country: ", JLabel.TRAILING);
        form.add(countryLabel);
        //Department Field
        JTextField countryField  = new JTextField();
        countryLabel.setLabelFor(countryField);
        form.add(countryField);

        //Buttons to display
        String[] buttons = {
                "Cancel",
                "Discard & Return",
                "Save"};

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


        switch (selection){
            case 0:
                //Cancel
                Main.confirmExit(array);
                break;
            case 1:
                //Discard and return
                Display.displayAllPeople(array);
                break;
            case 2:
                //Save and return
                //Set Name in persondatabase
                array[index].getName().setFirst(firstNameField.getText());
                array[index].getName().setMiddle(middleNameField.getText());
                array[index].getName().setLast(lastNameField.getText());

                //set phone
                array[index].setPhone(
                        //get phone field text
                        phoneField.getText());

                //set email
                array[index].setEmail(
                        //get email field text
                        emailField.getText());

                //set pay rate
                array[index].getEmployee().setHourlyRate(
                        hrPayRateField.getText());

                //set position
                array[index].getEmployee().setPosition(
                        //get position field text
                        positionField.getText());

                //set title
                array[index].getEmployee().getManager().setTitle(
                        //get title field text
                        titleField.getText());

                //set department
                array[index].getEmployee().getManager().setDepartment(
                        //get department field text
                        departmentField.getText());

                //set Address Line 1
                array[index].getAddress().setAddressLine1(
                        //get address line 1 text
                        line1Field.getText());

                //set Address Line 2
                array[index].getAddress().setAddressLine2(
                        //get address line 2 text
                        line2Field.getText());

                //set City
                array[index].getAddress().setCity(
                        //get city field text
                        cityField.getText());

                //set State
                array[index].getAddress().setState(
                        //get state field text
                        stateField.getText());

                //set Zip
                array[index].getAddress().setZip(
                        //get zip field text
                        zipField.getText());

                //set Country
                array[index].getAddress().setCountry(
                        //get country field text
                        countryField.getText());

                Display.displayAllPeople(array);
                break;
        }
    }
}
