// <18973, Nishant Sharma> [No longer active]

// nishant.sharma@vit.ac.in [No longer active]

// Objective: => Translate a string l positions modulo 26 similar to Graded Assignment 1 and 2;


public class CaesorString{

	// Translate the input string translation positions modulo 26 <=> and return me the translated string.

	// => Assumption: All characters in the string are lowercase.

	String translate (String str, int translation){

		// String is a immutable type and thus cannot be modified like an array can be

		// So, we need to create a new StringBuilder object that:

		// => can be modified;

		// => and, that can later be converted into a new string;

		StringBuilder newStr = new StringBuilder();

		newStr.setLength(str.length());

		for(int i = 0; i<str.length(); i++){

			// We find the character at current position i

			char character = str.charAt(i);

			// The newCharacter stores the translated character.

			char newCharacter;

			// If a space comes, ignore

			if (character == ' '){

				newCharacter = ' ';

				newStr.append(newCharacter);

				continue;

			}

			// Translation as modulo n  can only happen if we are in the scale 0 to n-1

			// => So we must make:

			// the relative_position_from_character_a for character 'a' as 0

			//   for character 'z' as 25

			// => Then we can translate that character translation steps modulo 26

			int relative_position_from_character_a = character - 'a';

			// Here we do the translation modulo 26

			int after_translation = (relative_position_from_character_a + translation)%26;

			// Then we find the newcharacter after_translation steps from 'a'

			newCharacter =(char) ('a' + after_translation);

			// We append each translated character at correct position in our newStr: =>

			newStr.append(newCharacter);

		}

		// Finally, we make a string from our newly populated StringBuilder object 

		return newStr.toString();

	}

	public static void main(String args[]){

		CaesorString obj =  new CaesorString();

		System.out.println("hello world, translated by 18 positions (modulo 26) is ->"+obj.translate("hello world", 18)+"<-.");

	}

}
