// <18973, Nishant Sharma> [No longer active]

// <nishant.sharma@vit.ac.in> [No longer active]


/* 

 * Motivation: ->

 * -> Our objective is to take a stream of input [that ends with a newline] from the user during run-time and tell the frequency of occurrence of each word in the string.

 */


/*

 *  Early thoughts: Our input will be broken down into words that are separated by space " ", and those words can be considered as individual strings.

 */


import java.util.*;

import java.io.*;

public class SampleMap{

	public static void main(String args[]){

		// Map<String, Integer> map = new Map<String, Integer>();

		/*

		* When I try to instantiate the Map class, i get the familiar error same as instantiating the List Class.

		* error: Map is abstract; cannot be instantiated

		Map<String, Integer> map = new Map<String, Integer>();

		*/


		/*

		* Solution: Instantiate a non abstract inherited subclass of the generic Map class.

		* --> One of those subclasses is HashMap 

		*/

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		// Now, let us take the input from the console

		// --> Remember the analogy of a stream of river flowing [console input] and we take a bucket of water [buffer].

		// --> This time, we do not store it into the large water tank in the house [file].

		// --> Instead, we read characters until they are separated by " ", and read words until they end with a newline character.


		/*

		* Let us provision for the use of console stream input, and then create a buffered reader.

		* => Refer Filehandling lecture notes for a more elaborate explaination.

		*/

		InputStreamReader isr = new InputStreamReader(System.in);

		BufferedReader br = new BufferedReader(isr);


		// Enter the stream of text on the console input.


		System.out.println("Enter the stream of text that you want to sample: ->");

		char read = ' ';

		int count = 0;

		char word[] = new char[100];


		// Run forever, break only when you encounter a newline character.

		while (true){

			// All stream and buffered reading from the console must be done under try and catch functionality. 

			try{

				read = (char) br.read();

   				/* if we encounter the newline character, 

				* -> we should first update the hasmap for the last word entered.

				* -> Then we must break from the forever running while loop.

				*/

				if (read == '\n'){

					// Assigning the last character to null character, makes converting a character array into String same as C++

					word[count] = '\0';

					// Make a string out of the characters received after the last space and the enter key.

					String wordString = new String(word);

					/*

					* If the map already contains our word, then we must update its value to whatever was its previous value + 1.

					*/

					if (map.containsKey(wordString)){

						map.put(wordString,map.get(wordString)+1);

					}

					/*

					* If it is the first occurrence of our word, then we must make an entry of this word in our hashmap with value 1.

					*/

					else{

						map.put(wordString, 1);

					}

					// Finally, we must break from the forever running for loop.

					break;

				}

				else if (read == ' '){

					/*

					* If we discovered a space in between, then 

					* --> We must update the map with the word between the last space and this space.

					* --> Make provision to create a new word starting from this space onwards.

					*/


					// Making the last character of the word as null character makes making a string out of this character array same as C++

					word[count] = '\0';

					String wordString = new String(word);

					/*

					* If the map already contains the word (key), then we must update its value to whatever was its previous value + 1.

					*/

					if (map.containsKey(wordString)){

						map.put(wordString,map.get(wordString)+1);

					}

					// Otherwise, we must create an entry for the previous word in the map and assign its value as 1.

					else{

						map.put(wordString, 1);

					}

					/* We make a provison to count the next word from this space onwards.

					* --> To do this, 1. we reset count to 0 stating that from now onwards a new word must be found till the next space.

					* 2. That new word will be stored in the word character array and must not exceed 100 characters in length.

					*/

					count = 0;

					word = new char[100];

				}

				else{

					// If it is not a space or a newline character, keep on reading and updating into word array; there is nothing more to be done.

					word[count]= read;

					count++;

				}

			}

			catch (IOException ioe){

				ioe.printStackTrace();

			}

		}

   		// Now print the occurrence of each word in the input string.

		// This next method map.keySet() returns the keys in our map. It is useful to print key and value on the console.

		// --> I google this for convenience.

		Set<String> keys = map.keySet();

		for (String key: keys){

			System.out.println("Key: -> "+key+ " Value: -> "+map.get(key));

		}
	
	}

}
