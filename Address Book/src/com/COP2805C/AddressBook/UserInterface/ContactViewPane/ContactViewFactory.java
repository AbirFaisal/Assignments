package com.COP2805C.AddressBook.UserInterface.ContactViewPane;

import com.COP2805C.AddressBook.Contacts.ContactInformation;

public class ContactViewFactory {
    public static ContactAnchorPane contact(ContactInformation contactInformation) {
        return new ContactAnchorPane(contactInformation);
    }
}