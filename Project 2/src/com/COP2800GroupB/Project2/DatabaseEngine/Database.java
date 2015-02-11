package com.COP2800GroupB.Project2.DatabaseEngine;

/**
 * Created by abirfaisal on 2/10/15.
 */

import java.lang.String;

public class Database {

    //databases
    //manager array
    private char Employee[100];
    private char Manager[20];
    private char Person[500];

    //check if initalized
    private static boolean init = false;

    public static void initalize(String DatabaseName , int DBsize){
        //Initlize file manager

        FileManager.initalize(DatabaseName);

        //Initalize arrays

        init = true;

    }

    public static seet(){

    }

    public static get(){

    }

    public static search(char search[]){

    }
}