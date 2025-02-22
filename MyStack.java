import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Chandra S. Krishnan
 * this class - MyStack is creates a generic stack 
 * Create a generic stack class called MyStack.  MyStack will implement the Stack Interface given you. 
 * You will be creating MyStack from scratch (do not use an internal object of the Stack class from java.util)
 * @param <T>
 */
public class MyStack <T> implements StackInterface <T> {
	
	private int sizeOfStack; // define the stack
	private LinkedList<T>stack; // should I switch to LinkedlIst? to stay consistent !!!!!!!
	int items = 0;// items is counter for things being added to stack
	
	/**
	 * Provide two constructors
	 * 1. takes in an int as the size of the stack
	 * 2. default constructor - uses default as the size of the stack
	 */
	public MyStack() {
		sizeOfStack = 100;
		stack = new LinkedList<>();	
	}
	public MyStack(int size) {
		this.sizeOfStack = size;
		stack = new LinkedList<>();	
	}
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return stack.isEmpty();
	}
	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return stack.size() >= sizeOfStack;
	}
	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T pop() throws StackUnderflowException { // POP command is It removes the element at the top of 
														// the stack and returns it. If the stack is empty, 
														// it may "throws" an EmptyStackException.
		if (stack.isEmpty()) {
			throw new StackUnderflowException();
			}
		return stack.removeLast();
	}
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T top() throws StackUnderflowException {	// another version of "PEEK" command
															// retrieves the element at the top of the stack 
															// without removing it. If the stack is empty, 
															// will throw a EmptyStackException.
		if (stack.isEmpty()) {
			throw new StackUnderflowException();
			}
		return stack.getLast();
	}
	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() {
		
		return stack.size();
	}
	
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	@Override
	public boolean push(Object e) throws StackOverflowException {
		if (isFull()){
			throw new StackOverflowException();
			}
		stack.addLast((T) e); // "addlast" - adding to Object e to Top or Last
		return true;
	}
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i =0; i< stack.size(); i++) {
			sb = sb.append(stack.get(i));
			//sb = sb.append(" ");		
		}
		return sb.toString();
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		StringBuilder sb = new StringBuilder();
	    
	    for (int i = 0; i < stack.size(); i++) {
	        sb.append(stack.get(i));
	        if (i != stack.size() - 1) { // Add delimiter between elements, but not at the end
	            sb.append(delimiter);
	        }
	    }
	    
	    return sb.toString();
	}
	/**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	public void fill(ArrayList<T> list) {	// THIS NEEDS EXCEPTION
											// BUT INTERFACE DOES NOT RECOMMEND IT
		
											// nOTE ERROR
		ArrayList<T> temp = new ArrayList<T>(list);
		
		for (int i = 0; i < temp.size(); i++) {
			if (isFull()) {
				System.out.println("Manually Generated Message - Stack is full");
				return; // "return" This is my approach to bypassing throws exception (refer MyQueue - for other version)
						// is this good enough? to bypass "THROWS"
						// stop adding elements
			}			
//			if (isFull()) {							// check if stack is full
//	            throw new StackOverflowException(); 
//	        }
			stack.addLast(temp.get(i));
		}
		
	}
}
