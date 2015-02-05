package com.abirfaisal;
/*
Write a program that does the following:
	•	Allows the user to determine how many random number between 1 and 100 are to be stored.  In other words the user could pick 10,500.
	•   You would generate and store 10,500 numbers randomly generated all between 1 and 100.
	•	Declare an array that stores the random numbers (total determined by user).
	•	Print out the array
	•	Sort the array
	•	Print out the array
	•	Search the array for a number between 1 and 100…display found or not found
	•	Display each number from 1 to 100 and the number of times found in the array
	•	Display the average of the numbers in the array
	•	Display the highest number in the array
	•	Display the lowest number in the array
	•	Everything should be done using METHODS
	•	Design tool = Yes
	•	Put up in Blackboard = Yes
 */

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //Prompt User for input
        System.out.print("Please enter how many random numbers you want to generate \n");
        Scanner input = new Scanner(System.in);
        int amountOfRandomNumbers = input.nextInt();

		//Generate the amount of random values the user wants
		int numbersArray[] = new int[amountOfRandomNumbers];

		//Loop to generate and store array values
		for (int i = 0; i < amountOfRandomNumbers; i++) {
			//Random is in for loop so we re-seed every time the loop starts
			Random number = new Random();
			//Store random number in array
			numbersArray[i] = number.nextInt(100)+1;
			//Print out random numbers
			System.out.print("\n" + numbersArray[i]);
		}

		//Sort array
		Arrays.sort(numbersArray);

		//Print out sorted array
		for (int i = 0; i < amountOfRandomNumbers; i++) {
			System.out.print("\n" + numbersArray[i]);
		}

		//Search the array for a number between 1 and 100…display found or not found
		for (int i = 0; i < amountOfRandomNumbers; i++) {
			if (numbersArray[i] >= 1 || numbersArray[i] <=100 ) {
				System.out.print("found or not found \n");
			}
		}


		//Display number of times each number occurred
		//Numbers to match array
		int oneHundred = 99;
		int[] numbersToMatch = new int[oneHundred];


		//Occurrences array
		int[] matches = new int[oneHundred];

		//We can initialize both arrays at the same time since
		//both arrays are the same size
		for (int i = 0; i < oneHundred; i++) {
			numbersToMatch[i] = (i+1);
			matches[i] = 0;
		}

		//For loop to find and store occurences
		for (int i = 0; i < amountOfRandomNumbers; i++) {
			for (int j = 0; j < oneHundred; j++) {
				if (numbersArray[i] == numbersToMatch[j]) {
					matches[j] = matches[j] + 1;
				}
			}
		}


		//Display highest number in array
		//Since array[] was sorted from least to greatest
		//numbersArray[0] should be the lowest
		//numbersArray[amountOfRandomNumbers should be the highest
		System.out.print(numbersArray[amountOfRandomNumbers-1] + "\n");
		System.out.print(numbersArray[0] + "\n");
	}
}
