public class DriverNotation2 {

	public static void main(String[] args) {
		
		String easyPostfix = "54+";
		String intermediatePostfix = "354+*2+";
		String complexPostfix =  "357*82/1-4*-6*+";  	
    	String invalidPostfixExpression = "354+*-";
    	
    	// my examples
    	try {
            System.out.println("Postfix: 3 4 +");
            System.out.println("Infix: " + Notation.convertPostfixToInfix("3 4 +"));

            System.out.println("\nPostfix: 2 3 + 4 *");
            System.out.println("Infix: " + Notation.convertPostfixToInfix("2 3 + 4 *"));

            System.out.println("\nPostfix: 5 6 2 + * 12 4 / -");
            System.out.println("Infix: " + Notation.convertPostfixToInfix("5 6 2 + * 12 4 / -"));

        } catch (InvalidNotationFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    	
    	//***************easyPostfix
    	try {
            System.out.println("\nPostfix: " + easyPostfix);
            System.out.println("Infix: " + Notation.convertPostfixToInfix(easyPostfix));

        } catch (InvalidNotationFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    	//***************intermediatePostfix
    	try {
            System.out.println("\nPostfix: " + intermediatePostfix);
            System.out.println("Infix: " + Notation.convertPostfixToInfix(intermediatePostfix));

        } catch (InvalidNotationFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    	//***************complexPostfix
    	try {
            System.out.println("\nPostfix: " + complexPostfix);
            System.out.println("Infix: " + Notation.convertPostfixToInfix(complexPostfix));

        } catch (InvalidNotationFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    	//***************invalidPostfixExpression
    	try {
            System.out.println("\nPostfix: " + invalidPostfixExpression);
            System.out.println("Infix: " + Notation.convertPostfixToInfix(invalidPostfixExpression));

        } catch (InvalidNotationFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }	
    	
    }
}
