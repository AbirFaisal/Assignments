//
//  main.c
//  Homework Assignment 3
//
//  Created by Abir Faisal on 1/29/15.
//  Copyright (c) 2015 Abir Faisal. All rights reserved.
/*
 In English, the most commonly used letters are e, t, a, o, i, n, s in that order.
 
 Ask the user to input a string that is less than 1000 characters in length.
 
 Go through the string and calculate the frequency of each letter above (e, t, a, o, i, n, s) that was entered.
 
 Frequency would be total count of the letter / number of characters in the string.
 
 Number of characters entered does not necessarily equal 1000.
 
 It is recommended to use an array to store this frequency.
 
 Also note, case should not matter.  ‘a’ and ‘A’ are equivalent.
 
 Output the frequency of each letter calculated.
 */


#include <stdio.h>
#include <ctype.h>
#include <string.h>

int main() {
		//Why doesnt this compile for you? It works fine for me.
	const int INPUT_SIZE = 1000;	//input array size
	char input[INPUT_SIZE];			//input array
	
		// initalize input[] elements to 127
		// there are 127 characters in ascii table so the value 127 can be used to check for input in the element.
	for (int i = 0; i < INPUT_SIZE; i++) {
		input[i]=127;
	}
	
		//Prompt User for input
	printf("Enter a string less than 1000 characters in length: \n");
		//fgets because some platforms dont handle printf the same way.
	fgets(input, 999, stdin);
	

	
		//Make everything uppercase because in the ASCII Table 'a' and 'A' are different values
	for (int i = 0; input[i]; i++) {
		input[i] = (int)toupper(input[i]);
	}

	
		//go through array and check if element matches E, T, A, O, I, N, or S
		// Array to count and store matches
		// We initalize the match[] array because in release mode xcode does not initalize arrays[]
	int match[7] = { 0 };
		// Array to store letters we want to match
	char letters[7] = { 'E' , 'T' , 'A' , 'O' , 'I' , 'N' , 'S' };
	for (int i = 0; i < INPUT_SIZE; i++) {
			//Test if input[current element] == letters
			//Since i is within the scope if this for loop we use e instead
		for (int e = 0; e < 7; e++) {
			if (input[i] == letters[e]) {
				match[e] = match[e] + 1;
			}
		}
	}
	
		//Calculate string length by subtracting the number of
		//elements above 127 from the INPUT_SIZE
		//Before we initalized all elements of input[] to 128 since there are 127 characters in the ascii table.
		//This while loop will end when the element of input[] equals 128.
		/*
		 input[]
		   0   1   2   3   4   5
		 -------------------------
		 | A | B | C |127|127|127|
		 -------------------------
		 When we detect the number 127 we know we have reached the end of the string.
		 */
	int stringLength = 0;
	while (input[stringLength] != 127) {
		stringLength++;
	}
		//Arrays start with 0 so subtract 1 from stringLength
		//subract 1 more to remove null terminator \0
	stringLength = stringLength - 2;
	
		//If user enters more than 1000 characters then call main.
	if (stringLength > 1000) {
		main();
	}

		//Go through array that has occurences and calculate frequency of that letter.
	for (int i=0; i < 7;i++) {
		double frequency = (double)match[i]/(double)stringLength;
		printf("%c: %f \n", letters[i], frequency);
	}
	

	return 0;
}