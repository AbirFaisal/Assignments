package com.GroupB;

import java.util.Scanner;



public class Main {


    public static void main(String[] args) {

        String selection;
        int i;
        int size = 0;
        int numOfRecords = 0;
        boolean exit = false;

        Scanner input = new Scanner(System.in);

        //Print lines
        printLines(15);

        //Prompt user for how many records
        System.out.println("How many records do you want to create? \n" +
                "Enter a number between 0 and 32767:");
        selection = input.next();

        //make sure input is a numerical valued
        if (!isNumber(selection)){
            System.out.println("Invalid input: Must be numerical value between 0 and 32767 \n");
            main(args);
        }

        //make sure input is between 0 and 32767 and is positive
        if ((int)Double.parseDouble(selection) <= 0 || (int)Double.parseDouble(selection) >= 32767){
            System.out.println("Invalid input: Must be numerical value between 0 and 32767 \n");
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
            System.out.println("Animal \t Weight \t Name/Breed");


            //display current records
            if (animalArray[0] == null) {
                System.out.println("No Records \n");
            } else {
                for (i = 0; i < numOfRecords; i++) {
                    System.out.println(animalArray[i]);
                }
            }


            System.out.print(" 1. Add Bird \n 2. Add Dog \n q to quit \n");
            selection = input.next();


            if (selection.charAt(0) == 'q'){
                System.out.println("Bye - Team B: Will, Nick, David, Abir");
                System.exit(0);
            }

            //If selection = 1
            if (selection.charAt(0) == 49){



            }

            //if selection = 2
            else if (selection.charAt(0) == 50){


            } else System.out.println("Invalid input: Must be numerical value of 1 or 2 or q to quit \n"); main(args);
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




}//end of class Main