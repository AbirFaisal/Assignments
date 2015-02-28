package com.COP2800GroupB.Project2;

import com.COP2800GroupB.Project2.Company.Employee;
import com.COP2800GroupB.Project2.Company.Manager;
import com.COP2800GroupB.Project2.Company.Person;

/**
 * Created by David on 2/27/2015.
 */
public class ObjectLimiter {
    protected static int count;

    public static void checkManager(Person[] array) {
        for (int i = 0; i < array.length; i++) {
            if (Manager.isManager()) {
                count++;
                if (count > 20) {
                    Manager.setManager(false);
                }//end of inner if
            }//end of outer if
        }//end of for
    }//end of checkManager

    public static void checkEmployee(Person[] array) {
        for (int i = 0; i < array.length; i++) {
            if (Employee.isEmployee()) {
                count++;
                if (count > 20) {
                    Employee.setEmployee(false);
                }//end of inner if
            }//end of outer if
        }//end of for
    }//end of checkManager

}// end of ObjectLimiter
