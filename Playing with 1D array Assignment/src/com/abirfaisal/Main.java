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

		// Create Numbers Array
		int numbersArray[] = new int[amountOfRandomNumbers];

		//Loop to generate and store array values
		for (int i = 0; i < amountOfRandomNumbers; i++) {
			//Random is in for loop so we re-seed every time the loop starts
			Random number = new Random();
			//Store random number in array
			numbersArray[i] = number.nextInt(100)+1;
		}

		//Print out Unsorted Array
		PrintArray.printArray(amountOfRandomNumbers, numbersArray);

		//Sort array
		Arrays.sort(numbersArray);

		//Print out sorted array
		PrintArray.printArray(amountOfRandomNumbers, numbersArray);

		//Search the array for a number between 1 and 100…display found or not found
		PrintArray.oneAndOneHundred(amountOfRandomNumbers, numbersArray);

		//Display number of times each number occurred
		PrintArray.frequency(amountOfRandomNumbers, numbersArray);

	}
}
