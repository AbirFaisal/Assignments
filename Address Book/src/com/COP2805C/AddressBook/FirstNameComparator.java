package com.COP2805C.AddressBook;

import com.COP2805C.AddressBook.Contacts.ContactInformation;

import java.util.Comparator;

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