package com.COP2805C.AddressBook.UserInterface.ContactForms;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import javafx.scene.Scene;

/**
 * Created by abirfaisal on 6/23/15.
 */
public class EditContactForm implements Form {

    ContactInformation contactInformation;

    public EditContactForm(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    @Override
    public Scene contactForm() {
        return null;
    }
}
