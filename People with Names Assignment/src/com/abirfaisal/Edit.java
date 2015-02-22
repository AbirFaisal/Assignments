package com.abirfaisal;

import java.util.Scanner;

/**
 * Created by abirfaisal on 2/21/15.
 */
public class Edit {


    public static void editRecord(Person[] personArray){

        //ask user which record user wants to edit.
        // boolean to check if user wants to stop editing and end the program
        boolean stop = false;

        do {
            //Print out records to screen
            clearScreen();
            PrintRecords.print(personArray);

            System.out.print("\n " +
                    "Which record do you want to edit? \n" +
                    "Enter 0 to exit: \n");
            //get choice
            Scanner input = new Scanner(System.in);
            int i = input.nextInt();

            //remove
            System.out.print("\nlength= " + personArray.length + "\ni= " + i + "\n");

            if (i == 0){
                //exit
                System.out.print("Bye");
                System.exit(0);
            }
            //array bounds checking
            else if ((i < 0) || (i > personArray.length)) {
                System.out.print("\n Invalid Input \n");
                clearScreen();
                Edit.editRecord(personArray);
            } else {

                clearScreen();

                //Print record to be edited
                System.out.print("You are editing record #: " + i + "\n");
                System.out.printf("%s %s %s  %s  $%s \n",
                        personArray[i - 1].getName().getFirstName(),
                        personArray[i - 1].getName().getMiddleName(),
                        personArray[i - 1].getName().getLastName(),
                        PrintRecords.genderToMaleFemale((i - 1), personArray),
                        personArray[i - 1].getSalary());

                //Scanner
                Scanner in = new Scanner(System.in);

                //Request input
                System.out.print("Enter First Name \n");
                //Get and process input
                personArray[i-1].getName().setFirstName(in.next());

                //Request input
                System.out.print("Enter Middle Name \n");
                //Get and process input
                personArray[i-1].getName().setMiddleName(in.next());

                //Request input
                System.out.print("Enter Last Name \n");
                //Get and process input

                personArray[i-1].getName().setLastName(in.next());

                //Request input
                System.out.print("Enter " +
                        "M (M)ale  " +
                        "F (F)emale \n");
                //Get Input
                String gender = in.next();

                //Convert input to boolean
                if (gender.equals("M")){
                    //true
                    personArray[i-1].setGender(true);


                }else if (gender.equals("F")){
                    //false
                    personArray[i-1].setGender(false);

                }else {
                    System.out.print("Invalid Input: \n");
                    clearScreen();
                    Edit.editRecord(personArray);
                }

                //Request input
                System.out.print("Enter Salary: \n");
                //Get and process input
                personArray[i-1].setSalary(in.next());
            }
        }while (!stop);

    }


    public static void clearScreen(){
        for (int i = 0; i < 50; i++) {
            System.out.print("\n");
        }
    }

}
