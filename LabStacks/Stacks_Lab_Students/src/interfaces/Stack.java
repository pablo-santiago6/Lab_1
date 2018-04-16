package interfaces;


public interface Stack<E> { 
	/** 
	 * Accessor Method. Returns the size of the current instance. 
	 * **/
	int size(); 

	/** 
	 * Accessor Method. Returns true if the current instance is 
	 * empty; false, if not.  
	 **/ 
	boolean isEmpty(); 

	/** 
	 * Accessor Method. Accesses element in the current instance of the
	 * stack. The affected element is the one that has been in the stack
	 * the least time among all its current element. 
	 * @return reference to the element being accessed; if the stack is 
	 * empty, it returns null.
	 **/ 
	E top(); 

	/**
	 * Mutator Method. Adds a new element to the stack. 
	 * @param e the element to be added to the stack. 
	 **/
	void push(E e); 

	/** 
	 * Mutator Method. Similar to the top method, but this time, the 
	 * stack is altered since the accessed element is also removed from 
	 * the stack.   
	 * @return reference to the element being removed from the stack. If
	 * the stack is empty, it returns null. 
	 **/
	E pop(); 
}