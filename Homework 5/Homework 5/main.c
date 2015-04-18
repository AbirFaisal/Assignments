//
//  main.c
//  Homework 5
//
//  Created by Abir Faisal on 3/26/15.
//  Copyright (c) 2015 Abir Faisal. All rights reserved.
/*
 
 
 Create a new structure that holds the following:
 	ID number: unsigned integer
 	Name: char[100]
 	Account Balance: float
 	Year Joined: Integer
 
 
 Create an array of 6 of your new structure.
 Fill in your own values, this is test data.
 
 Print the following menu to the user:
 	Search by ID.
 	Search by Year Joined.
 	Exit
 
 
 Create three functions:
 	One that prints out details of the structure.  This should print the name, ID, account balance, and year joined.
 		void PrintData(myStruct *pData);
 	One that searches the array based on ID and returns the index if the entry is found, -1 otherwise.
 		int FindByID(myStruct mArray[], int size, int id);
 	One that searches the array for entries that joined in a particular year and prints every entry that it finds.  It returns the number of entries printed.
 		int FindAndPrintByYear(myStruct mArray[], int size, int yearJoined);
 
 
 All of these prototypes assume a struct named myStruct.  You would have to rename this to whatever you call your struct.
 
 If the user selects 1 from the menu:
 	Scan in the ID to search for.
 	Call the function that searches by ID.
 	If the ID was found (not -1), call the print data function to output that entry in the array.
 	If the ID was not found, let the user know.
 	Loop back and print the menu again.
 
 If the user selects 2 from the menu:
 	Scan in the year to search for.
 	Call the function that searches and prints by year.
 	Output how many entries were printed by that function.
 	Loop back and print the menu again.
 
 If the user selects 3, exit the loop and quit the program.
 
 
 USEFUL LIBRARY:
 
 #include <string.h>
 	This library contains several useful function for processing strings.
 
 strcpy_s(char *destination, char *source);
 	Copies the string from source to destination.
 	char mString[50];
 	strcpy_s(mString, “Hello world!\n”);
 	This function may be useful for setting strings to variables.



*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


typedef enum { false, true } bool;


	// Create a new structure that holds the following:
	// ID number: unsigned integer
	// Name: char[100]
	// Account Balance: float
	// Year Joined: Integer

const int sizeOfName = 100;
int i = 0;

typedef struct {
	unsigned int ID, year;
	char name[sizeOfName];
	float balance;
} Record;



	//clears screen using newline
void clearScreen(int lines){
		//String to hold \n
	char line[100] = "";
		//add newline characters
	for (i = 0; i < lines; i++) {
		line[i] = '\n';
	}
		//add null terminator
	line[i+1] = '\0';
		//Single print statement ensures that this function is not expensive
	printf("%s", line);
}



int main(int argc, const char * argv[]) {
	
	int input = 0;
	
		//Create an array of 6 of your new structure.
		// Fill in your own values, this is test data.
	Record records[6];
	
	
	
	
		//	Print the following menu to the user:
		// 	Search by ID.
		// 	Search by Year Joined.
		// 	Exit
	
	do {
	
		clearScreen(20);
	
		printf(" 1. Search by ID \n 2. Search by Year Joined \n 3. Exit \n Select option: ");
		scanf("%i", &input);

		printf("\n input: %i", input);
	
		clearScreen(5);
		
		if (input == 3) {
			return 0;
		}
		
	} while (1);
	

	
    return 0;
}











