//
//  main.c
//  Homework 1
//
//  Created by Abir Faisal on 1/16/15.
//  Copyright (c) 2015 Abir Faisal. All rights reserved.
/*
 The goal of this assignment is to verify that you can get code up and running.
 Create a program that outputs your name and one of your favorite hobbies.
 Program must also create the following variables:
 X – short, equal to 10
 Y – int, equal to 3
 Z – double
 Assign x to equal 10, Y to equal 3. Perform a calculation where z = x / y and no data is lost.
 You do not have to output this value.
 */

#include <stdio.h>

int main() {

	printf("Abir Faisal - Watching Southpark");
	
	short X = 10;
	int Y = 3;
	double Z;
	
	X = 10;
	Y = 3;
	Z = (double)X / (double)Y;
	
    return 0;
}