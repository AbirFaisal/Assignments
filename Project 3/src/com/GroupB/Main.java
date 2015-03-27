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


        //TODO error checking or some shit


        //convert input to int values
        numBirds = Integer.parseInt(birds);
        numDogs = Integer.parseInt(dogs);


        //Create array of Animal type
        Animal[] animalArray = new Animal[numBirds+numDogs];


        String weight;
        String name;
        String breed;

        System.out.print("");
        weight = input.nextLine();

        //initalize birds
        for (i = 0; i < numBirds; i++) {

            System.out.println("Enter birds weight(lbs): ");
            weight = input.nextLine();

            System.out.println("Enter birds name: ");
            name  = input.nextLine();

                   animalArray[i] = new Bird(weight,name);
        }



        //initalize dogs
        for (i = numBirds; i < (numDogs+numBirds); i++) {

            System.out.println("Enter Dogs weight(lbs): ");
            weight = input.nextLine();

            System.out.println("Enter Dogs breed: ");
            breed  = input.nextLine();


            animalArray[i] = new Dog(weight, breed);
        }


        //
        for (i = 0; i < (numBirds+numDogs); i++) {
            System.out.print( "\n\n\nRecord: " +  (1+i) + "\n_______________________\n");
            System.out.print( animalArray[i]);
        }





}//end of main



}//end of class Main
