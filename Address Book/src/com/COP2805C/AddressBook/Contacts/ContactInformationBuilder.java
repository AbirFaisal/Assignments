package com.COP2805C.AddressBook.Contacts;

import com.COP2805C.AddressBook.Main;

/**
 * Created by abirfaisal on 6/19/15.
 */
public class ContactInformationBuilder {

    public ContactInformation prepareContact(int CONTACT_ID){
        ContactInformation contact = new ContactInformation();
        contact.setKey(CONTACT_ID);
        contact.setGroup(Main.database.getGroup(CONTACT_ID,"GROUP_ASSC"));
        contact.setFirstName(Main.database.getFName(CONTACT_ID, "F_NAME"));
        contact.setMiddleName(Main.database.getMName(CONTACT_ID, "M_NAME"));
        contact.setLastName(Main.database.getLName(CONTACT_ID, "L_NAME"));
        contact.setNickname(Main.database.getNName(CONTACT_ID, "N_NAME"));
        contact.setAddressLine1(Main.database.getAddress1(CONTACT_ID,"ADDRESSLINE1"));
        contact.setAddressLine2(Main.database.getAddress2(CONTACT_ID,"ADDRESSLINE2"));
        contact.setCity(Main.database.getCity(CONTACT_ID,"CITY"));
        contact.setZip(Main.database.getZIP(CONTACT_ID,"ZIP"));
        contact.setState(Main.database.getState(CONTACT_ID,"STATE"));
        contact.setNotes(Main.database.getNotes(CONTACT_ID,"NOTES"));
        contact.setBirthday(Main.database.getDOB(CONTACT_ID));
        contact.setProfileImage(Main.database.getPicture(CONTACT_ID));
        contact.setEmails(Main.database.getDynamicData(CONTACT_ID,"EMAIL"));
        contact.setPhoneNumbers(Main.database.getDynamicData(CONTACT_ID,"PHONE_NUMBER"));
        contact.setWorkPlaces(Main.database.getDynamicData(CONTACT_ID,"WORK_PLACE"));
        return contact;
    }
}
