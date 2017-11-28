//
//  main.c
//  Extra Credit Homework 1
//
//  Created by Abir Faisal on 2/19/15.
//  Copyright (c) 2015 Abir Faisal. All rights reserved.
//

/*
 This is an extra credit homework assignment that you have available for this week only.  The objective:
 
 Create a function that sorts an array of DOUBLES from smallest to largest.  You can either have the user input data into an array of doubles or hard code it yourself (if you hard-code the values make sure they are not already sorted).  The array should contain 5 doubles.
 
 The function should take in the array of doubles, sort it by either method we discussed, and print the array to the screen.  Do NOT worry about returning the sorted array from the function.
 
 Watch Section 3 of this week's videos for more information.
*/



#include <stdio.h>
#include <stdbool.h>
#include <string.h>

int main(int argc, const char * argv[]) {
	
		//array to store values
	const int SIZE = 5;
	double array[SIZE];// = {5,4,3,2,1};
	
	double swap = 0;
	
	for (int i=0; i < SIZE; i++) {
		printf("Enter a number \n");
		scanf("%lf", &array[i]);
	}
	
	
	
		//bubble sort number times to pass
	for (int i = 0; i < (SIZE-1); i++) {
			//Pass through the array
		for (int d = 0; d < (SIZE-1); d++) {
				//test if next element is greater than current element
			if (array[d] > array[d+1]) {
					//hold current element
				swap = array[d];
					//give element the value of the next element.
				array[d] = array[d+1];
					//give the next element the value of swap
				array[d+1] = swap;
			}
		}
	}
	
	
	
	printf("Sorted from smallest to greatest \n");
	
	for (int i = 0; i < SIZE; i++) {
		printf(" %f \n", array[i]);
	}
	
	
	return 0;
}
