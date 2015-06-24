package com.COP2805C.AddressBook.UserInterface.ContactForms;

import com.COP2805C.AddressBook.Contacts.ContactInformation;

/**
 * Created by abirfaisal on 6/21/15.
 */
public class FormFactory {

    public Form getForm(ContactInformation contactInformation, String formType) {

        if (contactInformation == null) return null;
        if (formType == null) return null;

        if (formType.equalsIgnoreCase("ADD")) {
            return new AddContactForm(contactInformation);
        }

        if (formType.equalsIgnoreCase("EDIT")) {
            return new EditContactForm(contactInformation);
        }

        return null;
    }
}
