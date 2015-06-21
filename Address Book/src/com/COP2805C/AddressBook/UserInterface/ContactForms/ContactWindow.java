package com.COP2805C.AddressBook.UserInterface.ContactForms;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by abirfaisal on 6/21/15.
 */
public class ContactWindow implements ContactForm {

    ContactInformation contactInformation;

    public ContactWindow(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }


    @Override
    public Stage contactForm() {
        return null;
    }


    public void addContact(String args){

    }

    public void editContact(String args){


    }


}
