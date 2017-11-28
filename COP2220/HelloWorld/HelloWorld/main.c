//
//  main.c
//  HelloWorld
//
//  Created by Abir Faisal on 1/15/15.
//  Copyright (c) 2015 Abir Faisal. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include "pause.h"

int main() {
	printf("Hello, World!\n");
	
	//system("pause"); // Windows only
	//printf("press any key"); getchar(); //ghetto workaround for OSX
	
	pause(); //ghetto workaround as a function
	
	return 0;
}
