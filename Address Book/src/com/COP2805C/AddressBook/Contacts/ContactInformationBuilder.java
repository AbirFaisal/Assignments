package com.COP2805C.AddressBook.Contacts;

import com.COP2805C.AddressBook.Main;

/**
 * Created by abirfaisal on 6/19/15.
 */
public class ContactInformationBuilder {

    public ContactInformation prepareContact(int CONTACT_ID){
        ContactInformation contact = new ContactInformation();
        contact.setKey(CONTACT_ID);
        contact.setGroup(Main.getDatabase().getGroup(CONTACT_ID, "GROUP_ASSC"));
        contact.setFirstName(Main.getDatabase().getFName(CONTACT_ID, "F_NAME"));
        contact.setMiddleName(Main.getDatabase().getMName(CONTACT_ID, "M_NAME"));
        contact.setLastName(Main.getDatabase().getLName(CONTACT_ID, "L_NAME"));
        contact.setNickname(Main.getDatabase().getNName(CONTACT_ID, "N_NAME"));
        contact.setAddressLine1(Main.getDatabase().getAddress1(CONTACT_ID,"ADDRESSLINE1"));
        contact.setAddressLine2(Main.getDatabase().getAddress2(CONTACT_ID,"ADDRESSLINE2"));
        contact.setCity(Main.getDatabase().getCity(CONTACT_ID,"CITY"));
        contact.setZip(Main.getDatabase().getZIP(CONTACT_ID,"ZIP"));
        contact.setState(Main.getDatabase().getState(CONTACT_ID,"STATE"));
        contact.setCountry(Main.getDatabase().getCountry(CONTACT_ID,"COUNTRY"));
        contact.setNotes(Main.getDatabase().getNotes(CONTACT_ID,"NOTES"));
        contact.setBirthday(Main.getDatabase().getDOB(CONTACT_ID));
        contact.setProfileImage(Main.getDatabase().getPicture(CONTACT_ID));
        contact.setEmails(Main.getDatabase().getDynamicData(CONTACT_ID,"EMAIL"));
        contact.setPhoneNumbers(Main.getDatabase().getDynamicData(CONTACT_ID,"PHONE_NUMBER"));
        contact.setWorkPlaces(Main.getDatabase().getDynamicData(CONTACT_ID,"WORK_PLACE"));
        return contact;
    }
}
