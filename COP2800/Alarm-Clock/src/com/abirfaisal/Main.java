package com.abirfaisal;

import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {


        AlarmClock test = new AlarmClock(true);


        Calendar testCal = new GregorianCalendar();

        //Alarm
        //We should probably use an interrupt of some sort but just to keep things simple
        //I'll just use a loop here.
        do {
            if (test.getHours() == testCal.get(Calendar.HOUR_OF_DAY)){

                if (test.getMinutes() == testCal.get(Calendar.MINUTE)){

                    if (test.getSeconds() == testCal.get(Calendar.SECOND)){

                        JOptionPane.showMessageDialog(null, "Alarm " +
                                                            test.getHours() +
                                                            " : " +
                                                            test.getMinutes() +
                                                            " : " +
                                                            test.getSeconds());
                        //turn off alarm
                        test.setTimerOn(false);
                    }

                }

            }
        }while (test.isTimerOn());
    }
}
