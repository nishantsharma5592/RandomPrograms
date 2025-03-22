/*

	<18973, Nishant Sharma> [No longer active]

	Email: nishant.sharma@vit.ac.in [No longer active]

*/


/*

 *   Sieve is what we call chchanani in Hindi!

 *   The idea is we put flour along with husk on top of the sieve.

 *   If the element (flour grains) fulfills the criteria to pass through the pores in the Sieve, then those elements go through the pores and are added to the freshpan collecting flour without husk.

 */



/*

 * First we create an ArrayList named Sieve that contains all numbers between 2 and 600. We create another Arraylist called Freshpan that contains all elements that are prime (that passed through the criteria of the Sieve).

 *

 * $$ Criteria: I look at what passed through the Sieve. If any element that remains on the Sieve list is composed of something that is present on the fresh pan then it is bigger than what could pass through the sieve. In more complex words, it is not an atomic, rather composite element. 

 *

 *

 */



import java.util.*;


public class SievePrime{

	ArrayList<Integer> Sieve =  new ArrayList<Integer>(599);

	ArrayList<Integer> Freshpan = new ArrayList<Integer>();


	// Here we are making a generalized method to print some array list given the name of the array list as a string argument for more clarity

	void display(ArrayList<Integer> some_array_list, String name_of_array_list){

		System.out.println("Printing ArrayList "+name_of_array_list+": \n");

		for (int index = 0; index<some_array_list.size(); index++){

			System.out.print(some_array_list.get(index)+ " ");

		}

		System.out.println("\n");

	}


	boolean canPassThroughPores(int element, ArrayList<Integer> Freshpan){

		// When the pan is empty, we have no criteria.

		// We allow the element to pass through the pores.

		// Fortunately 2 is already a prime number, so we are lucky.

		if (Freshpan.isEmpty()){

			return true;

		}

		// Otherwise, look what passed through the pores from the Sieve to the Freshpan and see if the input element is composite i.e. consisting of any of the Freshpan elements as one of its components.

		else{

			for (int index = 0; index<Freshpan.size(); index++){

				if (element%Freshpan.get(index)==0){

					return false;

				}

			}

			return true;

		}

	}


	public static void main(String args[]){

		SievePrime obj = new SievePrime();

		for (int count = 2; count<=600; count++){

			obj.Sieve.add(count);

		}


		// If someone wants to verify that Sieve is correctly populated:

		// obj.display(obj.Sieve, "Sieve");


		// Start shaking the chchanani

		int index = 0;

		do{

			if (obj.canPassThroughPores(obj.Sieve.get(index),obj.Freshpan)){

				obj.Freshpan.add(obj.Sieve.get(index));

				obj.Sieve.remove(index);

			}

			else{

				index++;

			}

		}while (index<obj.Sieve.size());


		// After shaking the flour (prime elements) should be added to the Freshpan and the husk (non prime elements) should have remained on the Sieve.


		obj.display(obj.Freshpan,"Freshpan");

		obj.display(obj.Sieve,"Sieve");

	}

}
