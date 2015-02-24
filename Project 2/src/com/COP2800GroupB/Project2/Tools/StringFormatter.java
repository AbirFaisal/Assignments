package com.COP2800GroupB.Project2.Tools;

import com.COP2800GroupB.Project2.Company.Person;

/**
 * Created by abirfaisal on 2/23/15.
 */
public class StringFormatter {


    //TODO Add boolean for isEmployee and isManager
    public static String OnePerson(int index, Person[] array){

        //Person Fields
        //first middle and last name as name
        String name = "Name: \n" + getCombinedName(index, array) + "\n \n";
        String email = "Email: \n" + array[index].getEmail() + "\n \n";
        String phone = "Phone: \n" + array[index].getPhone() + "\n \n";

        //Employee Specific fields
        String payRate = "Hourly Pay Rate: \n" + array[index].getEmployee().getHourlyRate() + "\n \n";
        String position = "Position: \n" + array[index].getEmployee().getPosition() + "\n \n";

        //Manager Specific fields
        String department = "Department: \n" + array[index].getEmployee().getManager().getDepartment() + "\n \n";
        String title = "Title: \n" + array[index].getEmployee().getManager().getTitle() + "\n \n";

        //Address Fields
        String line1 = array[index].getAddress().getAddressLine1() + "\n";
        String line2 = array[index].getAddress().getAddressLine2() + "\n";
        String city = array[index].getAddress().getCity() + ", ";
        String state = array[index].getAddress().getState() + " ";
        String zip = array[index].getAddress().getZip() + "\n";
        String country = array[index].getAddress().getCountry() + "\n";

        //Address formatted from related strings created earlier
        String address =
                "Address: \n" +
                line1 +
                line2 +
                city +
                state +
                zip +
                country;

        //Change to concat
        //Details formatted from strings created earlier
        //TODO add manager and employee checking
        String details;

        details = name  +
        payRate +
        position +
        title +
        department +
        "Contact Information: \n \n" +
                phone +
                email +
                address;

        //return formatted details
        return details;
    }

    public static String getCombinedName(int index, Person[] array){

        //Window Title as name of person
        String name =
                array[index].getName().getFirst() + " " +
                array[index].getName().getMiddle() + " " +
                array[index].getName().getLast();

        return name;
    }
}
