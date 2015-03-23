/*
 * *
 *  * Project Name: Project 2
 *  * Class Name: Initalize
 *  *
 *  * Created by David, Nicholas, Abir, Will, Brian on 3/1/15 10:48 PM
 *
 */

package com.COP2800GroupB.Project2;



import com.COP2800GroupB.Project2.Company.*;

import java.util.Calendar;

class Initialize {

    //Initializes the personDatabase[] array
    public static void initializeRecords(Person[] array) {


        //Declare variables
        Name name;
        Manager tempManager;
        Calendar calendar;
        Date dateHired;
        Employee tempEmployee;
        Address address;
        Date dateCreated;


        //Initialize objects in personDatabase array
        for (int i = 0; i < array.length; i++) {


            //create new name Object
            name = new Name(
                    "Empty",    //First
                    "-",        //Middle
                    "Record");  //Last


            //create new manager of Manager type
            tempManager = new Manager(
                    false,  //isManager (true/false)
                    "",     //Title
                    "");    //Department


            //Create calendar to get current date
            calendar= Calendar.getInstance();


            //Create new a date Object and add calendar values
            dateHired = new Date(
                    calendar.get(Calendar.MONTH),       //Month
                    calendar.get(Calendar.DAY_OF_MONTH),//Day
                    calendar.get(Calendar.YEAR));       //Year


            //create new employee of employee type
            tempEmployee = new Employee(
                    false,      //isEmployee (true/false)
                    "",         //Position
                    "",         //Pay Rate
                    tempManager,//Manager Object
                    dateHired); //Date Object (date hired)


            //create new address of address type
            address = new Address(
                    "",     //Line 1
                    "",     //Line 2
                    "",     //City
                    "",     //State
                    "",     //Zip
                    "");    //Country


            //Create new a date Object and add calendar values
            dateCreated = new Date(
                    calendar.get(Calendar.MONTH),       //Month
                    calendar.get(Calendar.DAY_OF_MONTH),//Day
                    calendar.get(Calendar.YEAR));       //Year


            //create new person of Person type
            array[i] = new Person(
                    name,                //Name Object
                    "",                  //Email
                    "",                  //Phone
                    tempEmployee,        //Employee Object
                    address,             //Address Object
                    dateCreated);        //Date Object(record create/modify date)
        }
    }
}//

