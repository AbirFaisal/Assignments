package com.COP2805C.AddressBook.UserInterface.ContactForms;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import javafx.stage.Stage;

/**
 * Created by abirfaisal on 6/21/15.
 */
public class FormFactory {

    public Form getForm(ContactInformation contactInformation, String formType, Stage stage) {

        if (contactInformation == null) return null;
        if (formType == null) return null;

        if (formType.equalsIgnoreCase("ADD")) {
            return new AddContactForm(contactInformation, stage);
        }

        if (formType.equalsIgnoreCase("EDIT")) {
            return new EditContactForm(contactInformation, stage);
        }

        return null;
    }
}
