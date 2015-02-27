package com.COP2800GroupB.Project2.Tools;

import com.COP2800GroupB.Project2.Company.Person;
import com.COP2800GroupB.Project2.Main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by abirfaisal on 2/13/15.
 */
public class Edit {

    public static void editRecord(int index, Person[] array){

        //Create new form panel with Box Layout along y axis
        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));







        //First Name Label
        JPanel firstName = new JPanel();
        firstName.setLayout(new FlowLayout());

        JLabel firstNameLabel = new JLabel("First Name: ", JLabel.TRAILING);
        firstName.add(firstNameLabel);
        //First Name Field and set text
        JTextField firstNameField = new JTextField(array[index].getName().getFirst());

        firstNameField.setPreferredSize(new Dimension(250,32));

        firstNameLabel.setLabelFor(firstNameField);

        firstName.add(firstNameField);

        form.add(firstName);




        //middle name JPanel
        JPanel middleName = new JPanel();
        middleName.setLayout(new FlowLayout());

        //Middle Name Label
        JLabel middleNameLabel = new JLabel("Middle Name: ", JLabel.TRAILING);
        middleName.add(middleNameLabel);
        //Middle Name Field and set text
        JTextField middleNameField  = new JTextField(array[index].getName().getMiddle());
        middleNameField.setPreferredSize(new Dimension(250,32));
        middleNameLabel.setLabelFor(middleNameField);
        middleName.add(middleNameField);
        //add middleName JPanel to form JPanel
        form.add(middleName);






        //middle name JPanel
        JPanel lastName = new JPanel();
        lastName.setLayout(new FlowLayout());

        //First Name Label
        JLabel lastNameLabel = new JLabel("Last Name: ", JLabel.TRAILING);
        lastName.add(lastNameLabel);
        //Middle Name Field and set text
        JTextField lastNameField  = new JTextField(array[index].getName().getLast());
        lastNameField.setPreferredSize(new Dimension(250,32));
        lastNameLabel.setLabelFor(lastNameField);
        lastName.add(lastNameField);

        form.add(lastName);







        //middle name JPanel
        JPanel phone = new JPanel();
        phone.setLayout(new FlowLayout());

        //Phone Number Label
        JLabel phoneLabel = new JLabel("Phone Number: ", JLabel.TRAILING);
        phone.add(phoneLabel);
        //Phone Number Field and set text
        JTextField phoneField  = new JTextField(array[index].getPhone());
        phoneField.setPreferredSize(new Dimension(250, 32));
        phoneLabel.setLabelFor(phoneField);
        phone.add(phoneField);

        form.add(phone);




        //emal name JPanel
        JPanel email = new JPanel();
        email.setLayout(new FlowLayout());

        //Email Label
        JLabel emailLabel = new JLabel("E-Mail: ", JLabel.TRAILING);
        email.add(emailLabel);
        //Email Field and set text
        JTextField emailField  = new JTextField(array[index].getEmail());
        emailField.setPreferredSize(new Dimension(250,32));
        emailLabel.setLabelFor(emailField);
        email.add(emailField);

        form.add(email);





        //add radio button


        JPanel employeeRadio = new JPanel();
        employeeRadio.setLayout(new FlowLayout());

        //is employee label
        JLabel isEmployeeLabel = new JLabel("Employee", JLabel.TRAILING);
        employeeRadio.add(isEmployeeLabel);

        //yes radio button
        JRadioButton isEmployeeRadioYes = new JRadioButton("yes",array[index].getEmployee().isEmployee());
        isEmployeeLabel.setLabelFor(isEmployeeRadioYes);
        employeeRadio.add(isEmployeeRadioYes);

        //no radio button
        JRadioButton isEmployeeRadioNo = new JRadioButton("No",!array[index].getEmployee().isEmployee());
        isEmployeeLabel.setLabelFor(isEmployeeRadioNo);
        employeeRadio.add(isEmployeeRadioNo);

        form.add(employeeRadio);












        //middle name JPanel
        JPanel hourlyPay = new JPanel();
        hourlyPay.setLayout(new FlowLayout());

        //Hourly Pay Rate Label
        JLabel hrPayRateLabel = new JLabel("Hourly Pay Rate: ", JLabel.TRAILING);
        hourlyPay.add(hrPayRateLabel);
        //Hourly Pay Rate Field and set text
        JTextField hrPayRateField  = new JTextField(array[index].getEmployee().getHourlyRate());
        hrPayRateField.setPreferredSize(new Dimension(250,32));
        hrPayRateLabel.setLabelFor(hrPayRateField);
        hourlyPay.add(hrPayRateField);




        //middle name JPanel
        JPanel postion = new JPanel();
        postion.setLayout(new FlowLayout());

        //Position Label
        JLabel positionLabel = new JLabel("Position: ", JLabel.TRAILING);
        postion.add(positionLabel);
        //Position Field and set text
        JTextField positionField  = new JTextField(array[index].getEmployee().getPosition());
        positionField.setPreferredSize(new Dimension(250,32));
        positionLabel.setLabelFor(positionField);
        postion.add(positionField);

        form.add(postion);




        //Add manager radio

        //add radio button

        JPanel managerRadio = new JPanel();
        managerRadio.setLayout(new FlowLayout());

        JLabel isManagerLabel = new JLabel("Manager", JLabel.TRAILING);
        managerRadio.add(isManagerLabel);


        JRadioButton isManagerRadioYes = new JRadioButton("yes",array[index].getEmployee().getManager().isManager());
        isManagerLabel.setLabelFor(isManagerRadioYes);
        managerRadio.add(isManagerRadioYes);


        JRadioButton isManagerRadioNo = new JRadioButton("No",!array[index].getEmployee().getManager().isManager());
        isManagerLabel.setLabelFor(isManagerRadioNo);
        managerRadio.add(isManagerRadioNo);

        form.add(managerRadio);







        JPanel title = new JPanel();
        title.setLayout(new FlowLayout());

        //Title Label
        JLabel titleLabel = new JLabel("Title: ", JLabel.TRAILING);
        title.add(titleLabel);
        //Title Field and set text
        JTextField titleField  = new JTextField(array[index].getEmployee().getManager().getTitle());
        titleField.setPreferredSize(new Dimension(250,32));
        titleLabel.setLabelFor(titleField);
        title.add(titleField);


        form.add(title);




        JPanel department = new JPanel();
        department.setLayout(new FlowLayout());

        //Department Label
        JLabel departmentLabel = new JLabel("Department: ", JLabel.TRAILING);
        department.add(departmentLabel);
        //Department Field and set text
        JTextField departmentField  = new JTextField(array[index].getEmployee().getManager().getDepartment());
        departmentField.setPreferredSize(new Dimension(250,32));
        departmentLabel.setLabelFor(departmentField);
        department.add(departmentField);


        form.add(department);



        //////////////////////// Address Label ////////////////////////////////




        //Address Line 1 Label
        JLabel line1Label = new JLabel("Address Line 1: ", JLabel.TRAILING);
        form.add(line1Label);
        //Address Line 2 Field and set text
        JTextField line1Field  = new JTextField(array[index].getAddress().getAddressLine1());
        line1Label.setLabelFor(line1Field);
        form.add(line1Field);

        //Address Line 2 Label
        JLabel line2Label = new JLabel("Address Line 2: ", JLabel.TRAILING);
        form.add(line2Label);
        //Address Line 2 Field and set text
        JTextField line2Field  = new JTextField(array[index].getAddress().getAddressLine2());
        line2Label.setLabelFor(line2Field);
        form.add(line2Field);

        //City Label
        JLabel cityLabel = new JLabel("City: ", JLabel.TRAILING);
        form.add(cityLabel);
        //City Field and set text
        JTextField cityField  = new JTextField(array[index].getAddress().getCity());
        cityLabel.setLabelFor(cityField);
        form.add(cityField);

        //State Label
        JLabel stateLabel = new JLabel("State: ", JLabel.TRAILING);
        form.add(stateLabel);
        //State Field and set text
        JTextField stateField  = new JTextField(array[index].getAddress().getState());
        stateLabel.setLabelFor(stateField);
        form.add(stateField);

        //Zip Label
        JLabel zipLabel = new JLabel("Zip: ", JLabel.TRAILING);
        form.add(zipLabel);
        //Department Field and set text
        JTextField zipField  = new JTextField(array[index].getAddress().getZip());
        zipLabel.setLabelFor(zipField);
        form.add(zipField);

        //Country Label
        JLabel countryLabel = new JLabel("Country: ", JLabel.TRAILING);
        form.add(countryLabel);
        //Department Field and set text
        JTextField countryField  = new JTextField(array[index].getAddress().getCountry());
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

                //set date record
                //array[index].getDat

                Display.displayAllPeople(array);
                break;
        }
    }



}
