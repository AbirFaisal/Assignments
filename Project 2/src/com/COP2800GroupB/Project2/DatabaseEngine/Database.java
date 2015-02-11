package com.COP2800GroupB.Project2.DatabaseEngine;

/**
 * Created by abirfaisal on 2/10/15.
 */

import java.lang.String;

public class Database {

    //database Array





    //check if initalized
    private static boolean init = false;

    public static int createDB(String DatabaseName , int DBsize){
        //Initlize file manager

        FileManager.initalize(DatabaseName);
        int array[] = new FileManager.loadDBAsArray();


        //for each database create new array

        //Initalize arrays

        init = true;
        return array;

    }

    private static void database() {

    }

    public static void seet(){

    }

    public static void get(){

    }

    public static search(char search[]){

    }
}