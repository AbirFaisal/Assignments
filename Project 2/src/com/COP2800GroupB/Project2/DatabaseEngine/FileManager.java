package com.COP2800GroupB.Project2.DatabaseEngine;

/**
 * Created by abirfaisal on 2/10/15.
 * <p/>
 * create get and put things to and from from files
 * <p/>
 * if files dont exsist create them
 * <p/>
 * if files exsist load into memory
 * <p/>
 * record changes from memory to database files
 */

import java.io.File;
import java.io.IOException;

public class FileManager {

    public static void initalize() {
        //Extention: .gbdb means Group B Data Base
        //Employee.gbdb
        //Manager.gbdb
        //check if file exists
        // else create files
        File Employee = new File("Employee.gbdb");
        File Manager = new File("Manager.gbdb");
        File Person = new File("Person.gbdb");

        try {
            Employee.createNewFile();
            Manager.createNewFile();
            Person.createNewFile();
            //If somthing goes wrong throw exception;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDB() {
        //load database to memory

    }

    public void writeDB(char array[], char str) {
        //write database from memory

        //switch case
        //
        //
        //
    }
}
