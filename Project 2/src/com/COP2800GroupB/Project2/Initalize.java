package com.COP2800GroupB.Project2;

import com.COP2800GroupB.Project2.DatabaseEngine.Database;


/**
 * Created by abirfaisal on 2/11/15.
 */


public class Initalize {


    ///// I THINK WE SHOULD SEPERATE THIS INTO ITS OWN METHODS OR A CONSTRUCTOR // ITS WORKS FOR NOW.



    //Create a constant size for each database we want to create.
    static final int MAX_MANAGERS = 20;
    static final String MANAGER_FILE_NAME = "Manager";

    static final int MAX_EMPLOYEES = 100;
    static final String EMPLOYEE_FILE_NAME = "Employee";

    static final int MAX_PERSONS = 500;
    static final String PERSON_FILE_NAME = "Person";

    //Create database refrences for ea
    static Database[] managers = new Database[MAX_MANAGERS - 1];
    static Database[] employee = new Database[MAX_EMPLOYEES - 1];
    static Database[] person = new Database[MAX_PERSONS - 1];




    public static void init() {


        // Create empty database objects for use
        for (int i = 0; i < (MAX_MANAGERS-1); i++) {
            managers[i] = new Database();
        }
        for (int i = 0; i < (MAX_EMPLOYEES-1); i++) {
            employee[i] = new Database();

        }
        for (int i = 0; i < (MAX_PERSONS-1); i++) {
            person[i] = new Database();
        }


        // check if database exists
        // if exists then load into specified array
        // if does not exist create it
        checkAndCreate(managers, MANAGER_FILE_NAME);
        checkAndCreate(employee, EMPLOYEE_FILE_NAME);
        checkAndCreate(person, PERSON_FILE_NAME);



    }





    //check create or load database.
    private static void checkAndCreate(Database[] DBName, String fileName){
        if(Database.doesExistOnDisk(fileName) == true){
            DBName = (Database[]) Database.loadDatabase(fileName);
        } else {
            //Create database if does not exsist
            Database.createDatabaseFile(fileName);
        }
    }
}
