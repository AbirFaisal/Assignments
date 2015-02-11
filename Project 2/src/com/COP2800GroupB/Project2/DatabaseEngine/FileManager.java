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

    //check if initialized
    private static boolean FMinit = false;

    public static void initalize(String fileName) {
        //Extention: .gbdb means Group B Data Base
        //Employee.gbdb
        //Manager.gbdb
        //check if file exists
        // else create files
        File file = new File(fileName);

        try {
            file.createNewFile();
            //If somthing goes wrong throw exception;
        } catch (IOException e) {
            e.printStackTrace();
        }
        FMinit = true;
    }

    public void loadDB(char selectFile) {
        //load database to memory from file

        //return array
    }

    public void writeDB(char array[], char selectFile) {
        //write database from memory to file

        //switch case
        //
        //
        //
    }
}
