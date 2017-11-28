package com.GoupB;

/**
 * Created by abirfaisal on 2/3/15.
 */

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.*;

public class displayMenu {

    //returns value from 1-4 to signify a seleciton
    public static int mainMenu() {
        //Displays  main menu
        System.out.print("6.18 Check Password \n");
        System.out.print("6.21 Phone Keypad \n");
        System.out.print("6.27 EMIRP \n");
        System.out.print("6.29 Twin Primes \n");
        //get input
        Scanner b = new Scanner(System.in);
        int c = b.nextInt();

        //Check input
        if (c < 1 | c > 4) {
            System.out.print("Invalid Input \n");
            displayMenu.mainMenu();
        }
        return c;
    }
    // somone comment this too lazy
    public static char passwordMenu[]{
        System.out.print("Please enter your password");
        Scanner a = new Scanner(System.in);
        char b = a.next();
        return b;
    }
    
    
//Not sure if this is where you want it
    import java.util.Scanner;
    public static void phoneKeypadMenu(){
        public static void main(String[] args) {
		
	System.out.print("Enter a string: ");
	Scanner input = new Scanner(System.in);
	String Number = input.next();
	String output = "";
	
	for(int i = 0 ; i < Number.length() ; i++){
	char ch = Character.toUpperCase(Number.charAt(i));//converts lowercase to uppercase and returns char value
		if(Character.isLetter(ch)){//determines if character is a letter
			int digit = getNumber(ch);//if it is a letter it runs the getNumber method
			output = output + digit;}//end of if //character is converted and digit gets output
		else{
			 output = output + ch;}//end of else
			        }//end of for
			         
	System.out.println(output);
	
	input.close();
			    }//end of main
	
public static int getNumber(char upperCaseLetter){
    int number = 0;
	switch (upperCaseLetter) {
	case 'A':
	case 'B':
	case 'C':
	number = 2;
	break;
	case 'D':
	case 'E':
	case 'F':
	number = 3;
	break;
	case 'G':
	case 'H':
	case 'I':
	number = 4;
	break;
	case 'J':
	case 'K':
	case 'L':
	number = 5;
	break;
	case 'M':
	case 'N':
	case 'O':
	number = 6;
	break;
	case 'P':
	case 'Q':
	case 'R':
	case 'S':
	number = 7;
	break;
	case 'T':
	case 'U':
	case 'V':
	number = 8;
	break;
	case 'W':
	case 'X':
	case 'Y':
	case 'Z':
	number = 9;
	break;
	}
	return number;
	}//end of getNumber

    }//end of phonekeypads

    public static void EMIRPMenu(){

    }

    public static void twinPrimesMenu(){

    }
}
