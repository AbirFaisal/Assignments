package com.COP2805C.AddressBook.UserInterface.ContactForms;

import com.COP2805C.AddressBook.Contacts.ContactInformation;

/**
 * Created by abirfaisal on 6/21/15.
 */
public class ContactFormFactory {

    public ContactWindow contact(ContactInformation contactInformation) {
        return new ContactWindow(contactInformation);
    }
}
