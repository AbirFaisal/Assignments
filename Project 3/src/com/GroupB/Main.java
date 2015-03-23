package com.GroupB;

public class Main {

    public static void main(String[] args) {

        public static void main(String[] args) {

            //Create array of Person type
            Person[] personArray = new Person[5];

            //Initialize records
            initalizeRecords(personArray);

            //Start Editor
            Edit.editRecord(personArray);

        }
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
