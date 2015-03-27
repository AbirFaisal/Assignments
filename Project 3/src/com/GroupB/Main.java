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


        //Create array of Animal type
        Animal[] array = new Animal[4];


        numBirds = Integer.parseInt(birds);
        numDogs = Integer.parseInt(dogs);

        for (i = 0; i < numBirds; i++) {
            System.out.println("Bird");
        }


        for (i = numBirds; i < (numDogs+numBirds); i++) {
            System.out.println("Dog");
        }




        //System.out.print(array[2]);





}//end of main



}//end of class Main
