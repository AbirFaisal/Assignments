package com.GroupB;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String birds;
        String dogs;
        int numBirds;
        int numDogs;
        int i;

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

//        numBirds = birds;
//        numDogs = dogs;

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

        //TODO equals method not working properly
        for (i = 0; i < (numBirds+numDogs); i++) {
            System.out.print( "\n\n\nRecord: " +  (1+i) + "\n_______________________\n");

            if (animalArray[i].equals(animalArray[i + 1])){
                System.out.println("The animals are equal");
            }else{
                System.out.println("The animals are NOT equal");
            }

        }



System.out.println("");
}//end of main



}//end of class Main
