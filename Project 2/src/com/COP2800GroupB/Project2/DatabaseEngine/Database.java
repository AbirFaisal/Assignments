package com.COP2800GroupB.Project2.DatabaseEngine;

import java.io.*;

/**
 * Created by abirfaisal on 2/10/15.
 */

public class Database implements Serializable {



    //load database
    public static Object[] loadDatabase(String fileName) {

        //add file extension
        fileName = fileName.concat(".gbdb");

        //Read from disk
        try {
            //Open File for reading
            FileInputStream file = new FileInputStream(fileName);
            //Convert Binary file stream to object
            ObjectInputStream buffer = new ObjectInputStream(file);
            //return the object

            Object[] temp = new Object[500];

            temp = (Object[]) buffer.readObject();

            buffer.close();

            return temp;


            //FileInputStream error handling stuff
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //ObjectInputStream error handing stuff
        } catch (IOException e) {
            e.printStackTrace();
            //Object error handling stuff
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    //save database
    public static void saveDatabase(String fileName, Object[] array) {


        //add file extension
        fileName = fileName.concat(".gbdb");


        try {
            //Create new object to store file in Memory
            FileOutputStream file = new FileOutputStream(fileName);
            //Buffer writes
            ObjectOutputStream buffer = new ObjectOutputStream(file);
            //Write Object to disk
            buffer.writeObject(array);
            //Flush Cache from memory to disk
            buffer.flush();
            //Close the file
            buffer.close();
            //error handling stuff
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    //extra functions

    public static boolean doesExistOnDisk(String fileName) {

        return true;
    }

    //Save array database to disk


    //returns string array of avaliable databases on disk
    public static void avaliableDatabases() {
    }

    public static void deleteDatabase(String databaseName){
        //delete database function
    }
}
