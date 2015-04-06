package com.abirfaisal.HWChTwelve.CH12_2;

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
        int inta;
        int intb;


        System.out.print("Enter a number: ");
        inta = input.nextInt();
        System.out.print("Enter another number: ");
        intb = input.nextInt();


        validateInput();


        System.out.println(inta + " + " + intb + " is " + (inta + intb));

    }

    private static void validateInput() {



    }
}
