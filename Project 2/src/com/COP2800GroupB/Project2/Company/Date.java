package com.COP2800GroupB.Project2.Company;

/**
 * Created by abirfaisal on 2/23/15.
 */
public class Date {

    String Month;
    String Day;
    String Year;


    //Constructor
    public Date(String month, String day, String year) {
        Month = month;
        Day = day;
        Year = year;
    }


    //Setters Getters
    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }
}
