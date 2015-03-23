package com.GroupB;

public class Main {

    public static void main(String[] args) {


            //Create array of Animal type
            Animal[] animalArray = new Animal[2];

            //Initialize records
            //initalizeRecords(animalArray);

            //Start Editor
            Edit.editRecord(animalArray);

    }

//
//    //Initialize records
//    private static void initalizeRecords(Animal[] animalArray){
//
//        for (int i = 0; i < animalArray.length; i++) {
//
//            Name name = new Name("John", "Mochafrapachino", "Smith");
//
//            boolean gender = Math.random() < 0.5;
//
//            String salary = String.valueOf((int)(Math.random() * 100000));
//
//            String age = String.valueOf((int) (Math.random() * 100));
//
//            animalArray[i] = new Animal(name, gender, age, salary);
//
//
//        }
//    }

}
