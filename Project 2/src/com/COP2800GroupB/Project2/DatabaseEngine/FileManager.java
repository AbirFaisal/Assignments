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

import java.io.*;
import java.util.ArrayList;


//No class modifier we want only class and package access
//Which is the default
class FileManager {

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
    }

    //returns file as an array given dabase file name
    public static Database[] loadDBAsArray(String fileName) {
        //load file database to memory from
        // string to hold current line
        String currentLine = "";
        //array list because array lists can get bigger on demand
        ArrayList tempArray = new ArrayList();
        //Inital array size for later when we convert ArrayList to array
        int ArraySize = 0;
        //Declare array we don't know what the size we need should be yet that will occur later
        Database[] array;

        try {
            //open the file
            FileReader file = new FileReader(fileName);
            //buffer the file line by line into memory
            BufferedReader buffer = new BufferedReader(file);

            try {
                // if null char is not reached run this loop
                while ((currentLine = buffer.readLine()) != null) {
                    //add the current buffered line into the ArrayList element
                    tempArray.add(currentLine);
                    //increase size of array
                    ArraySize = ArraySize + 1;
                }
                //incase somthing goes wrong
            } catch (IOException e) {
                e.printStackTrace();
            }
            //incase somthing goes wrong
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Declare array size
        array = new Database[ArraySize];
        //Load ArrayList Objects into Database[]
        for (int i = 0; i < ArraySize; i++) {
            //create empty object for use
            array[i] = new Database();
            //take current ArrayList element and put it into the array.
            array[i].setDatabase(tempArray.get(i));
        }

        //return the entire array with stuff from selected file
        return array;
    }



    //writes to file given database, to the specified file
    public static Database writeDBFromArray(String fileName, Database[] data) {

        try {
            //Create new FileWriter in memory
            FileOutputStream file = new FileOutputStream(fileName);
            //Buffer array into print writer
            ObjectOutputStream buffer = new ObjectOutputStream(file);
            //Writes to disk when
            buffer.writeObject(data);
            //Flush Cache from memory to disk
            buffer.flush();
            //Close the file
            buffer.close();
            //error handling stuff
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    //Checks if file exists
    public static boolean doesFileExist(String fileName) {
        return new File(fileName).isFile();
    }
}
