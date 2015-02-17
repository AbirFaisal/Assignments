package com.COP2800GroupB.Project2.Company;

/**
 * Created by abirfaisal on 2/16/15.
 */
public class Address {

    String addressLine1;
    String addressLine2;
    String city;
    String state;
    String zip;
    String country;

    //Constructor


    public Address(String addressLine1, String addressLine2, String city, String state, String zip, String country) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }
}
