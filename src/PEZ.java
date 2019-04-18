/* AUTHOR: Alyssa Gibson
 * CLASS: CSC210: Data Structures and Algorithms / Fall 2018
 * ASSIGNMENT: Design a PEZ dispenser using a doubly linked list.
 * CREATED: September 21st, 2018
 * MODIFIED: September 22nd, 2018
 */

public class PEZ {
	// This class contains:
	//    CONSTRUCTORS (Lines 18-31): used to create PEZ objects
	//    SET METHODS (Lines 33-41) : used to set private values prev and next
	//    GET METHODS (Lines 43-55) : used to get private values num, prev, and next
	
	private int num;		// The randomly generated number assigned to each PEZ.
	private PEZ prev, next; // Previous and next PEZ in the stack.
	
	//---CONSTRUCTORS---
	public PEZ(int i, PEZ p, PEZ n) {
		// Constructor to create a PEZ with a num value AND prev and next values
		num = i;
		prev = p;
		next = n;
	}
	
	public PEZ (int i) {
		// Constructor to create a PEZ with ONLY a num value
		num = i;
		prev = null;
		next = null;
	}
	// -----------------
	
	// ---SET METHODS---
	public void setPrev(PEZ p) {
		prev = p;
	}
	
	public void setNext(PEZ p) {
		next = p;
	}
	// -----------------
	
	// ---GET METHODS---
	public PEZ getPrev() {
		return prev; 
	}
	
	public PEZ getNext() {
		return next;
	}
	
	public int getNum() {
		return num;
	}
	//------------------
	
}
