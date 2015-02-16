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


//No class modifier we want only class and package access
//Which is the default
class FileManager {

    /*
    private Object file;


    public Object getFile() {
        return file;
    }

    public void setFile(Object file) {
        this.file = file;
    }
    */

    //Create File works dont touch
    public static void createFile(String fileName) {

        //add file extension
        fileName = fileName.concat(".gbdb");

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

    //returns file as an object array given dabase file name
    public static Object loadDBAsArray(String fileName) {

        //add file extension
        fileName = fileName.concat(".gbdb");

        //Read from disk
        try {
            //Open File for reading
            FileInputStream file = new FileInputStream(fileName);
            //
            ObjectInputStream buffer = new ObjectInputStream(file);
            //return the object

            Object temp = buffer.readObject();

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

    //writes to file given database, to the specified file
    public static void writeDBFromArray(String fileName, Database[] data) {


        //add file extension
        fileName = fileName.concat(".gbdb");

        try {
            //Create new object to store file in Memory
            FileOutputStream file = new FileOutputStream(fileName);
            //Buffer writes
            ObjectOutputStream buffer = new ObjectOutputStream(file);
            //Write Object to disk
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

        //add file extension
        fileName = fileName.concat(".gbdb");

        //Returns true or false
        return new File(fileName).isFile();
    }

    //Returns String array of specified files.
    public static void findDatabasesOnDisk() {
        System.out.print("Work In Progress");
    }

    public static void deleteFile(String fileName){
        //add file extension
        fileName = fileName.concat(".gbdb");

    }
}
