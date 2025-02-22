
public class QueueOverflowException extends RuntimeException {
	/**
	 * @author Chandra S. Krishnan 
	 */
	
	QueueOverflowException(){
		super("Queue is full");
	}

}