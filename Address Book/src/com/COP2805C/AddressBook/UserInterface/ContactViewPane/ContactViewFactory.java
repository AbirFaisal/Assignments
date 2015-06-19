package com.COP2805C.AddressBook.UserInterface.ContactViewPane;

import com.COP2805C.AddressBook.Contacts.ContactInformation;

/**
 * Created by abirfaisal on 6/12/15.
 */
public class ContactViewFactory {
    public ContactAnchorPane contact(ContactInformation contactInformation) {
        return new ContactAnchorPane(contactInformation);
    }
}