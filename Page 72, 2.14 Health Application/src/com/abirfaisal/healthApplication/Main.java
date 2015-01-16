package com.abirfaisal.healthApplication;

/**
 * 2.14 (Health application: computing BMI) Body Mass Index (BMI) is a measure of health on weight.
 * It can be calculated by taking your weight in kilograms and dividing by the square of your height in meters.
 * Write a program that prompts the user to enter a weight in pounds and height in inches and displays the BMI.
 * Note that one pound is 0.45359237 kilograms and one inch is 0.0254 meters.
 */

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        System.out.println("Enter your weight in Pounds (LB)"); // Prompt user for pounds
        Scanner pounds = new Scanner(System.in);
        double lbs = pounds.nextDouble();

        System.out.println("Enter your height in inches"); // Prompt user for inches
        Scanner inches = new Scanner(System.in);
        double in = inches.nextDouble();

        double BMI = Convert.tokg(lbs) / ((Convert.tometers(in) * (Convert.tometers(in)))); //Calculate BMI

        //(float) BMI //reduce precision a bit
        System.out.println("Your Body Mass Index (BMI) is: " + (long) BMI);


    }
}
