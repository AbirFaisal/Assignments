package com.COP2805C.AddressBook.UserInterface.ContactViewPane;

import com.COP2805C.AddressBook.Contacts.ContactInformation;

/*
 * Copyright (c) 2015
 * Alex Truong-Mai
 * Will Herrin
 * Chris Buruchian
 * Abir Faisal
 *
 * COP2805C Valencia College
 * Professor Jeho Park
 */

public class ContactViewFactory {
    public static ContactAnchorPane contact(ContactInformation contactInformation) {
        return new ContactAnchorPane(contactInformation);
    }
}