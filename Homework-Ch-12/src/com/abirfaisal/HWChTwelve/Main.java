package com.abirfaisal.HWChTwelve;

/**

 HW 12.2
 (InputMismatchException) Write a program that prompts the user to read two integers and displays their sum.
 Your program should prompt the user to read the number again if the input is incorrect.

 HW 12.3
 (ArrayIndexOutOfBoundsException) Write a program that meets the following requirements:
 - Creates an array with 100 randomly chosen integers.
 - Prompts the user to enter the index of the array, then displays the corresponding element value.
 - If the specified index is out of bounds, display the message Out of Bounds.

 HW 12.14
 (Process scores in a text file) Suppose that a text file contains an unspecified number of scores separated by blanks.
 Write a program that prompts the user to enter the file, reads the scores from the file, and displays their total and average.

 */


import com.abirfaisal.HWChTwelve.CH12_14.CH12_14;
import com.abirfaisal.HWChTwelve.CH12_2.CH12_2;
import com.abirfaisal.HWChTwelve.CH12_3.CH12_3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        if (args.length > 0){
            printLines(50);
            System.out.println("Invalid Input");
        }

        Scanner input = new Scanner(System.in);

        System.out.println("1. Homework: 12.2 \n" +
                "2. Homework: 12.3 \n" +
                "3. Homework: 12.14 \n" +
                "q to quit \n" +
                "Select an Assignment: ");
        String selection = input.next();


        switch (selection.charAt(0)){
            case '1':
                CH12_2.start();
                break;
            case '2':
                CH12_3.start();
                break;
            case '3':
                CH12_14.start();
                break;
            case ('q' | 'Q'):
                break;
            default: main(new String[]{"1"});
        }
    }


    public static void printLines(int lines){

        String line = "";

        for (int i = 0; i < lines; i++) {
            line = line + "\n";
        }

        System.out.print(line);
    }
}
