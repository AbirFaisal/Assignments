package com.GroupB;

import javax.swing.*;
import java.util.Scanner;



public class Main {


    public static void main(String[] args) {

        String selection;
        int i;
        int size = 0;
        int numOfRecords = 0;

        Scanner input = new Scanner(System.in);

        //Print lines
        printLines(15);

        //Prompt user for how many records
        System.out.println("How many records do you want to create? \n" +
                "Enter a number between 0 and 32767:");
        selection = input.next();

        //make sure input is a numerical valued
        if (!isNumber(selection)){
            JOptionPane.showMessageDialog(null,
                    "Invalid input: Must be an integer between 0 and 32767 \n",
                    "Error", JOptionPane.ERROR_MESSAGE);
            main(args);
        }

        //make sure input is between 0 and 32767 and is positive
        if ((int)Double.parseDouble(selection) <= 0 || (int)Double.parseDouble(selection) >= 32767){
            JOptionPane.showMessageDialog(null,
                    "Invalid input: Must be an integer between 0 and 32767 \n",
                    "Error", JOptionPane.ERROR_MESSAGE);
            main(args);
        }


        //Convert input to integer
        size = Integer.parseInt(selection);


        //Create array of Animal type of user specified size
        Animal[] animalArray = new Animal[size];


        //Do until user wants to exit
        do {

            printLines(20);

            //Print header
            System.out.println("Animal\tWeight\tName/Breed");


            //display current records
            if (animalArray[0] == null) {
                System.out.println("No Records \n");
            } else {
                for (i = 0; i < size; i++) {
                    if (animalArray[i] != null) {
                        System.out.println(animalArray[i]);
                    }
                }
            }


            System.out.print("\n 1. Add Bird \n 2. Add Dog \n q to quit \n");
            selection = input.next();


            //Using switch statement because its faster than if statements
            switch (selection.charAt(0)){
                case '1':
                    add(animalArray, 1);
                    break;
                case '2':
                    add(animalArray, 2);
                    break;
                //quit
                case 'q':
                    System.out.println("Bye - Team B: Will, Nick, David, Abir");
                    System.exit(0);
                    break;

                //Print error and call main
                default:
                    System.out.println(selection.charAt(0));
                    JOptionPane.showMessageDialog(null,
                            "Invalid input: Must be numerical value of 1 or 2 or q to quit \n",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println(); main(args);
            }
        } while (true);



//
//        //TODO equals method not working properly
//        for (i = 0; i < (numBirds+numDogs); i++) {
//            System.out.print( "\n\n\nRecord: " +  (1+i) + "\n_______________________\n");
//
//            if (animalArray[i].equals(animalArray[i + 1])){
//                System.out.println("The animals are equal");
//            }else{
//                System.out.println("The animals are NOT equal");
//            }
//
//        }
    }//end of main


    //Test if string consists of only numbers
    public static boolean isNumber(String input){

        boolean number = true;

        //Loop through string
        for (int i = 0; i < input.length(); i++) {

            //Test
            if ((int)input.charAt(i) < 48 || (int)input.charAt(i) > 57 ){
                number = false;
            }

            //Return false if character is not a number
            if (!number){
                return false;
            }
        }
        //Return true if all characters are numbers
        return true;
    }

    //Prints lines
    //Using this method because System.out.print() is expensive
    //Calling the print method once makes the program much faster
    public static void printLines(int lines){

        //Holds new lines
        String line = "\n";

        //Adds number of specified lines
        for (int i = 0; i < lines; i++) {
            line = line + "\n";
        }

        //Prints lines
        System.out.print(line);
    }


    public static void add(Animal[] array, int birdOrDog){
        printLines(20);

        int index = 0;
        String weight = "";
        String nameBreed = "";

        Scanner input = new Scanner(System.in);


        //get index
        //make sure were working with an null(empty) element
        while (index < array.length && array[index] != null) {
            //if element is not null add 1 to index
            //check if there are avaliable records
            index++;
        }

        if (index > (array.length-1)){
            JOptionPane.showMessageDialog(null, "No empty Records", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }


        //Parent class Animal has weight so its outside the switch statement
        System.out.print("Enter Weight: \n");
        weight = input.next();


        //"switch()" is faster than "if()"
        switch (birdOrDog){
            case 1: //Add Bird
                System.out.print("Enter Name: \n");
                nameBreed = input.next();

                array[index] = new Bird(weight, nameBreed);

                break;

            case 2: //Add Dog
                System.out.print("Enter Breed: \n");
                nameBreed = input.next();

                array[index] = new Dog(weight, nameBreed);

                break;

            //Since this is a backend error throw an exception
            default: throw new IllegalArgumentException("Programmer is dumb: can only be int 1(bird) or 2(dog)");
        }
    }

}//end of class Main