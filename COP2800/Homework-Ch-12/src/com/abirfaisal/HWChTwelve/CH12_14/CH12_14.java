package com.abirfaisal.HWChTwelve.CH12_14;

/**
 HW 12.14 (Process scores in a text file)
 Suppose that a text file contains an unspecified number of scores separated by blanks.
 Write a program that prompts the user to enter the file, reads the scores from the file, and displays their total and average.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CH12_14 {

    public static void start() {

        System.out.println("HW 12.14 Process scores in a text file");

        String filename = "";
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the filename \n" +
                "You can enter a complete path, partial path or only the file name \n" +
                "You must include the extension if there is one" );


        //get file name and/or path from user
        filename = input.next();

        try {
            int i = 1;
            int total = 0;
            int average = 0;
            Scanner file = new Scanner(new File(filename));

            while (file.hasNext()){

                total = file.nextInt();
                average = file.nextInt();

                //print out record
                System.out.println("Record: " + i +
                                   "total: " + total +
                                   "average: "  + average);
                i++;
            }

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("file:" +  e);

        }
    }
}