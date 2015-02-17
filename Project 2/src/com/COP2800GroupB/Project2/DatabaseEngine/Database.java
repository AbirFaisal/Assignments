package com.COP2800GroupB.Project2.DatabaseEngine;

/**
 * Created by abirfaisal on 2/10/15.
 */

public class Database {



    private Object database;
    private int databaseSize;
    private String databaseFileName;


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


    public static Object[] loadDatabase(String fileName) {


        Database[] temp = new Database[]



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
