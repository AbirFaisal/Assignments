package com.COP2800GroupB.Project2.DatabaseEngine;

/**
 * Created by abirfaisal on 2/10/15.
 */

import java.lang.String;

public class Database {

    //database data type////////////////////////////
    private String database;

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
    ////////////////////////////////////////////////


    public static int initalizeDB(String DatabaseName , int DBsize){
        //Initlize file manager

        FileManager.initalize(DatabaseName);
        int array[] = new FileManager.loadDBAsArray();


        //for each database create new array

        //Initalize arrays

        return array;

    }

    private static void database() {

    }

    public static void seet(){

    }

    public static void get(){

    }

}