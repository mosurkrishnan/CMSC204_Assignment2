import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is about implementing QueueInterface
 * @author Chandra S. Krishnan 
 * 
 * Guidance: Create a generic queue class called MyQueue.  
 * MyQueue will implement the QueueInterface given you. You will be creating MyQueue from scratch 
 * (do not use an internal object of the Queue class from java.util)
 */

public class MyQueue <T> implements QueueInterface<T> {
	
	private int sizeOfQueue; // size of linkedlist
	private LinkedList<T> queue;
	
	/**
	 * default constructor - uses a default as the size of the queue
	 */
	public MyQueue() {
		sizeOfQueue = 100; // is this needed? 
							// "There is no case of default capacity in a LinkedList" then why this? 
		queue = new LinkedList<>(); // initializing queue
	}
	
	/**
	 * default constructor - uses a default for the size of the queue
	 * @param size
	 */
	public MyQueue(int size) {
		sizeOfQueue = size;
		queue = new LinkedList<>(); // initializing queue
	}  
	
	/**
	 * Determines if the Queue is Full
	 * @return true if Queue is full, false if not
	 */
	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
		
	}
	/**
	 * Determines of the Queue is Full
	 * @return true if Queue is full, false if not
	 */
	@Override
	public boolean isFull() {
		return queue.size() == sizeOfQueue;
		 
	}
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 * Underflow Definition: This means that there is no elements in the stack/queue so that it can pop/ dequeue 
	 * that element in the stack. If there is no element in the stack/queue, then there is nothing to pop/dequeue
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		if(queue.isEmpty()){
			 throw new QueueUnderflowException();  
		}
		return queue.removeFirst(); // removes from the first. 
	}
	
	/**
	 * Returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		return queue.size();  
	}
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 * Overflow Definition: As the name suggests it is a term used at a point where the data can't be 
	 * pushed/enqueued in the stack / queue as the no. of elements in the stack is equal to the size of the array. 
	 * That means there is no more space for the element in the stack/queue
	 */

	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
//		 if(queue.isEmpty()) {
//			 throw new QueueOverflowException();
//		 }
//		 return queue.add(e); // removes from the end or tail
		if (queue.size() == sizeOfQueue) {
			throw new QueueOverflowException();
		}
		queue.add(e);
		return true;
	}
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i =0; i< queue.size(); i++) {
			sb = sb.append(queue.get(i));
			// sb = sb.append(" ");		
		}
		return sb.toString();
	}
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string 
	 * is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	public String toString(String delimiter) {
		StringBuilder queueString = new StringBuilder();
	    
	    for (int i = 0; i < queue.size(); i++) {
	        queueString.append(queue.get(i));
	        if (i != queue.size() - 1) { // Add delimiter between elements, but not at the end
	            queueString.append(delimiter);
	        }
	    }
	    
	    return queueString.toString();
	}
	/**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	 
	  */
	@Override
	public void fill(ArrayList<T> list) {	// THIS NEEDS EXCEPTION
											// BUT INTERFACE DOES NOT RECOMMEND IT
		ArrayList<T> temp = new ArrayList<T>(list);
		for (int i = 0; i < temp.size(); i++) {if (isFull()) {
			System.out.println("Manually Generated Message - Stack is full");
			return; // "return" This is my approach to bypassing throws exception (refer MyQueue - for other version)
					// is this good enough? to bypass "THROWS"
					// stop adding elements
		}			
//		if (isFull()) {							// check if stack is full
//            throw new StackOverflowException(); 
//        }
		queue.addLast(temp.get(i));
		// try enqueue instead
		}
		
	}

}
