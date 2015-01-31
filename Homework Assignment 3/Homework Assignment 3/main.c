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

int main() {
	
	int INPUT_SIZE = 1024;	//input array size
	char input[INPUT_SIZE];			//input array
	
		// initalize input[] elements to 128
		// there are 127 characters in ascii table so the value 128 can be used to check for input in the element.
	for (int i = 0; i < INPUT_SIZE; i++) {
		input[i]=127;
	}
	
		//Prompt User for input
	printf("Enter a string less than 1000 characters in length: \n");
	scanf("%s", input);
	
		//Make everything uppercase because in the ASCII Table 'a' and 'A' are different values
	for (int i = 0; input[i]; i++) {
		input[i] = (int)toupper(input[i]);
	}
	
	

	
		//go through array and check if element matches E, T, A, O, I, N, or S
	int match[7]; // array to count and store matches
	int lettersAsIntegers[6] = { (int)'E' , (int)'T' , (int)'A' , (int)'O' , (int)'I' , (int)'N' , (int)'S'};
	for (int i = 0; i < INPUT_SIZE; i++) {
				//If element matches then add 1 to the value of the element in
			switch ((int)input[i]) {
				case (int)'E':
					match[0] = match[0] + 1;
					break;
					
				case (int)'T':
					match[1] = match[1] + 1;
					break;
					
				case (int)'A':
					match[2] = match[2] + 1;
					break;
					
				case (int)'O':
					match[3] = match[3] + 1;
					break;
					
				case (int)'I':
					match[4] = match[4] + 1;
					break;
					
				case (int)'N':
					match[5] = match[5] + 1;
					break;
					
				case (int)'S':
					match[6] = match[6] + 1;
					break;
					
				default:
					break;
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
	printf("%i \n", (int)input[0]);
	while (input[stringLength] != 127) {
		stringLength++;
	}
		//Arrays start with 0 so subtract 1 from stringLength
	stringLength = stringLength - 1;

		//If user enters more than 1000 characters or didnt enter anything then call main.
	if (stringLength > 1000) {
		main();
	}else if (stringLength == 0){
		main();
	}

		//Go through array that has occurences stores
	for (int i=0; i < 7;i++) {
		double frequency = (double)match[i]/(double)stringLength;
		printf("The letter occured %f \n", frequency);
	}
	

	return 0;
}