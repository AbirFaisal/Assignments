package com.COP2805C.AddressBook.UserInterface.ContactForms;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/*
 * Copyright (c) 2015
 * Abir Faisal
 * Chris Buruchian
 * Alex Truong-Mai
 * Will Herrin
 *
 * COP2805 Valencia College
 * Professor Jeho Park
 */

public class EditContactForm extends AddContactForm implements Form {


    public EditContactForm(ContactInformation contactInformation, Stage stage) {
        super(contactInformation, stage);
    }

    @Override
    public Scene form() {
        super.form();

        //add static data labels and fields
        for (int i = 0; i < labelStrings.length; i++) {
            this.labels.add(label(this.labelStrings[i]));
            this.textFields.add(textField(this.labelStrings[i]));
        }

        addDynamicData(this.phoneGridPane, this.phoneTextFields, this.contactInformation.getPhoneNumbers());
        addDynamicData(this.emailGridPane, this.emailTextFields, this.contactInformation.getEmails());
        addDynamicData(this.workplacesGridPane, this.workplaceTextFields, this.contactInformation.getWorkPlaces());
        setContactFields();

        return this.scene;
    }


    private void addDynamicData(GridPane gridPane, ArrayList<TextField> textFields, ArrayList<String> field) {

        for (int i = 0; i < field.size(); i++) {
            textFields.add(
                    new TextField(
                            field.get(i)));

            gridPane.addRow(textFields.size(), textFields.get(textFields.size() - 1));
            gridPane.add(
                    removeButton(
                            gridPane, textFields, textFields.get(textFields.size() - 1)), 1, textFields.size());
        }
    }

    private void setContactFields() {
        setTextFields();
        setDOB();
    }

    private void setTextFields() {
        this.textFields.get(0).setText(contactInformation.getFirstName());
        this.textFields.get(1).setText(contactInformation.getMiddleName());
        this.textFields.get(2).setText(contactInformation.getLastName());
        this.textFields.get(3).setText(contactInformation.getNickname());
        this.textFields.get(4).setText(contactInformation.getAddressLine1());
        this.textFields.get(5).setText(contactInformation.getAddressLine2());
        this.textFields.get(6).setText(contactInformation.getCity());
        this.textFields.get(7).setText(contactInformation.getState());
        this.textFields.get(8).setText(contactInformation.getZip());
        this.textFields.get(9).setText(contactInformation.getCountry());
        this.notesTextArea.setText(contactInformation.getNotes());
    }

    private void setDOB() {
        try {
            this.birthDatePicker.setValue(contactInformation.getBirthday());
        } catch (NullPointerException ex) {
            System.out.println("No dob entered: " + ex);
        }
    }
}
