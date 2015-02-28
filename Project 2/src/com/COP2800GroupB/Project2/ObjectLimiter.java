package com.COP2800GroupB.Project2;

import com.COP2800GroupB.Project2.Company.Person;
import com.COP2800GroupB.Project2.Tools.Display;

import javax.swing.*;

/**
 * Created by David on 2/27/2015.
 */
public class ObjectLimiter {



    public static void limitObject(boolean isEmployeeRadioYes, boolean isManagerRadioYes, Person[] array, int index) {


        //set isEmployee
        //check if employee s
        if (isEmployeeRadioYes) {

            if (ObjectLimiter.checkEmployee(array)) {

                //set employee to true
                array[index].getEmployee().setEmployee(true);

                //check if manager is selected
                if (isManagerRadioYes) {

                    if (ObjectLimiter.checkManager(array)) {

                        //set manager to true
                        array[index].getEmployee().getManager().setManager(true);

                    } else {
                        //error
                        JOptionPane.showMessageDialog(null, "You can't have more than 20 managers");
                        //return to view all
                        Display.displayAllPeople(array);
                    }

                    //check if manager is not selected
                } else if (!isManagerRadioYes) {
                    //set manager to false
                    array[index].getEmployee().getManager().setManager(false);
                }
            } else {
                //error
                JOptionPane.showMessageDialog(null, "You can't have more than 100 employees");
                //return to view all
                Display.displayAllPeople(array);
            }

            //check if employee is not selected
            if (!isEmployeeRadioYes){

                //set both employee and manager to false since
                // manager cant be true unless employee is true
                array[index].getEmployee().setEmployee(false);
                array[index].getEmployee().getManager().setManager(false);
            }

        }
    }



    //return false if managers is more than 20
    public static boolean checkManager(Person[] array) {

        int count = 0;



        for (int i = 0; i < array.length; i++) {
            if (array[i].getEmployee().getManager().isManager()) {
                count++;
                if (count > 20) {
                    return false;
                }//end of inner if
            }//end of outer if
        }//end of for
        return true;
    }//end of checkManager




    //returns false if employees is more than 100
    public static boolean checkEmployee(Person[] array) {

        int count=0;


        for (int i = 0; i < array.length; i++) {
            if (array[i].getEmployee().isEmployee()) {
                count++;
                if (count > 100) {
                    return false;
                }//end of inner if
            }//end of outer if
        }//end of for
        return true;
    }//end of checkManager

}// end of ObjectLimiter
