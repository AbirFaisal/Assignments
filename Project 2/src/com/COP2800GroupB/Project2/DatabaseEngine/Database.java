package com.COP2800GroupB.Project2.DatabaseEngine;

/**
 * Created by abirfaisal on 2/10/15.
 */

public class Database implements java.io.Serializable {



    Object database;
    int databaseSize;
    String databaseFileName;


    //CONSTRUCTOR
    public Database() {


    }


    public Object getDatabase() {
        return database;
    }

    public void setDatabase(Object database) {
        this.database = database;
    }

    public int getDatabaseSize() {
        return databaseSize;
    }

    public void setDatabaseSize(int databaseSize) {
        this.databaseSize = databaseSize;
    }

    public String getDatabaseFileName() {
        return databaseFileName;
    }

    public void setDatabaseFileName(String databaseFileName) {
        this.databaseFileName = databaseFileName;
    }

    public static void createDatabaseFile(String fileName) {

        //If file does not exsist on disk go ahead and create the file
        if (doesExistOnDisk(fileName) == false){
            FileManager.createFile(fileName);
        }else { System.out.print("ERROR: File Already Exist");}
    }

    public static Object[] loadDatabase(String fileName) {

        return (Object[]) FileManager.loadDBAsArray(fileName);
    }


    public static boolean doesExistOnDisk(String fileName) {
        return FileManager.doesFileExist(fileName); // returns true/false
    }

    //Save array database to disk
    public static void saveDatabaseToDisk(String fileName, Database[] array) {
        FileManager.writeDBFromArray(fileName, array);
    }

    //returns string array of avaliable databases on disk
    public static void avaliableDatabases() {
        FileManager.findDatabasesOnDisk();
    }

    public static void deleteDatabase(String databaseName){
        //delete database function
    }

}
