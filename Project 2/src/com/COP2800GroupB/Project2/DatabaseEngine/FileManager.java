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

    //check if initialized was run at least once.
    private static boolean FMinit = false;


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
        FMinit = true;
    }

    //returns file as an array
    public static String loadDBAsArray(String fileName) {
        //load file database to memory from

        String currentLine = "";
        ArrayList tempArray = new ArrayList();
        int ArraySize = 0;
        String[] array = { "0" };

        try {
            FileReader file = new FileReader(fileName);
            BufferedReader buffer = new BufferedReader(file);

            try {
                while ((currentLine = buffer.readLine()) != null){
                    tempArray.add(currentLine);
                    ArraySize = ArraySize + 1;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //Load tempArray into array
        for (int i = 0; i < ArraySize; i++) {
            array[i] = tempArray.get(i);
        }

        return array;
    }

    //writes given array to specified file
    public void writeDB(String fileName, String[] data) {
        //write database from memory to file

        String stream = new String[];

        try {
            FileWriter file = new FileWriter(fileName);
            BufferedWriter buffer = new BufferedWriter(file);
            PrintWriter output = new PrintWriter(buffer);

            for (int i = 0; i < stream.length(); i++) {
                if (data != null) {
                    output.write(data[i]);
                    output.newLine();
                }
            }

            output.flush();
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
