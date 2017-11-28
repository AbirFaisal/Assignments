
public class TwinPrimes {

	public static void main(String[] args) {
		printPrimeNumbers(35);	
	}
	
	public static void printPrimeNumbers(int numberOfPrimes) {
		//the constant and initializations are find for the functions
		final int NUMBER_OF_PRIMES_PER_LINE = 2;
		int count = 0;
		int number = 3;
		int countOne = 0;
		int numberOne = 5;
		
		while (count < numberOfPrimes && countOne < numberOfPrimes){
			//the program will display the primes in , for example, (#,#).
			if ( isPrime(number) && isPrime(numberOne)){
				count++;
				countOne++;
				if(count % NUMBER_OF_PRIMES_PER_LINE == 0 && count % NUMBER_OF_PRIMES_PER_LINE == 0){
					System.out.printf("(" + number + "," + numberOne + ")\n");
				}
				else
					System.out.printf("(" + number + "," + numberOne + ")\n");
			}
			number++;
			numberOne++;
		}
	}
	
	
	
	// Evaluates for each prime number so that the prime number will be displayed
	//to the user correctly
	public static boolean isPrime(int number) {
		for ( int divisor = 2; divisor <=number / 2; divisor++){
			if (number % divisor == 0){	
		return false;
			}
		}
		return true;
	}
	
	
	
	public static boolean isPrime1(int numberOne) {

		for ( int divisorOne = 2; divisorOne <=numberOne / 2; divisorOne++){
			if (numberOne % divisorOne == 0){	
		return false;
			}
		}
		return true;
	}//end main
}//end class
