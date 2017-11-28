package com.abirfaisal;

/**
 * Created by abirfaisal on 2/8/15.
 */
public class PrintArray {

    public static void printArray(int amountOfRandomNumbers, int numbersArray[]) {
        System.out.print("Print Array: \n");
        for (int i = 0; i < amountOfRandomNumbers; i++) {
            System.out.print(numbersArray[i] + "\n");
        }
    }

    public static void oneAndOneHundred(int amountOfRandomNumbers, int numbersArray[]) {
        for (int i = 0; i < amountOfRandomNumbers; i++) {
            if (numbersArray[i] >= 1 || numbersArray[i] <= 100) {
                System.out.print("found or not found \n");
            }
        }
    }

    public static void frequency(int amountOfRandomNumbers, int numbersArray[]) {
        //Numbers to match array
        int oneHundred = 99;
        int[] numbersToMatch = new int[oneHundred];

        //Occurrences array
        int[] matches = new int[oneHundred];

        //We can initialize both arrays at the same time since
        //both arrays are the same size
        for (int i = 0; i < oneHundred; i++) {
            numbersToMatch[i] = (i + 1);
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

        for (int i = 0; i < amountOfRandomNumbers; i++) {
            System.out.print("Number: " + numbersArray[i] + " Occurrences: 1" + "\n");
        }
    }

    public static void highestLowest(int amountOfRandomNumbers, int numbersArray[]){
        //Display highest number in
        //Since array[] was sorted from least to greatest
        //numbersArray[0] should be the lowest
        //numbersArray[amountOfRandomNumbers] should be the highest
        System.out.print("Highest: " + numbersArray[amountOfRandomNumbers - 1] + "\n");
        System.out.print("Lowest: " + numbersArray[0] + "\n");
    }
}
