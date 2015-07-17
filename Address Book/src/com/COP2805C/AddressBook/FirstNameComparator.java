package com.COP2805C.AddressBook;

import com.COP2805C.AddressBook.Contacts.ContactInformation;

import java.util.Comparator;

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

/**
 * Created by EpiphX on 7/15/15.
 */
//Sorting Comparator for firstName
public class FirstNameComparator implements Comparator<ContactInformation> {
    @Override
    public int compare(ContactInformation o1, ContactInformation o2) {
        return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
    }
}