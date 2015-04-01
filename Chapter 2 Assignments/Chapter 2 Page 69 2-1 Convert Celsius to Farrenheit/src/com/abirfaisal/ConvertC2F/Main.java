package com.abirfaisal.ConvertC2F;

/*
(Convert Celsius to Fahrenheit) Write a program that reads a
Celsius degree in a double value from the console, then converts it to
Fahrenheit and displays the result. The formula for the conversion is as
follows: fahrenheit = (9 / 5) * celsius + 32
*/

import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        System.out.println("Enter the temperature in celsius");

        Scanner input = new Scanner(System.in);     //creat input
        double c = input.nextDouble();              //Prompt for Input

        double f = (9.00 / 5.00) * c + 32;
        System.out.println(c + "Celsius in Fahrenheit is:" + f + "f");

        Scanner quit = new Scanner(System.in);

        }
}