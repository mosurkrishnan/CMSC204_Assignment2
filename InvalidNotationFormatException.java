
public class InvalidNotationFormatException extends RuntimeException {
	/**
	 * @author Chandra S. Krishnan
	 * default constructor
	 * need to check error wordings
	 */
	
	InvalidNotationFormatException(String string){ // verify this parameter String string being passed.
		super("Notation format is incorrect");
	}
}
