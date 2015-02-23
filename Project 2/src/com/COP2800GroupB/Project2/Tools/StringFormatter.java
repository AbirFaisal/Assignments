package com.COP2800GroupB.Project2.Tools;

import com.COP2800GroupB.Project2.Company.Person;

/**
 * Created by abirfaisal on 2/23/15.
 */
public class StringFormatter {


    public static String stringOnePerson(int index, Person[] array){
        
        //first middle and last name as name
        String name = array[index].getName().getFirst() + " " +
                array[index].getName().getMiddle() + " " +
                array[index].getName().getLast();

        String email = array[index].getEmail();
        String phone = array[index].getPhone();

        String payRate = array[index].getEmployee().getHourlyRate();
        String position = array[index].getEmployee().getPosition();

        String department = array[index].getEmployee().getManager().getDepartment();
        String title = array[index].getEmployee().getManager().getTitle();

        String line1 = array[index].getAddress().getAddressLine1();
        String line2 = array[index].getAddress().getAddressLine2();
        String city = array[index].getAddress().getCity();
        String state = array[index].getAddress().getState();
        String zip = array[index].getAddress().getZip();
        String country = array[index].getAddress().getCountry();

        //address formatted
        String address ="\n" +
                line1 + "\n" +
                line2 + "\n" +
                city + ", " +
                state + " " +
                zip + "\n" +
                country;


        //Details formatted from strings created earlier
        String details =
                "Name: " + "\n" +
                        name + "\n \n" +

                        "Phone: " + "\n" +
                        phone + "\n \n" +
                        "Email: " + "\n" +
                        email + "\n \n" +

                        "Hourly Pay Rate: " + "\n" +
                        payRate + "\n \n" +

                        "Position: " + "\n" +
                        position + "\n \n" +

                        "Title: " + "\n" +
                        title + "\n \n" +

                        "Department: " + "\n" +
                        department + "\n \n" +

                        "Address: " +
                        address + "\n";

        return details;

    }

    public static String getWindowTitle(int index, Person[] array){

        //Window Title as name of person
        String windowTitle =
                array[index].getName().getFirst() + " " +
                array[index].getName().getMiddle() + " " +
                array[index].getName().getLast();

        return windowTitle;
    }



}
