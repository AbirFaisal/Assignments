package com.abirfaisal;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by abirfaisal on 2/13/15.
 */



public class AlarmClock {

    int Seconds;
    int Minutes;
    int Hours;
    boolean timerOn;


    // Constructor

    public AlarmClock(int seconds, int minutes, int hours, boolean timerOn) {

        //Create calendar object
        Calendar time = new GregorianCalendar();
        Seconds = time.get(time.SECOND);
        Minutes = time.get(time.MINUTE);
        Hours = time.get(time.HOUR_OF_DAY);
        this.timerOn = true;
    }


    // Getters and Setters

    public int getSeconds() {
        return Seconds;
    }

    public void setSeconds(int seconds) {
        Seconds = seconds;
    }

    public int getMinutes() {
        return Minutes;
    }

    public void setMinutes(int minutes) {
        Minutes = minutes;
    }

    public int getHours() {
        return Hours;
    }

    public void setHours(int hours) {
        Hours = hours;
    }

    public boolean isTimerOn() {
        return timerOn;
    }

    public void setTimerOn(boolean timerOn) {
        this.timerOn = timerOn;
    }


    public static void setAlarmForOneHour(AlarmClock){

    }

}
