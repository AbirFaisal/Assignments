//
//  main.c
//  Program B: Twin Prime Tester (twinprime.c)
//
//  Created by Abir Faisal on 3/4/15.
//  Copyright (c) 2015 Shekh Arefen. All rights reserved.
//


/*
 Program B: Twin Prime Tester (twinprime.c):
 
 Travis is easily amused by various math patterns. This week, his favorite pattern is what is
 known as twin primes. Twin primes are a pair of prime numbers that are exactly two apart. For
 example, 11 and 13 are twin primes, since they are both prime and are exactly 2 apart.
 (Remember, a prime number is a number not evenly divisible by anything except 1 and itself.)
 
 To entertain Travis for the week, you would like to write a program that will determine whether
 a given number is a twin prime with the prime number that comes next after it. Additionally,
 Travis might try to mess with you by entering a number that is not prime, so the first number
 you use in the pair should be the next highest prime number if the entered one is not prime.
 (Note the number entered will always be greater than 1.)
 
 Your program should have (and use) the following functions (written by you):
 // Pre­condition: value will be an integer greater than 1.
 // Post­condition: Returns true (1) if value is prime, or
 // false (0) otherwise.
 int isPrime(int value);
 
 
 // Pre­condition: current will be a positive integer greater than 1.
 // Post­condition: Returns the next prime number greater than or
 // equal to current.
 int nextPrime(int current);

*/


typedef int bool;
#define true 1
#define false 0




#include <stdio.h>
#include <math.h>


 // Pre­condition: value will be an integer greater than 1.
 // Post­condition: Returns true (1) if value is prime, or
 // false (0) otherwise.
bool isPrime(int value){
	
	
	int i;
	
		//incase user enters 2
	if (value == 2) {return false;}
	
	
	for (i=2; i <= (value/2); i++) {
		
		if (value % i == 0) {
			return false;
		}
	}
	return true;
}



 // Pre­condition: current will be a positive integer greater than 1.
 // Post­condition: Returns the next prime number greater than or
 // equal to current.
int nextPrime(int current){
	
		//make sure current is positive interger greater than 1
	
	
	
	int i = 0;
	int limit = current;
	
		//test if any of the next 2 numbers are prime
	for (i=limit; i < (limit+3); i++) {
		
			//add 1 to current prime value
		current++;
		
			//if is prime do somthing
		if (isPrime(current)) {

				//return the twin prime
			return current;
		}

	}
	
	return false;
}





int main(int argc, const char * argv[]) {
	
	
	int input = 3;
	int twinPrime = 5;
	
	
	
	printf("Enter a Number \n");
	scanf("%d", &input);
	
		//make sure input is not negative
	input = abs(input);
	
	
	
	while (isPrime(input) == false) {
		input++;
	}
	
		//Test if prime
	if (isPrime(input)) {
		
			//print current prime
		printf("%d is a prime number. \n", input);
		
		
			//print twin prime
		twinPrime = nextPrime(input);
		
		
			//if twin prime does not return false
			//else tell user that input does not have a twin prime
		if (twinPrime != false) {
			printf("%d is the twin prime of %d \n", twinPrime, input);
		}else{
			printf("%d does not have a twin prime. \n", input);
		}
		
		
	}
	
	
    return 0;
}





















