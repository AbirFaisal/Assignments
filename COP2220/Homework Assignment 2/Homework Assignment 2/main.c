//
//  main.c
//  Homework Assignment 2
//
//  Created by Abir Faisal on 1/22/15.
//  Copyright (c) 2015 Abir Faisal. All rights reserved.
//
/* Homework Assignment 2
 Create a menu of vacation destinations for the user:
 Select 1 if you would like to go to Paris.
 Select 2 if you would like to go to Rome.
 Select 3 if you would like to go to London.
 Select 4 if you would like to go to Amsterdam.
 Select 5 if you would like to go to Nairobi.
 Once they make a selection, have the user input the year they want to go.
 Using a switch statement create the following output:
 You have chosen to go to….in the year…..
 Replace the ….. With the destination they selected and year they input.
 If they make an invalid selection, let them know and exit the program.
*/

#include <stdio.h>

int main(int argc, const char * argv[]) {
	
		//String array
	char *prompt[] = {
		"Paris",
		"Rome",
		"London",
		"Amsterdam",
		"Nairobi"
	};
	
		//Var for number of strings
	int numberOfStrings = (sizeof(prompt)/sizeof(prompt[0]));
	
		//For loop to go through string array and display strings on each line
	for (int i = 0; i < numberOfStrings; i++) {
		printf("Select %d if you would like to go to: %s\n", i+1, prompt[i]);
	}
	
		//Double incase user is dumb and inputs a floating point number for the selection
	double selection = 0;
	double year = 0;
	
		//Input Selection
	printf("Selection:");
	scanf("%lf", &selection);
	
		//Arrays start with 0 for the first element so we just subtract 1 here.
	selection = selection - 1;
	
		//Input Selection
	printf("What year would you like to go?: ");
	scanf("%lf", &year);
	
		//Switch
	switch ((int)selection) {
  case 1:
			printf("You have chosen to go to %s in the year %i\n", prompt[(int)selection], (int)year);
			
			break;
  case 2:
			printf("You have chosen to go to %s in the year %i\n", prompt[(int)selection], (int)year);
			
			break;
  case 3:
			printf("You have chosen to go to %s in the year %i\n", prompt[(int)selection], (int)year);
			
			break;
  case 4:
			printf("You have chosen to go to %s in the year %i\n", prompt[(int)selection], (int)year);
			
			break;
  case 5:
			printf("You have chosen to go to %s in the year %i\n", prompt[(int)selection], (int)year);
			
			break;
  default:
		// Due to limitations in the assignment if more
		// cities were to be added to the array then this will comphensate
			if (selection > numberOfStrings) {
				printf("Invalid input \n");
			}
			else{
				printf("You have chosen to go to %s in the year %i\n", prompt[(int)selection], (int)year);
			}
			break;
	}
	return 0;
}
