package com.COP2805C.AddressBook.UserInterface.ContactViewPane;

import com.COP2805C.AddressBook.Contacts.ContactInformation;

/*
 * Copyright (c) 2015
 * Abir Faisal
 * Chris Buruchian
 * Alex Truong-Mai
 * Will Herrin
 *
 * COP2805 Valencia College
 * Professor dsfasdfa
 */

public class ContactViewFactory {
    public static ContactAnchorPane contact(ContactInformation contactInformation) {
        return new ContactAnchorPane(contactInformation);
    }
}