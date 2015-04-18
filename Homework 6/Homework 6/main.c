#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define FREQUENCY_ARRAY_SIZE 26
#define MAX_BUFFER_SIZE 5000

	//A struct to hold all of my data.
	//Consider something to hold:
	//Lower case character
	//Upper case character
	//Count of the character seen
	//Frequency of the character seen
typedef struct
{
		//TODO: Fill this out
	double freq;
} letterFrequency;

	//This function initializes the letter frequency array.
void initFreqArray(letterFrequency *freqArray)
{
		//TODO: Fill this out
		//This should go through the array of 26 and set the following:
		//Upper case character (starts at 97 for 'A')
		//Lower case character (starts at 65 for 'a')
		//Count and frequency to 0
}

	//This function goes through a string and calculates the count of each letter in it.
void analyzeString(char *str, letterFrequency *freqArray, int *length)
{
		//TODO: Calculate length of the string (strlen is allowed).
	
		//TODO: For each character I need to check it against the array of 26.
}

	//This function goes through my array of letter frequencies to calculate the frequency total.
void calcFrequency(letterFrequency *freqArray, int totalCharCount)
{
		//TODO: Just a simple average of count for that character and total char count.
}

	//This function sorts my letter frequency array
	//I use bubble sort to sort it from largest to smallest by
	//the frequency element of the struct.
void sortFrequency(letterFrequency * freqArray)
{
	int i, j, min;
	letterFrequency temp;
	
	for (i = 0; i < FREQUENCY_ARRAY_SIZE - 1; i++)
	{
		for (j = 0; j < FREQUENCY_ARRAY_SIZE - 1; j++)
		{
			if (freqArray[j].freq < freqArray[j + 1].freq)
			{
				temp = freqArray[j];   //Use temperary variable to hold data
				freqArray[j] = freqArray[j + 1]; //Swap data part 1
				freqArray[j + 1] = temp; //Swap data part 2
			}
		}
	}
}

void main()
{
	char buffer[MAX_BUFFER_SIZE];
	FILE *fp;
	int lineLength = 0;
	int totalChars = 0;
	int lineCount = 0;
	int i = 0;
	letterFrequency freqArray[FREQUENCY_ARRAY_SIZE];
	
		//TODO: Open the text file here
	
	initFreqArray(freqArray);
	
		//TODO: Fill in this while loop
		//while ()
		//{
		//TODO: Pull the next string out
	
	analyzeString(buffer, freqArray, &lineLength);
	totalChars += lineLength;
	lineCount++;
		//}
	
		//Calculate and sort frequency
	calcFrequency(freqArray, totalChars);
	sortFrequency(freqArray);
	
		//Print statistics
	printf("Total Lines: %d\n", lineCount);
	printf("Average characters in a line: %lf\n", (double) totalChars / lineCount);
	
		//Print highest frequency characters
	for (i = 0; i < 6; i++)
	{
			//TODO: Output 	the frequency and character that was in the top 6
	}
	
	system("pause");
}