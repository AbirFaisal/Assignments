package com.COP2800GroupB.Project2;



import com.COP2800GroupB.Project2.Company.Person;
import com.COP2800GroupB.Project2.Tools.Display;

import javax.swing.*;


public class ObjectLimiter {


    //Checks to make sure that Employees and managers are within bounds
    public static void limitObject(boolean isEmployeeRadioYes, boolean isManagerRadioYes, Person[] array, int index) {

        //Check if Employee selected
        if (isEmployeeRadioYes) {

            //Check if there are already 100 Employees
            if (checkEmployee(array)) {

                //Set employee to true
                array[index].getEmployee().setEmployee(true);

                //Check if Manager is selected
                if (isManagerRadioYes) {

                    //Check if there are already 20 Managers
                    if (checkManager(array)) {

                        //Set manager to true
                        array[index].getEmployee().getManager().setManager(true);

                    } else {

                        //Error
                        JOptionPane.showMessageDialog(null, "You can't have more than 20 managers");

                        //Return to view all
                        Display.displayAllPeople(array);
                    }

                    //Check if manager is not selected
                } else if (!isManagerRadioYes) {

                    //Set manager to false
                    array[index].getEmployee().getManager().setManager(false);

                }
            } else {

                //Error
                JOptionPane.showMessageDialog(null, "You can't have more than 100 employees");

                //Return to view all
                Display.displayAllPeople(array);
            }
        }
        //Check if employee is not selected
        else if (!isEmployeeRadioYes) {

            //Set both employee and manager to false since
            //Manager cant be true unless employee is true
            array[index].getEmployee().setEmployee(false);
            array[index].getEmployee().getManager().setManager(false);
        } else {
            JOptionPane.showMessageDialog(null, "Programmer Retardation");
        }
    }


    //return false if managers is more than 20
    private static boolean checkManager(Person[] array) {

        //Hold number of Managers
        int count = 0;

        //Loop through array
        for (Person anArray : array) {

            //Check if Manager
            if (anArray.getEmployee().getManager().isManager()) {

                //Add 1 to count
                count++;

                //Check if count is greater than MAX_MANAGERS
                if (count > Main.MAX_MANAGERS) {
                    return false;
                }
            }
        }

        //Return true if less than MAX_MANAGERS
        return true;
    }


    //returns false if employees is more than 100
    private static boolean checkEmployee(Person[] array) {

        //Hold number of Managers
        int count = 0;

        //Loop through array
        for (Person anArray : array) {

            //Check if Manager
            if (anArray.getEmployee().isEmployee()) {

                //Add 1 to count
                count++;

                //Check if count is greater than MAX_MANAGERS
                if (count > Main.MAX_EMPLOYEES) {
                    return false;
                }
            }
        }

        //Return true if less than MAX_MANAGERS
        return true;
    }

}
