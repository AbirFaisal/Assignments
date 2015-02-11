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
import java.io.FileReader;

//No class modifier we want only class and package access
//Which is the default
class FileManager {

    //check if initialized was run at least once.
    private static boolean FMinit = false;


    //Create File
    public static void createFile(String fileName) {
        //declare new file and name
        File file = new File(fileName);

        //if file does not exist create it or else do nothing.
        try {
            file.createNewFile();
            //If somthing goes wrong throw exception;
        } catch (IOException e) {
            e.printStackTrace();
        }
        FMinit = true;
    }



    //load database
    public static String loadDBAsArray(String fileName) {
        //load file database to memory from file

        //check file existence
        File file = new File(fileName);
        if (file.exists() == false){
            System.out.print("Error: File Does not exist");
            System.exit(0);
        }

        //open file


        //read file


        //return as array


        int arraySize // = number of records found
        int array[];

        return array;
    }


    public void writeDB(String fileName, char array[]) {
        //write database from memory to file

        //switch case
        //
        //
        //
    }
}
