package com.COP2800GroupB.Project2.DatabaseEngine;

/**
 * Created by abirfaisal on 2/10/15.
 */

public class Database implements java.io.Serializable {


    public static void createDatabaseFile(String fileName) {

        //If file does not exsist on disk go ahead and create the file
        if (doesExistOnDisk(fileName) == false){
            FileManager.createFile(fileName);
        }else { System.out.print("ERROR: File Already Exist");}
    }

    public static Object[] loadDatabase(String fileName) {

        return new Object[] = FileManager.loadDBAsArray(fileName);
    }


    public static boolean doesExistOnDisk(String fileName) {
        return FileManager.doesFileExist(fileName); // returns true/false
    }

    //Save array database to disk
    public static void saveDatabaseToDisk(String fileName, Database[] array) {
        FileManager.writeDBFromArray(fileName, array);
    }

    //returns string array of avaliable databases on disk
    public static void avaliableDatabases(String DBFileExtension){
        FileManager.findDatabasesOnDisk(DBFileExtension);
    }

}