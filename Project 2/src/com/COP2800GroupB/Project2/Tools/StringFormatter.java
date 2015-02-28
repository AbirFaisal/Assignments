package com.COP2800GroupB.Project2.Tools;



import com.COP2800GroupB.Project2.Company.Person;


public class StringFormatter {

    //Format String for displaying one record given the index and the array
    public static String OnePerson(int index, Person[] array){


        //Person Fields
        //Get combined First Middle and Last and store as name
        String name = "Name: \n" + getCombinedName(index, array) + "\n \n";


        //Get Email
        String email = "Email: \n" + array[index].getEmail() + "\n \n";
        //Get Phone Number
        String phone = "Phone: \n" + array[index].getPhone() + "\n \n";


        //Employee object Specific fields
        //Get date hired
        String dateHired = "Hired: " + getDateHired(array, index) + "\n \n";




        //Get Pay Rate
        String payRate = "Hourly Pay Rate: \n" + array[index].getEmployee().getHourlyRate() + "\n \n";
        //Get Position
        String position = "Position: \n" + array[index].getEmployee().getPosition() + "\n \n";


        //Manager Specific fields
        //Get department
        String department = "Department: \n" + array[index].getEmployee().getManager().getDepartment() + "\n \n";
        //Get Title
        String title = "Title: \n" + array[index].getEmployee().getManager().getTitle() + "\n \n";



        //Address Fields
        //Get Line1
        String line1 = array[index].getAddress().getAddressLine1() + "\n";
        //Get Line2
        String line2 = array[index].getAddress().getAddressLine2() + "\n";
        //Get City
        String city = array[index].getAddress().getCity() + ", ";
        //Get State
        String state = array[index].getAddress().getState() + " ";
        //Get Zip
        String zip = array[index].getAddress().getZip() + "\n";
        //Get Country
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


        //Get record modify date
        String modfied = "Modified: " + getModifiedDate(array, index);


        //Details formatted using strings created earlier
        //Add name
        String details = name;

        //Check if isEmployee
        if (array[index].getEmployee().isEmployee()) {
            //Add Employee info
            details = details +
                    dateHired +
                    payRate +
                    position;
        }

        //Check if isManager
        if (array[index].getEmployee().getManager().isManager()) {
            //Add Manager info
            details = details +
                    title +
                    department;
        }

        //Add contact info
        details = details +
        "Contact Information: \n \n" +
                phone +
                email +
                address +
                modfied;



        //return formatted details
        return details;
    }


    //Gets First Middle and Last and returns them as one string
    public static String getCombinedName(int index, Person[] array){

        //Combine strings
        String name =
                array[index].getName().getFirst() + " " +   //Get First Name + Space
                array[index].getName().getMiddle() + " " +  //Get Middle Name + Space
                array[index].getName().getLast();           //Get Last Name

        //Return Combined Strings
        return name;
    }


    public static String getDateHired(Person[] array, int index){
        String[] month = {
                "January",  //0
                "February", //1
                "March",    //2
                "April",    //3
                "May",      //4
                "June",     //5
                "July",     //6
                "August",   //7
                "September",//8
                "October",  //9
                "November", //10
                "December"};//11


        String day = String.valueOf(
                array[index].getEmployee().getDateHired().getDay() + 1);

        String year = String.valueOf(
                array[index].getEmployee().getDateHired().getYear());

        String hiredDate = month[array[index].getEmployee().getDateHired().getMonth()] + " " +
                day + ", " +
                year;

        return hiredDate;
    }



    public static String getModifiedDate(Person[] array, int index){
        String[] month = {
                "January",  //0
                "February", //1
                "March",    //2
                "April",    //3
                "May",      //4
                "June",     //5
                "July",     //6
                "August",   //7
                "September",//8
                "October",  //9
                "November", //10
                "December"};//11


        String day = String.valueOf(
                array[index].getDate().getDay());

        String year = String.valueOf(
                array[index].getDate().getYear());

        String hiredDate = month[array[index].getDate().getMonth()] + " " +
                day + ", " +
                year;

        return hiredDate;

    }
}
