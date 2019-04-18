/* AUTHOR: Alyssa Gibson
 * CLASS: CSC210- Data Structures and Algorithms / Fall 2018
 * ASSIGNMENT: Design a PEZ dispenser using a doubly linked list.
 * CREATED: September 21st, 2018
 * MODIFIED: September 22nd, 2018
 */

import java.util.Random;	// used to generate random numbers

public class Main {
	// This class contains:
	// MAIN METHOD (Lines 14-58): executes the program.
	
	public static void main(String[] args) {
		// NOTE: I constrained the randoms to 100 to prevent program
		//          from hanging. Feel free to remove the 100 in lines
		//			19 and 28 for it to be truly random.
		Random r = new Random();
		int initval = r.nextInt(100);	// initval = initial value
										// Used to randomly generate 
										//    how much the dispenser
										//    will contain.
		Dispenser d = new Dispenser();  // Initializes empty dispenser.

		for (int i = 0; i < initval; i++) {
			// For loop used to fill empty dispenser with [initval]
			//    randomly generated numbers
			int pushing = r.nextInt(100);
			d.Push(pushing);
		}
		
		int topush = 3; // User changeable int to push.
		
				   // Print: Prints dispenser's values in the console.
		d.Print(); 
		
				   // Pop: Dispenses (removes) last added value.
		d.Pop();   
		
				   // Push: Adds a number to the top of the dispenser.
		System.out.println("\n[PUSH]\nPushing " + topush + "!"); 	
				   // Printed here instead of in PEZ.Print() method body to
				   //    prevent the console being flooded when filling the
				   //    dispenser.
		d.Push(topush);
		
				   // ReversePrint: Prints dispenser's values backwards
				   //     			   to the console.
		d.ReversePrint(); 
						
		           // Sum: Uses recursion to add all the PEZ's values together.
		System.out.println("\n[SUM]\nThe sum of these PEZ is " 
				+ d.Sum(d.getHead(), d.getCount()) + "!");
				   // Similarly to the Push method, I printed here in main
				   //    to avoid the console getting flooded.
		

	}

}
