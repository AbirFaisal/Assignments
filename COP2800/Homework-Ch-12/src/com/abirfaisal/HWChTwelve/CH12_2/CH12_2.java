package com.abirfaisal.HWChTwelve.CH12_2;

import com.abirfaisal.HWChTwelve.Main;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 HW 12.2 (InputMismatchException)
 Write a program that prompts the user to read two integers and displays their sum.
 Your program should prompt the user to read the number again if the input is incorrect.
 */


public class CH12_2 {


    public static void start(){

        System.out.println("HW 12.2 Input Mismatch Exception");


        Scanner input = new Scanner(System.in);
        int intA = 0;
        int intB = 0;


        System.out.println("Enter a number: ");

        //Get input A
        try {
            intA = input.nextInt();
        }catch (InputMismatchException e){
            Main.printLines(50);

            //display exception
            System.out.println(e + "\n");

            start();
        }

        System.out.println("Enter another number: ");


        //get input B
        try {
            intB = input.nextInt();
        }catch (InputMismatchException e){
            Main.printLines(50);

            //display exception
            System.out.println(e + "\n");

            start();
        }


        System.out.println(intA + " + " + intB + " is " + (intA + intB));

    }
}
