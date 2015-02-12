package com.COP2800GroupB.Project2;

import com.COP2800GroupB.Project2.DatabaseEngine.Database;


/**
 * Created by abirfaisal on 2/11/15.
 */


public class Initalize {

    public static void init() {

        //Create a constant size for each database we want to create.
        final int MAX_MANAGERS = 20;
        final int MAX_EMPLOYEES = 100;
        final int MAX_PERSONS = 500;

        //Create database refrences for ea
        Database[] managers = new Database[MAX_MANAGERS - 1];
        Database[] employee = new Database[MAX_EMPLOYEES - 1];
        Database[] person = new Database[MAX_PERSONS - 1];

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


        //check if database exists on disk

        if(Database.doesExistOnDisk("Manager.gbdb") == true){
            //load database
            managers = Database.loadDatabase("Manager.gbdb");
        }
        else {
            //Create database if does not exsist
            Database.createDatabaseFile("Manager.gbdb");
        }





        //example usage:
        //
        //person[34].setDatabase(); = some object you want to store

    }
}
