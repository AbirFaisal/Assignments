package com.abirfaisal.HWChTwelve.CH12_3;

import java.util.Random;
import java.util.Scanner;

/**

 HW 12.3 (ArrayIndexOutOfBoundsException)
 Write a program that meets the following requirements:
 - Creates an array with 100 randomly chosen integers.
 - Prompts the user to enter the index of the array, then displays the corresponding element value.
 - If the specified index is out of bounds, display the message Out of Bounds.

 */
public class CH12_3 {

    public static void start() {

        Random rand = new Random();
        int min = 0;
        int max = 1000;

        Scanner input = new Scanner(System.in);
        int selection = 0;
        int i = 0;

        int[] integers = new int[100];

        //Fill array with random numbers
        for (i = 0; i < integers.length; i++) {
            integers[i] = rand.nextInt((max - min) + 1) + min;
        }


        System.out.print("HW 12.3 Array Index Out Of Bounds Exception \n");
        

        System.out.println("Integer at " + selection + "is" + integers[selection]);


    }

}
