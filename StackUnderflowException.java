
public class StackUnderflowException extends RuntimeException {
											// made it runtime exception vs Exception (before)
	/**
	 * @author Chandra S. Krishnan 
	 */
	StackUnderflowException(){
		super("Queue is empty"); // Check exact wordings
	}
}
