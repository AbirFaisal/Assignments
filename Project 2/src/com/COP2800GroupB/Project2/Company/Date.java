package com.COP2800GroupB.Project2.Company;

/**
 * Created by abirfaisal on 2/23/15.
 */
public class Date {

   int Month;
    int Day;
    int Year;


    //Constructor
    public Date(int month, int day, int year) {
        Month = month;
        Day = day;
        Year = year;
    }


    //Setters Getters
    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {

        Month = month;
    }

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {
        Day = day;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }



}
