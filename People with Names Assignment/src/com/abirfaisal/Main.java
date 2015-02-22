package com.abirfaisal;


/*

Create a program that has at least three classes.
1. The class with main.
2. A class that defines a name (first name, middle name, and last name)
3. A class that defines a person (name, gender, age, and salary)
4. You will define all setters and getters, constructors and toString methods

The program will create and populate at least three different people.
The program will allow a user to change the fields for a person.
The program will output all three people.

Rules:
1. Gender must equal M or F only.
2. Age must be between 1 and 120.
3. Salary must be a positive number.
4. The first and last name must be in sentence case.
5. A middle name is optional (the code will account for this)

You will turn in your zipped up project and your class UML(s).
*see page 324*

 */


public class Main {

    public static void main(String[] args) {

        //Create array of Person type
        Person[] personArray = new Person[500];

        //Initialize records
        initalizeRecords(personArray);

        //Start Editor
        Edit.editRecord(personArray);

    }


    //Initialize records
    private static void initalizeRecords(Person[] personArray){

        for (int i = 0; i < personArray.length; i++) {

            Name name = new Name("John", "Mochafrapachino", "Smith");

            boolean gender = Math.random() < 0.5;

            String salary = String.valueOf((int)(Math.random() * 100000));

            String age = String.valueOf((int) (Math.random() * 100));

            personArray[i] = new Person(name, gender, age, salary);


        }
    }
}