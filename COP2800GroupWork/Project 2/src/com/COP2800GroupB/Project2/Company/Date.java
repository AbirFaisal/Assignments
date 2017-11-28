/*
 * *
 *  * Project Name: Project 2
 *  * Class Name: Date
 *  *
 *  * Created by David, Nicholas, Abir, Will, Brian on 3/1/15 10:48 PM
 *
 */

package com.COP2800GroupB.Project2.Company;


public class Date {


    //Fields
    private int Month;
    private int Day;
    private int Year;


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