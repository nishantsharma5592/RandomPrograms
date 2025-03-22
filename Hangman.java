// <18973, Nishant Sharma> [No longer active]

// Email: nishant.sharma@vit.ac.in [No longer active]

/*

 * Wikipedia: =>

 *  Hangman is a guessing game for two or more players. One player thinks of a word, phrase or sentence and the other(s) tries to guess it by suggesting letters within a certain number of guesses. 

 *  Originally a Paper-and-pencil game, there are now electronic versions.

 */


/*

 * The computer will choose a word (at random) and we have to guess the word by suggesting letters with a certain number of tries. 

 * Let's calculate the no_of_chances as a function of chosen word. Let no_of_chances = length(chosen word)/2; 

 */



import java.util.Random;

import java.util.Scanner;


public class Hangman{

	// We assign name of fruits as words to guess. All characters are lowercase.

	String words[] = {"apple", "mango", "banana", "jackfruit", "peaches", "grapes", "coconut"};

	String word;

	String underscores;

	int no_of_chances;


	// When the constructor is invoked, a random number between 0 and length of words is generated using Math.random function. 

	Hangman(){

		Random random = new Random();

		// Choose a random index between 0 and length of the words string array.

		int index = random.nextInt(words.length);

		word = words[index];

		// System.out.println(word);

		no_of_chances  = (int) word.length()/2 + 1; // Notice the difference in the call to length function for a string or a string array.


		// We will use the string builder class to create as many underscores as there are letter in our chosen word

		StringBuilder sb = new StringBuilder();

		sb.setLength(word.length());

		for (index = 0; index<word.length(); index++){ // Index is already initialized above in this constructor

			sb.setCharAt(index,'_');

		}

		underscores = sb.toString();

		// System.out.println(underscores);

	}


	void display(String current){

		for (int index = 0; index<current.length(); index++){

			System.out.print(current.charAt(index)+" ");

		}

		System.out.println();

	}

	// This is the controller of the game

	// Since, we need to take input again and again, i pass as input to game method an object of the scanner class.

	void game (Scanner sc){

		if (no_of_chances == 0){

			System.out.println("You lose!");

			System.out.println("The word was: ->"+word+"<-");

			return;

		}

		// Ask for a guess from the user

		char newAttempt;

		System.out.println("Your chances: ->"+no_of_chances+"<-");

		System.out.println("Enter the new attempt: ");

		newAttempt = sc.next().charAt(0); 


		// If the word does not contain the character input by the user, then decrement the number of chances left in the game.

		if (word.indexOf(newAttempt)==-1){

			no_of_chances-=1;

		}

		// If the previously built underscore string already contains that character then skip

		else if(underscores.indexOf(newAttempt)!=-1){

			display(underscores);

		}

		else{

			// Take the previously built underscores string that contains all correct previous attempts.

			StringBuilder sb = new StringBuilder(underscores);

			// In that previously built underscores string, replace all places in the underscore string with input from the user where it occurs in our chosen word. 

			for (int index = 0; index<word.length(); index++){

				if (word.charAt(index)==newAttempt){

					// Replace the underscore with the input from the user

					sb.replace(index, index+1, String.valueOf(newAttempt));

				}

			}

			underscores = sb.toString();

			display(underscores);

			// After filling up the underscores string, test if it has become equal to the chosen word

			if (word.equals(underscores)){

				System.out.println("You won!");

				return;

			}

		}


		// Call game recursively until the game terminates

		game(sc);

		}


	public static void main(String args[]){

		Hangman obj = new Hangman();

		Scanner sc = new Scanner(System.in);

		System.out.println("Game Started! Word to Guess: =>");

		obj.display(obj.underscores);

		obj.game(sc);

	}

}
