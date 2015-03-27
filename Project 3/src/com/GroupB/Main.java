package com.GroupB;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String birds = "2";
        String dogs = "2";
        int numBirds = 0;
        int numDogs = 0;
        int i = 0;
        Scanner input = new Scanner(System.in);


        //prompt user
        System.out.println("How many Birds do you want");

        //get input
        birds = input.next();

        //prompt user
        System.out.println("How many Dogs do you want");

        //get input
        dogs = input.next();



        numBirds = Integer.parseInt(birds);
        numDogs = Integer.parseInt(dogs);


        //Create array of Animal type
        Animal[] animalArray = new Animal[numBirds+numDogs];



        //initalize birds
        for (i = 0; i < numBirds; i++) {
            animalArray[i] = new Bird("10", "Parrot");
        }


        //initalize dogs
        for (i = numBirds; i < (numDogs+numBirds); i++) {
            animalArray[i] = new Dog("30", "Pitbull");
        }



        for (i = 0; i < (numBirds+numDogs); i++) {
            System.out.print(" \n " + animalArray[i] + "\n");
        }



        //System.out.print(array[2]);





}//end of main



}//end of class Main
