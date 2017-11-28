//
//  main.c
//  Homework Assignment 4
//
//  Created by Abir Faisal on 3/3/15.
//  Copyright (c) 2015 Abir Faisal. All rights reserved.
//

	/////////////////
	// Assignment: //
	/////////////////
/*
 Review using random functions (srand and rand) in C.
 
 Create a function that takes in the following:
	- Health – Double
 	- Armor – Double from 0 to 1.
	- Minimum Damage – Unsigned integer.
	- Maximum Damage – Unsigned integer.

 The function calculates how much damage is dealt to the player.
	- Use the random functions to pick a random number between the minimum and maximum damage.
	- Multiply the damage by (1-Armor) and subtract the new value from health.
	- Output the new health value, how much damage was dealt (double), and a 1 if the player is still alive (health > 0) or 0 if not.
 
 Allow the user to enter the health value, armor value, min damage, and max damage to be used in your function.
 	- Run a simulation that calls the function until the player’s health drops below 0.
	- Every time the function is called, output the results it produces.
 
 HINT: You want to call srand in your main function ONCE.
 Then call rand() in your new function.
 
 HINT: Your new function will pass some of the variables by reference so that it can also output them.
 
 HINT: In Unit 1->Week 3->Section 2 there was a problem to solve using random numbers.  Go back and review how this works.
 
 You will need to use modulus operators and addition to constrain the number returned by rand() to [min damage, max damage].
 */

	//make bool type because lazy
typedef int bool;
#define true 1
#define false 0



#include <stdio.h>
#include <stdlib.h>
#include <time.h>

	//funciton
double getDamage(double *health, double armor, int minDamage, int maxDamage){
	
	double damage = 0.0;
	
		//get damage
	damage = rand() % (maxDamage - minDamage + 1) + minDamage;
	
	if (armor != 1) {
		damage = (1-armor) * damage;
	}
	
	*health = *health - damage;
	
	return damage;
}


int main(int argc, const char * argv[]) {
	
		//random seed srand
	srand((unsigned) time(NULL));

		//Current player's health as both input into the function and output (has damage subtracted from it).
	double health = 1;
	double initalHealth = 1;
	double healthPercent = 100;

	
		//Armor modifier input into the function.
	double armor = 1;

		//minimum damage
	unsigned int minDamage = 1;

		//maximum damage
	unsigned int maxDamage = 1;
	
		//incurred damage
	double damage = 0;

		//default to player alive
	bool alive = true;
	
	
		//get input
		// Allow the user to enter the health value, armor value, min damage, and max damage to be used in your function.
	printf("Enter player health\n");
	scanf("%lf", &health);
	initalHealth = health;
	
	printf("Enter player armor\n");
	scanf("%lf", &armor);
	
		//armor cant be more than 1
	if (armor > 1) {
		armor = 1 / armor;
	}
	
	printf("Enter player minimum damage\n");
	scanf("%i", &minDamage);

	printf("Enter player maximum damage\n");
	scanf("%i", &maxDamage);
	
		//swap if min is greater than max
	if (minDamage > maxDamage) {
		int temp = maxDamage;
		maxDamage = minDamage;
		minDamage = temp;
	}

	
		//while player is alive
	while (alive) {
		
			//get and incure damage
		damage = getDamage(&health, armor, minDamage, maxDamage);
		
			//get health percentage
		healthPercent = (health/initalHealth)*100.0;
		

		if (health > 0) {
			printf("Player health: %6.2lf (%6.2lf%%)     Damage: %6.2lf     Alive: true \n" ,health, healthPercent, damage);
		}
		
		
		if (health <= 0) {
			alive = false;
			printf("Player health: %6.2lf (%6.2lf%%)     Damage: %6.2lf     Alive: false \n" ,health, healthPercent, damage);
		}
	}
	
	return 0;
}




















