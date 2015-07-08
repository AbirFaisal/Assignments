package com.COP2805C.AddressBook.Contacts;

import javafx.scene.image.Image;

import java.time.LocalDate;
import java.time.chrono.Chronology;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by abirfaisal on 6/13/15.
 */
public class ContactInformation {

    //Key from the database

    private int key;
    private String group;

    private Image profileImage;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickname;

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String zip;

    private String notes;

    private ArrayList<String> phoneNumbers = new ArrayList<>();
    private ArrayList<String> emails = new ArrayList<>();
    private ArrayList<String> workPlaces = new ArrayList<>();

    private LocalDate birthday;


    //TESTING Empty
    public ContactInformation() {
        this.key = 0;
    }

    public ContactInformation(
            int key, String group,
            Image profileImage,
            String firstName, String middleName, String lastName, String nickname,
            String addressLine1, String addressLine2,
            String city, String state, String zip, String country,
            String notes,
            ArrayList<String> phoneNumbers,
            ArrayList<String> emails,
            ArrayList<String> workPlaces,
            LocalDate birthday) {

        this.key = key;
        this.group = group;
        this.profileImage = profileImage;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.notes = notes;
        this.phoneNumbers = phoneNumbers;
        this.emails = emails;
        this.workPlaces = workPlaces;
        this.birthday = birthday;
    }


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Image getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Image profileImage) {
        this.profileImage = profileImage;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {return country;}

    public void setCountry(String country) {this.country = country;}

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(ArrayList<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }

    public ArrayList<String> getWorkPlaces() {
        return workPlaces;
    }

    public void setWorkPlaces(ArrayList<String> workPlaces) {
        this.workPlaces = workPlaces;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        try {
            this.birthday = LocalDate.parse(birthday);
        }catch (NullPointerException e){
            System.out.println("No birthdate date set");
        }finally {
            this.birthday = null;
        }

    }


}
