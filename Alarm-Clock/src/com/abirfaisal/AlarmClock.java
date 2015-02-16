package com.abirfaisal;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by abirfaisal on 2/13/15.
 */



public class AlarmClock {

    int Seconds;    //Store second
    int Minutes;    //Store Minute
    int Hours;      //Store Hour
    boolean timerOn;//Set alarm status to on or off


    // Constructor
    // Timer on or not

    public AlarmClock(int seconds, int minutes, int hours, boolean timerOn) {

        Calendar temp = new GregorianCalendar();    // Create new calendar

        Seconds = temp.get(Calendar.SECOND);        // Set Second to current second upon creation
        Minutes = temp.get(Calendar.MINUTE);        // Set Minute to current minute upon creation
        Hours = temp.get(Calendar.HOUR_OF_DAY) + 1; // Set alarm 1 hour ahead upon creation
        this.timerOn = true;                        // Turn on alarm
    }


    // Getters and Setters

    public int getSeconds() {
        return Seconds;
    }

    public void setSeconds(int seconds) {

        //Make sure Second is not less than 0 or greater than 60
        try {
            if ((seconds < 0) || (seconds > 60)) {
                throw new RuntimeException();
            } else {
                Seconds = seconds;
            }
        } catch (RuntimeException e){
            System.out.print("Seconds is less than 0 or greater than 24");
        }

    }

    public int getMinutes() {
        return Minutes;
    }

    public void setMinutes(int minutes) {

        //Make sure hour is not less than 0 or greater than 60
        try {
            if ((minutes < 0) || (minutes > 60)) {

            } else {
                Minutes = minutes;
            }
        } catch (RuntimeException e){
            System.out.print("Minutes is less than 0 or greater than 24");
        }
    }

    public int getHours() {
        return Hours;
    }

    public void setHours(int hours) {

        Calendar temp = new GregorianCalendar();

        //Make sure hour is not less than 0 or greater than 24
        try {
            if ((hours < 0) || (hours > 24)) {

            } else {
                Hours = hours;
            }
        } catch (RuntimeException e){
            System.out.print("Hour is less than 0 or greater than 24");
        }

    }

    public boolean isTimerOn() {
        return timerOn;
    }

    public void setTimerOn(boolean timerOn) {
        this.timerOn = timerOn;
    }



}
