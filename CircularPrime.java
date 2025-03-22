// <18973, Nishant Sharma> [No longer active]

// Email: nishant.sharma@vit.ac.in [No longer active]

// To do in class: Lab 12/09/2022.


// Objective: => To find if a number is circular prime:

// For a number like 1193 to be circular prime, 3119, 9311 and 1931 should also be prime in addition to 1193 being prime.


import java.lang.Math;

public class CircularPrime{

	/*

  		The method is_prime [without any optimization] helps determine whether a number input to this method is prime or not. 

	*/

	boolean is_prime(int number){

		assert(number>=2):"Number should be greater than 2";

		if(number==2){

			return true;

		}

		else{

			for(int counter = 2; counter<number; counter++){

				if (number%counter==0){

					return false;

				}

			}

			return true;

		}

	}


	/*

 		A power method to return base^ raised.

	*/

	int power(int base, int raised){

		int result = 1;

		for(int counter=0; counter<raised; counter++){

			result*=base;

		}

		return result;

	}


	/*

		To calculate the length of a number > 0 [Natural numbers]:

		=> Uses the fact that log10(1) = 0, log10(10) = 1, log10(100) is 2, and so on. Also, log10(Number between 10 and 100 exclusive) lies between 1 and 2.

	*/

	int length (int number){

		return (int) Math.log10(number) + 1;

	}


	/*

		A method circular_shift_one_digit which takes the last digit of the number and appends it to the first position in the number while essentially right shifting the other digits keeping their same digit order.

	*/

	int circular_shift_one_digit(int number){

		int result=0;

		int remainder = number%10;

		int chopped_off_number = number/10;

		result = result + remainder*power(10, length(chopped_off_number))+chopped_off_number;

		return result;

	}


	/*

		The method is_circular_prime uses the circular_shift_one_digit method to repeatedly shift the input number one digit and check if the resultant is also prime. This is done until, we reach the same number on shifting as we started. If all numbers encountered during the shifting process are prime, then our input number is circular prime. Otherwise, we print the culprit that was not prime.  

	*/

	boolean is_circular_prime(int number){

		int orig_number = number;

		int new_number;

		if (!is_prime(number)){

			System.out.println("This number "+number+" is the culprit!");

			return false;

		}

		else{

			do{

				new_number = circular_shift_one_digit(number);

				if (!is_prime(new_number)){

					// Uncomment this line to see which one-digit circular shift caused the process to fail
					// System.out.println("This number ->"+new_number+"<- is the culprit!");

					return false;

				}

				number = new_number;

			}while(new_number!=orig_number);
		}

 		return true;

	}

    
	public static void main(String args[]){

		CircularPrime obj = new CircularPrime();

		// Comment for instructor

		// System.out.println(obj.is_prime(31));

		// System.out.println(obj.length(23456));

		// System.out.println(obj.power(3,4));

		// System.out.println(obj.circular_shift_one_digit(1193));


		// 1193 is circular prime.

		System.out.println("It is "+ obj.is_circular_prime(1193) + " that the number ->" + 1193 + "<- is circular prime.");

		//  23 is not circular prime. While 23 is prime, 32 is not.

		System.out.println("It is "+ obj.is_circular_prime(23) + " that the number ->" + 23 + "<- is circular prime.");

	}

}
