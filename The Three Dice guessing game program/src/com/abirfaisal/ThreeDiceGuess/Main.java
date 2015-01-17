package com.abirfaisal.ThreeDiceGuess;


/**
 * You are to write a C program that will simulate the rolling of three dice.
 * You will add the total of the dice together.
 * You will then ask the user if the next roll will be higher, lower, the same or if they wanna quit playing.
 * With each right guess you will inform the user of the length of their winning streak.
 * As with all programs, you need to insert comments, and write neat indented code.
 * Once you are finished you are to attach the java project folder to the assignment thread.
 * NOTES/COMMENTS/HINTS
 * To generate a random number between LOWERBOUND and UPPERBOUND you will need the following code:
 * theNumber = LOWERBOUND + rand() % (UPPERBOUND - LOWERBOUND + 1);
 * Just to let you know there are many other ways.  Make sure you read chapter three for hints and help.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean keepPlaying = true;     //keep playing or not
        int wins = 0;                   //keep track of wining streaks
        int lastRoll = Dice.Roll(3);    //store the last dice roll and perform the initial roll

        while (keepPlaying == true) {
            System.out.println("Last Roll: " + lastRoll);
            System.out.println("Current Streak: " + wins);
            System.out.println("Will the next roll be higher, lower or the same?");
            System.out.println("Enter one of the following options:");
            System.out.println("[1] Higher ");
            System.out.println("[2] Lower ");
            System.out.println("[3] Same");
            System.out.println("[4] Quit");
            Scanner input = new Scanner(System.in);
            int answer = input.nextInt();

            //Option 1
            if (answer == 1) {
                int newRoll = Dice.Roll(3);     //perform 3 new dice rolls
                if (newRoll > lastRoll) {       //compare rolls
                    lastRoll = newRoll;         //make lastRoll = newRoll
                    wins = wins + 1;            //add to wins streak
                } else {
                    lastRoll = newRoll;         //if compare is false then reset win steak
                    wins = 0;                   // and make lastRoll = newRoll
                }
            }

            //Option 2 no difference from option 1 besides the operand in the if statement.
            else if (answer == 2) {
                int newRoll = Dice.Roll(3);
                if (newRoll < lastRoll) {        // swapped around the < so we can check if user guessed correctly
                    lastRoll = newRoll;
                    wins = wins + 1;
                } else {
                    lastRoll = newRoll;
                    wins = 0;
                }
            }
            //Option 3 no difference from option 1 besides the operand in the if statement.
            else if (answer == 3) {
                int newRoll = Dice.Roll(3);
                if (newRoll == lastRoll) {       // changed to == so see if newRoll is the same as lastRoll
                    lastRoll = newRoll;
                    wins = wins + 1;
                } else {
                    lastRoll = newRoll;
                    wins = 0;
                }
            }

            //If user enters 4 set keepPlaying to false to end the game.
            else if (answer == 4) {
                keepPlaying = false;
            }

            //If user enters invalid number then this will let the user know.
            else if (answer > 4){
                System.out.println("Invalid Input Fuck You");
            }

            //clear the console with 50 blank lines.
            //I'm sure there is a better way to do this but it works so whatever.
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }

        //If user enters option 4 then this if statement will become true.
        if (keepPlaying == false) {
            System.out.println("Thanks for playing");   //Thank user for playing
            System.exit(0);                             //Quit
        }
    }
}
