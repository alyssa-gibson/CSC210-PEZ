/* AUTHOR: Alyssa Gibson
 * CLASS: CSC210: Data Structures and Algorithms / Fall 2018
 * ASSIGNMENT: Design a PEZ dispenser using a doubly linked list.
 * CREATED: September 21st, 2018
 * MODIFIED: September 22nd, 2018
 */

import java.util.ArrayList;

public class Dispenser {
	// This class contains:
	//    CONSTRUCTOR (Lines 20-27)       : used to create Dispenser objects
	//    GET METHODS (Lines 29-39)       : used to get private values head and count
	//    REQUIRED METHODS (Lines 41-168) : methods required by the assignment
	//    OTHER METHODS (Lines 170-177)   : methods I created for use in required methods
	
	private PEZ head;	// PEZ at the head, or top, of the dispenser
	private int count;  // total number of PEZ in the dispenser
	
	// ---CONSTRUCTOR---
	// constructor to make an empty dispenser
	public Dispenser() {
		head = null;
		count = 0;
		
	}
	// -----------------
	
	// ---GET METHODS---
	public PEZ getHead() {
		return head;
		
	}
	
	public int getCount() {
		return count;
		
	}
	// -----------------
	
	//-REQUIRED METHODS-
	public void Push(int i) {
		// PUSH METHOD: adds a PEZ to the top of the dispenser.
		// PARAMETERS : int i = number desired to be assigned to PEZ pushed.

		// CASE 1: If the dispenser is empty
		if (count == 0) {
			PEZ p = new PEZ(i); // create PEZ from i
			head = p;			// set new PEZ as head
			count++;			// increment count
			
		}
		// ---------------------------------
		
		// CASE 2: If the dispenser is NOT empty
		else {
			PEZ p = new PEZ(i);  // create PEZ from i
								 // clone current head to a new PEZ
			PEZ q = new PEZ(head.getNum(), head.getPrev(), head.getNext());
			
			head = p;			 // assign new PEZ as the head
			head.setNext(q);     // set old head to be next in line
			q.setPrev(p);        // set previously null prev value for
								 //    old head to new head
			count++;			 // increment count
			
		}
		// -------------------------------------
	}
	
	public void Pop() {
		// POP METHOD: dispenses (removes) the top PEZ from the dispenser.
		
		// CASE 1: If the dispenser is empty
		if (count == 0) {
			System.out.println("\n[POP]\nThis dispenser is empty!");
				// Nothing can be dispensed if it is already empty.
			
		}
		// ---------------------------------
		
		// CASE 2: If the dispenser is NOT empty
		else {
			System.out.println("\n[POP]\nDispensed " + head.getNum() + "!");
				// Because the dispenser is designed to be first in first out,
				//    the head is always dispensed.
			PEZ p = head.getNext(); // create new PEZ with second in line's info
			p.setPrev(null);	    // sever the link between p and old head
			head = p;				// make p the new head of the list
			count--;				// decrement the count
		}

	}
	
	public void Print() {
		// PRINT METHOD: Prints the dispenser's contents to the console
		//				    from first to last.
		
		// CASE 1: If the dispenser is empty.
		if (isEmpty()) {
			System.out.println("\n[PRINT]\nThis dispenser is empty!");
		}
		// ----------------------------------
		
		// CASE 2: If the dispenser is NOT empty.
		else {
			System.out.println("\n[PRINT]\nThis dispenser has:");
			PEZ p = head;
			while (p != null) {
				System.out.println(p.getNum());
				p = p.getNext();
			}
			
		}
		// --------------------------------------
		
	}
	
	public void ReversePrint() {
		// REVERSE PRINT METHOD: Prints the dispenser's contents to the console
		//				            from last to first.
		
		// CASE 1: If the dispenser is empty.
		if (isEmpty()) {
			System.out.println("\n[REVERSE PRINT]\nThis dispenser is empty!");
		}
		// ----------------------------------
		
		// CASE 2: If the dispenser is NOT empty.
		else {
			PEZ p = head;
			ArrayList<PEZ> rev = new ArrayList<>(); 
				// I decided to store the values in an ArrayList for
				//    easier backwards printing.
			while (p != null) {
				rev.add(p);
				p = p.getNext();
			}
			
			System.out.println("\n[REVERSE PRINT]\nThis dispenser has:");
			for (int i = rev.size()-1; i > -1; i--) {
				System.out.println(rev.get(i).getNum());
			}

		}
		// --------------------------------------
		
	}
	
	public int Sum(PEZ p, int s) {
		// SUM METHOD: Uses recursion to add the values assigned to each
		// 			      PEZ in the dispenser.
		// PARAMETERS: PEZ p- head of dispenser; int s- total added
		
		// BASE CASE: If there is no next value (reached end of linked list)
		if (p.getNext() == null) {
			return s;
		}
		// -----------------------------------------------------------------
		
		// RECURSIVE CASE: If there IS a next value (still more in the list to add)
		else {
			s = s + p.getNum();
			return Sum(p.getNext(), s);
		}
		// ------------------------------------------------------------------------
	}
	// -----------------
	
	// --OTHER METHODS--
	public boolean isEmpty() {
		// IS EMPTY METHOD: Boolean method used in print methods to check if
		// 					   the dispenser is empty.
		return (count == 0);
		
	}
	// -----------------
	
}
