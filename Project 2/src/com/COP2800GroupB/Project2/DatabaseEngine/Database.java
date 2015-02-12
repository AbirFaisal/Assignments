package com.COP2800GroupB.Project2.DatabaseEngine;

/**
 * Created by abirfaisal on 2/10/15.
 */

public class Database implements java.io.Serializable {

    //database data type////////////////////////////
    private Object database;

    public Object getDatabase() {
        return database;
    }

    public void setDatabase(Object database) {
        this.database = database;
    }

    public static void createDatabaseFile(String fileName) {

        //If file does not exsist on disk go ahead and create the file
        if (doesExistOnDisk(fileName) == false){
            FileManager.createFile(fileName);
        }else { System.out.print("ERROR: File Already Exist");}
    }

    public static Database[] loadDatabase(String fileName) {

        return new Database[0];
    }



    public static boolean doesExistOnDisk(String fileName) {
        return FileManager.doesFileExist(fileName); // returns true/false
    }

    public static void saveDatabaseToDisk(String fileNameOnDisk, Database[] array) {
        FileManager.writeDBFromArray(fileNameOnDisk, array);
    }

    //returns string array of avaliable databases on disk
    public static void avaliableDatabases(String DBFileExtension){
        FileManager.findDatabasesOnDisk(DBFileExtension);
    }

}