package com.abirFaisal.chapter1Assignment; //The IDE put this here I have no idea what this does.
//I could probably look it up but I'm far too lazy.

public class Main {

    public static void main(String[] args) {
        //1.1 (Display three messages) Write a program that displays Welcome to Java,
        //Welcome to Computer Science, and Programming is fun.
        System.out.println("Welcome to Java.");
        System.out.println("Welcome to Computer Science.");
        System.out.println("Programming is fun.");
        System.out.println();

        //1.2 (Display five messages) Write a program that displays Welcome to Java five times.
        for (int i = 0; i < 5; i++) {
            System.out.println("Welcome to Java.");

            //Print new line after loop finishes
            if (i == 4) {
                System.out.println();
            }
        }

        //1.3 (Display a pattern) Write a program that displays the following pattern: JAVA
        System.out.println("    J     A   V     V   A");
        System.out.println("    J    A A   V   V   A A");
        System.out.println("J   J   AAAAA   V V   AAAAA");
        System.out.println(" J J   A     A   V   A     A");

    }
}
