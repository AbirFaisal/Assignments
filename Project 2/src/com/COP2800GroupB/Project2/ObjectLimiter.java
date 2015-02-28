package com.COP2800GroupB.Project2;

import com.COP2800GroupB.Project2.Company.Person;

/**
 * Created by David on 2/27/2015.
 */
public class ObjectLimiter {
    protected static int count;

    public static void checkManager(Person[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].getEmployee().getManager().isManager()) {
                count++;
                if (count > 20) {
                    System.out.print("Employees is greater than 100");
                }//end of inner if
            }//end of outer if
        }//end of for
    }//end of checkManager

    public static void checkEmployee(Person[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].getEmployee().isEmployee()) {
                count++;
                if (count > 20) {

                    System.out.print("Employees is greater than 100");

                }//end of inner if
            }//end of outer if
        }//end of for
    }//end of checkManager

}// end of ObjectLimiter
