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

        System.out.println("HW 12.3 Array Index Out Of Bounds Exception");


        Random rand = new Random();
        int min = 0;
        int max = 1000;

        Scanner input = new Scanner(System.in);
        int index = 0;
        int i = 0;

        int[] integers = new int[100];

        //Fill array with random numbers
        for (i = 0; i < integers.length; i++) {
            integers[i] = rand.nextInt((max - min) + 1) + min;
        }


        System.out.print("Enter a number between 0 and 100");
        index = input.nextInt();


        //validate input
        validateInput(index, integers);


        System.out.println("Integer at " + index + "is" + integers[index]);


    }

    //Make sure input is not out of bounds
    private static void validateInput(int index, int[] array) {

        try{
            //make sure input is not out of array bounds
            if (index > array.length){
                throw new ArrayIndexOutOfBoundsException("out of bounds");
            }

        }catch (ArrayIndexOutOfBoundsException e){
            //print error message
            System.out.println(e);
        }
    }
}
