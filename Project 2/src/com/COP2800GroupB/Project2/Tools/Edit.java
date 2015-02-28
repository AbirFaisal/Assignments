package com.COP2800GroupB.Project2.Tools;

import com.COP2800GroupB.Project2.Company.Person;
import com.COP2800GroupB.Project2.Main;
import com.COP2800GroupB.Project2.ObjectLimiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by abirfaisal on 2/13/15.
 */
public class Edit {

    public static void editRecord(int index, Person[] array){



        //Text field dimentions
        Dimension fieldDimentions = new Dimension(250,24);


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

        firstNameField.setPreferredSize(fieldDimentions);

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
        middleNameField.setPreferredSize(fieldDimentions);
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
        lastNameField.setPreferredSize(fieldDimentions);
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
        phoneField.setPreferredSize(fieldDimentions);
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
        emailField.setPreferredSize(fieldDimentions);
        emailLabel.setLabelFor(emailField);
        email.add(emailField);

        form.add(email);



        ///////////Employee radio jpanel///////////////


        //add radio button JPanel
        JPanel employeeRadio = new JPanel();
        employeeRadio.setLayout(new FlowLayout());

        //is employee label
        JLabel isEmployeeLabel = new JLabel("Employee", JLabel.TRAILING);
        employeeRadio.add(isEmployeeLabel);


        //yes radio button
        final JRadioButton isEmployeeRadioYes = new JRadioButton("yes",array[index].getEmployee().isEmployee());
        isEmployeeLabel.setLabelFor(isEmployeeRadioYes);
        employeeRadio.add(isEmployeeRadioYes);

        //no radio button
        final JRadioButton isEmployeeRadioNo = new JRadioButton("No",!array[index].getEmployee().isEmployee());
        isEmployeeLabel.setLabelFor(isEmployeeRadioNo);
        employeeRadio.add(isEmployeeRadioNo);


        isEmployeeRadioYes.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    isEmployeeRadioNo.setSelected(false);
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    isEmployeeRadioNo.setSelected(true);
                }
            }
        });

        isEmployeeRadioNo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    isEmployeeRadioYes.setSelected(false);
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    isEmployeeRadioYes.setSelected(true);
                }
            }
        });




        //Date hired label
        JLabel dateLabel = new JLabel("as of:", JLabel.TRAILING);

        employeeRadio.add(dateLabel);

        //add jpanel employee radio to
        form.add(employeeRadio);

        //Employee radio jpanel /////////////////


        JPanel dateHired = new JPanel();
        dateHired.setLayout(new FlowLayout());



        //Dropdown menu for month hired
        JLabel monthLabel = new JLabel("Month: ", JLabel.TRAILING);
        dateHired.add(monthLabel);
        String[] monthChoice = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};


        JComboBox month = new JComboBox();
        for (int i = 0; i < monthChoice.length; i++) {
            month.addItem(monthChoice[i]);
        }
        dateHired.add(month);



        //Dropdown menu for day hired
        JLabel dayLabel = new JLabel("Day: ", JLabel.TRAILING);
        dateHired.add(dayLabel);
        JComboBox day = new JComboBox();
        for (int i = 1; i <= 31; i++) {
            day.addItem(i);
        }
        dateHired.add(day);




        //Dropdown menu for year hired
        JLabel yearLabel = new JLabel("Year: ", JLabel.TRAILING);
        dateHired.add(yearLabel);
        JComboBox year = new JComboBox();
        for (int i = 1970; i <= 2015; i++) {
            year.addItem(i);
        }


        dateHired.add(year);


        form.add(dateHired);






        //middle name JPanel
        JPanel hourlyPay = new JPanel();
        hourlyPay.setLayout(new FlowLayout());

        //Hourly Pay Rate Label
        JLabel hrPayRateLabel = new JLabel("Hourly Pay Rate: ", JLabel.TRAILING);
        hourlyPay.add(hrPayRateLabel);
        //Hourly Pay Rate Field and set text
        JTextField hrPayRateField  = new JTextField(array[index].getEmployee().getHourlyRate());
        hrPayRateField.setPreferredSize(fieldDimentions);
        hrPayRateLabel.setLabelFor(hrPayRateField);
        hourlyPay.add(hrPayRateField);

        form.add(hourlyPay);




        //middle name JPanel
        JPanel postion = new JPanel();
        postion.setLayout(new FlowLayout());

        //Position Label
        JLabel positionLabel = new JLabel("Position: ", JLabel.TRAILING);
        postion.add(positionLabel);
        //Position Field and set text
        JTextField positionField  = new JTextField(array[index].getEmployee().getPosition());
        positionField.setPreferredSize(fieldDimentions);
        positionLabel.setLabelFor(positionField);
        postion.add(positionField);

        form.add(postion);




        //Add manager radio

        //add radio button

        JPanel managerRadio = new JPanel();
        managerRadio.setLayout(new FlowLayout());

        JLabel isManagerLabel = new JLabel("Manager", JLabel.TRAILING);
        managerRadio.add(isManagerLabel);


        final JRadioButton isManagerRadioYes = new JRadioButton("yes",array[index].getEmployee().getManager().isManager());
        isManagerLabel.setLabelFor(isManagerRadioYes);
        managerRadio.add(isManagerRadioYes);


        final JRadioButton isManagerRadioNo = new JRadioButton("No",!array[index].getEmployee().getManager().isManager());
        isManagerLabel.setLabelFor(isManagerRadioNo);
        managerRadio.add(isManagerRadioNo);


        isManagerRadioYes.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    isManagerRadioNo.setSelected(false);
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    isManagerRadioNo.setSelected(true);
                }
            }
        });

        isManagerRadioNo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    isManagerRadioYes.setSelected(false);
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    isManagerRadioYes.setSelected(true);
                }
            }
        });


        //add
        form.add(managerRadio);

        JPanel title = new JPanel();
        title.setLayout(new FlowLayout());

        //Title Label
        JLabel titleLabel = new JLabel("Title: ", JLabel.TRAILING);
        title.add(titleLabel);
        //Title Field and set text
        JTextField titleField  = new JTextField(array[index].getEmployee().getManager().getTitle());
        titleField.setPreferredSize(fieldDimentions);
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
        departmentField.setPreferredSize(fieldDimentions);
        departmentLabel.setLabelFor(departmentField);
        department.add(departmentField);


        form.add(department);



        //////////////////////// Address Label ////////////////////////////////


        JPanel line1 = new JPanel();
        line1.setLayout(new FlowLayout());


        //Address Line 1 Label
        JLabel line1Label = new JLabel("Address Line 1: ", JLabel.TRAILING);
        line1.add(line1Label);
        //Address Line 2 Field and set text
        JTextField line1Field  = new JTextField(array[index].getAddress().getAddressLine1());
        line1Field.setPreferredSize(fieldDimentions);
        line1Label.setLabelFor(line1Field);
        line1.add(line1Field);


        form.add(line1);



        JPanel line2 = new JPanel();
        line2.setLayout(new FlowLayout());

        //Address Line 2 Label
        JLabel line2Label = new JLabel("Address Line 2: ", JLabel.TRAILING);
        line2.add(line2Label);
        //Address Line 2 Field and set text
        JTextField line2Field  = new JTextField(array[index].getAddress().getAddressLine2());
        line2Field.setPreferredSize(fieldDimentions);
        line2Label.setLabelFor(line2Field);
        line2.add(line2Field);

        form.add(line2);




        JPanel city = new JPanel();
        city.setLayout(new FlowLayout());

        //City Label
        JLabel cityLabel = new JLabel("City: ", JLabel.TRAILING);
        city.add(cityLabel);
        //City Field and set text
        JTextField cityField  = new JTextField(array[index].getAddress().getCity());
        cityField.setPreferredSize(fieldDimentions);
        cityLabel.setLabelFor(cityField);
        city.add(cityField);

        form.add(city);





        JPanel state = new JPanel();
        state.setLayout(new FlowLayout());

        //State Label
        JLabel stateLabel = new JLabel("State: ", JLabel.TRAILING);
        state.add(stateLabel);
        //State Field and set text
        JTextField stateField  = new JTextField(array[index].getAddress().getState());
        stateField.setPreferredSize(fieldDimentions);
        stateLabel.setLabelFor(stateField);
        state.add(stateField);

        form.add(state);


        JPanel zip = new JPanel();
        zip.setLayout(new FlowLayout());

        //Zip Label
        JLabel zipLabel = new JLabel("Zip: ", JLabel.TRAILING);
        zip.add(zipLabel);
        //Department Field and set text
        JTextField zipField  = new JTextField(array[index].getAddress().getZip());
        zipField.setPreferredSize(fieldDimentions);
        zipLabel.setLabelFor(zipField);
        zip.add(zipField);

        form.add(zip);


        JPanel country = new JPanel();
        country.setLayout(new FlowLayout());

        //Country Label
        JLabel countryLabel = new JLabel("Country: ", JLabel.TRAILING);
        country.add(countryLabel);
        //Department Field and set text
        JTextField countryField  = new JTextField(array[index].getAddress().getCountry());
        countryField.setPreferredSize(fieldDimentions);
        countryLabel.setLabelFor(countryField);
        country.add(countryField);

        form.add(country);




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



        //radio buttons to true false


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
                //check and set radio buttons
                ObjectLimiter.limitObject(
                        isEmployeeRadioYes.isSelected(),
                        isManagerRadioYes.isSelected(),
                        array,
                        index);


                }

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

        }
    }
