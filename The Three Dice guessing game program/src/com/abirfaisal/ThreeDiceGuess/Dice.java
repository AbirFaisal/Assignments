package com.abirfaisal.ThreeDiceGuess;

/**
 * Created by abirfaisal on 1/16/15.
 */
//import random
import java.util.Random;

//Dice class
public class Dice {

    //Roll usage: Dice.Roll(Number of rolls integer)
    public static int Roll(int rolls) {

        //result initalize to 0 so we can use it in the for loop
        int result = 0;

        // for loop iterates for number of rolls and adds result to result
        for (int i = 0; i < rolls; i++) {

            //Create new variable of Random type
            Random dice = new Random();

            //limit random number to 5 but add 1 in case random returns 0
            //and make it possible so that dice.nextInt() can return 6
            result = dice.nextInt(6) + 1 + result;
        }

        //return with answer
        return result;
    }
}
