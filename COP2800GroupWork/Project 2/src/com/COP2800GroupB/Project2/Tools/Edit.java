/*
 * *
 *  * Project Name: Project 2
 *  * Class Name: Edit
 *  *
 *  * Created by David, Nicholas, Abir, Will, Brian on 3/1/15 10:48 PM
 *
 */

package com.COP2800GroupB.Project2.Tools;



import com.COP2800GroupB.Project2.Company.Person;
import com.COP2800GroupB.Project2.Main;
import com.COP2800GroupB.Project2.ObjectLimiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

class Edit {

    public static void editRecord(int index, Person[] array) {


        //Text field dimensions
        Dimension fieldDimensions = new Dimension(250, 24);


        //Create new form panel with Box Layout along y axis
        //This will store the window contents
        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));


        //Create JPanel
        JPanel firstName = new JPanel();
        firstName.setLayout(new FlowLayout());

        JLabel firstNameLabel = new JLabel("First Name: ", JLabel.TRAILING);

        firstName.add(firstNameLabel);

        //First Name Field and set text
        JTextField firstNameField = new JTextField(array[index].getName().getFirst());

        firstNameField.setPreferredSize(fieldDimensions);

        firstNameLabel.setLabelFor(firstNameField);

        firstName.add(firstNameField);

        form.add(firstName);


        //Create JPanel
        JPanel middleName = new JPanel();
        middleName.setLayout(new FlowLayout());

        //Middle Name Label
        JLabel middleNameLabel = new JLabel("Middle Name: ", JLabel.TRAILING);
        middleName.add(middleNameLabel);
        //Middle Name Field and set text
        JTextField middleNameField = new JTextField(array[index].getName().getMiddle());
        middleNameField.setPreferredSize(fieldDimensions);
        middleNameLabel.setLabelFor(middleNameField);
        middleName.add(middleNameField);
        //add middleName JPanel to form JPanel
        form.add(middleName);


        //Create JPanel
        JPanel lastName = new JPanel();
        lastName.setLayout(new FlowLayout());

        //First Name Label
        JLabel lastNameLabel = new JLabel("Last Name: ", JLabel.TRAILING);
        lastName.add(lastNameLabel);
        //Middle Name Field and set text
        JTextField lastNameField = new JTextField(array[index].getName().getLast());
        lastNameField.setPreferredSize(fieldDimensions);
        lastNameLabel.setLabelFor(lastNameField);
        lastName.add(lastNameField);

        form.add(lastName);


        //Create JPanel
        JPanel phone = new JPanel();
        phone.setLayout(new FlowLayout());

        //Phone Number Label
        JLabel phoneLabel = new JLabel("Phone Number: ", JLabel.TRAILING);
        phone.add(phoneLabel);
        //Phone Number Field and set text
        JTextField phoneField = new JTextField(array[index].getPhone());
        phoneField.setPreferredSize(fieldDimensions);
        phoneLabel.setLabelFor(phoneField);
        phone.add(phoneField);

        form.add(phone);


        //Create JPanel
        JPanel email = new JPanel();
        email.setLayout(new FlowLayout());

        //Email Label
        JLabel emailLabel = new JLabel("E-Mail: ", JLabel.TRAILING);
        email.add(emailLabel);
        //Email Field and set text
        JTextField emailField = new JTextField(array[index].getEmail());
        emailField.setPreferredSize(fieldDimensions);
        emailLabel.setLabelFor(emailField);
        email.add(emailField);

        form.add(email);


        ///////////Employee radio jpanel///////////////


        //Create JPanel
        JPanel employeeRadio = new JPanel();
        employeeRadio.setLayout(new FlowLayout());

        //is employee label
        JLabel isEmployeeLabel = new JLabel("Employee", JLabel.TRAILING);
        employeeRadio.add(isEmployeeLabel);


        //yes radio button
        final JRadioButton isEmployeeRadioYes = new JRadioButton("yes", array[index].getEmployee().isEmployee());
        isEmployeeLabel.setLabelFor(isEmployeeRadioYes);
        employeeRadio.add(isEmployeeRadioYes);

        //no radio button
        final JRadioButton isEmployeeRadioNo = new JRadioButton("No", !array[index].getEmployee().isEmployee());
        isEmployeeLabel.setLabelFor(isEmployeeRadioNo);
        employeeRadio.add(isEmployeeRadioNo);


        //Employee radio button logic
        isEmployeeRadioYes.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    isEmployeeRadioNo.setSelected(false);
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    isEmployeeRadioNo.setSelected(true);
                }
            }
        });

        isEmployeeRadioNo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    isEmployeeRadioYes.setSelected(false);
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
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


        //date selection date panel//////////////////////////////////////////////////////////
        //Create JPanel

        JPanel dateHired = new JPanel();
        dateHired.setLayout(new FlowLayout());


        //Dropdown menu for month hired
        JLabel monthLabel = new JLabel("Month: ", JLabel.TRAILING);
        dateHired.add(monthLabel);
        String[] monthChoice = {
                "January",  //0
                "February", //1
                "March",    //2
                "April",    //3
                "May",      //4
                "June",     //5
                "July",     //6
                "August",   //7
                "September",//8
                "October",  //9
                "November", //10
                "December"};//11


        //Create month combo box
        JComboBox month = new JComboBox();
        //Create combo box entries
        for (String aMonthChoice : monthChoice) {
            month.addItem(aMonthChoice);
        }
        //Get and set month
        month.setSelectedIndex(array[index].getEmployee().getDateHired().getMonth());
        //Add Combobox to JPanel
        dateHired.add(month);


        //Create month combo box
        JLabel dayLabel = new JLabel("Day: ", JLabel.TRAILING);
        dateHired.add(dayLabel);
        //Create combo box entries
        JComboBox day = new JComboBox();
        for (int i = 1; i <= 31; i++) {
            day.addItem(i);
        }
        //Get and set day
        day.setSelectedIndex(array[index].getEmployee().getDateHired().getDay());

        //Add Combobox to JPanel
        dateHired.add(day);


        //Dropdown menu for year hired
        JLabel yearLabel = new JLabel("Year: ", JLabel.TRAILING);
        dateHired.add(yearLabel);
        JComboBox year = new JComboBox();

        Calendar tempDate = Calendar.getInstance();

        int min_year = 1970;
        int max_year = tempDate.get(Calendar.YEAR);

        for (int i = min_year; i <= max_year; i++) {
            year.addItem(i);
        }

        //Get and set year
        year.setSelectedIndex(array[index].getEmployee().getDateHired().getYear() - min_year);

        //Add Combobox to JPanel
        dateHired.add(year);

        //Add JPanel to JPanel
        form.add(dateHired);

        ///////////////////////////////////////////////////////////////////////////////////////

        //hourly Pay name JPanel
        JPanel hourlyPay = new JPanel();
        hourlyPay.setLayout(new FlowLayout());

        //Hourly Pay Rate Label
        JLabel hrPayRateLabel = new JLabel("Hourly Pay Rate: ", JLabel.TRAILING);
        hourlyPay.add(hrPayRateLabel);
        //Hourly Pay Rate Field and set text
        JTextField hrPayRateField = new JTextField(array[index].getEmployee().getHourlyRate());
        hrPayRateField.setPreferredSize(fieldDimensions);
        hrPayRateLabel.setLabelFor(hrPayRateField);
        hourlyPay.add(hrPayRateField);

        //Add JPanel to JPanel
        form.add(hourlyPay);


        //middle name JPanel
        JPanel postion = new JPanel();
        postion.setLayout(new FlowLayout());

        //Position Label
        JLabel positionLabel = new JLabel("Position: ", JLabel.TRAILING);
        postion.add(positionLabel);
        //Position Field and set text
        JTextField positionField = new JTextField(array[index].getEmployee().getPosition());
        positionField.setPreferredSize(fieldDimensions);
        positionLabel.setLabelFor(positionField);
        postion.add(positionField);

        //Add JPanel to JPanel
        form.add(postion);


        //Add manager radio

        //add radio button

        JPanel managerRadio = new JPanel();
        managerRadio.setLayout(new FlowLayout());

        JLabel isManagerLabel = new JLabel("Manager", JLabel.TRAILING);
        managerRadio.add(isManagerLabel);


        final JRadioButton isManagerRadioYes = new JRadioButton("yes", array[index].getEmployee().getManager().isManager());
        isManagerLabel.setLabelFor(isManagerRadioYes);
        managerRadio.add(isManagerRadioYes);


        final JRadioButton isManagerRadioNo = new JRadioButton("No", !array[index].getEmployee().getManager().isManager());
        isManagerLabel.setLabelFor(isManagerRadioNo);
        managerRadio.add(isManagerRadioNo);


        //Manager radio button logic
        isManagerRadioYes.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    isManagerRadioNo.setSelected(false);
                    isEmployeeRadioYes.setSelected(true);
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    isManagerRadioNo.setSelected(true);
                }
            }
        });

        isManagerRadioNo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    isManagerRadioYes.setSelected(false);
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
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
        JTextField titleField = new JTextField(array[index].getEmployee().getManager().getTitle());
        titleField.setPreferredSize(fieldDimensions);
        titleLabel.setLabelFor(titleField);
        title.add(titleField);

        //Add JPanel to JPanel
        form.add(title);


        JPanel department = new JPanel();
        department.setLayout(new FlowLayout());

        //Department Label
        JLabel departmentLabel = new JLabel("Department: ", JLabel.TRAILING);
        department.add(departmentLabel);
        //Department Field and set text
        JTextField departmentField = new JTextField(array[index].getEmployee().getManager().getDepartment());
        departmentField.setPreferredSize(fieldDimensions);
        departmentLabel.setLabelFor(departmentField);
        department.add(departmentField);

        //Add JPanel to JPanel
        form.add(department);


        //////////////////////// Address Label ////////////////////////////////


        JPanel line1 = new JPanel();
        line1.setLayout(new FlowLayout());


        //Address Line 1 Label
        JLabel line1Label = new JLabel("Address Line 1: ", JLabel.TRAILING);
        line1.add(line1Label);
        //Address Line 2 Field and set text
        JTextField line1Field = new JTextField(array[index].getAddress().getAddressLine1());
        line1Field.setPreferredSize(fieldDimensions);
        line1Label.setLabelFor(line1Field);
        line1.add(line1Field);

        //Add JPanel to JPanel
        form.add(line1);


        JPanel line2 = new JPanel();
        line2.setLayout(new FlowLayout());

        //Address Line 2 Label
        JLabel line2Label = new JLabel("Address Line 2: ", JLabel.TRAILING);
        line2.add(line2Label);
        //Address Line 2 Field and set text
        JTextField line2Field = new JTextField(array[index].getAddress().getAddressLine2());
        line2Field.setPreferredSize(fieldDimensions);
        line2Label.setLabelFor(line2Field);
        line2.add(line2Field);

        //Add JPanel to JPanel
        form.add(line2);


        JPanel city = new JPanel();
        city.setLayout(new FlowLayout());

        //City Label
        JLabel cityLabel = new JLabel("City: ", JLabel.TRAILING);
        city.add(cityLabel);
        //City Field and set text
        JTextField cityField = new JTextField(array[index].getAddress().getCity());
        cityField.setPreferredSize(fieldDimensions);
        cityLabel.setLabelFor(cityField);
        city.add(cityField);

        //Add JPanel to JPanel
        form.add(city);


        JPanel state = new JPanel();
        state.setLayout(new FlowLayout());

        //State Label
        JLabel stateLabel = new JLabel("State: ", JLabel.TRAILING);
        state.add(stateLabel);
        //State Field and set text
        JTextField stateField = new JTextField(array[index].getAddress().getState());
        stateField.setPreferredSize(fieldDimensions);
        stateLabel.setLabelFor(stateField);
        state.add(stateField);

        //Add JPanel to JPanel
        form.add(state);


        JPanel zip = new JPanel();
        zip.setLayout(new FlowLayout());

        //Zip Label
        JLabel zipLabel = new JLabel("Zip: ", JLabel.TRAILING);
        zip.add(zipLabel);
        //Department Field and set text
        JTextField zipField = new JTextField(array[index].getAddress().getZip());
        zipField.setPreferredSize(fieldDimensions);
        zipLabel.setLabelFor(zipField);
        zip.add(zipField);

        //Add JPanel to JPanel
        form.add(zip);


        JPanel country = new JPanel();
        country.setLayout(new FlowLayout());

        //Country Label
        JLabel countryLabel = new JLabel("Country: ", JLabel.TRAILING);
        country.add(countryLabel);
        //Department Field and set text
        JTextField countryField = new JTextField(array[index].getAddress().getCountry());
        countryField.setPreferredSize(fieldDimensions);
        countryLabel.setLabelFor(countryField);
        country.add(countryField);

        //Add JPanel to JPanel
        form.add(country);


        //Buttons to display
        String[] buttons = {
                "Cancel",
                "Discard & Return",
                "Save"};

        //Create window title
        String windowTitle = "Editing: " + StringFormatter.getCombinedName(index, array);

        //display buttons and prompt
        int selection = JOptionPane.showOptionDialog(
                null,
                form,
                windowTitle,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                buttons,
                buttons[0]);

        ////////////////////////////



        //radio buttons to true false


        switch (selection) {
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

                //set date Hired
                //set month
                array[index].getEmployee().getDateHired().setMonth(
                        month.getSelectedIndex());
                //set day
                array[index].getEmployee().getDateHired().setDay(
                        day.getSelectedIndex());
                //set year
                array[index].getEmployee().getDateHired().setYear(
                        year.getSelectedIndex() + min_year);


                //Set Name in persondatabase
                //set
                array[index].getName().setFirst(
                        firstNameField.getText());
                array[index].getName().setMiddle(
                        middleNameField.getText());
                array[index].getName().setLast(
                        lastNameField.getText());

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


                //set date modified
                array[index].getDate().setMonth(Calendar.MONTH);
                array[index].getDate().setDay(Calendar.DAY_OF_MONTH);
                array[index].getDate().setYear(Calendar.YEAR);


                //Go back to display all people
                Display.displayAllPeople(array);

                break;
        }
    }
}
