
public class DriverNotation3 {

	public static void main(String[] args) {
		
		// FOR TESTING Notation.evaluatePostfixExpression

		 try {
			 	// my examples
	            // 1st example
	            String ex1 = "34+"; // Expected output: 5.0
	            System.out.println("Postfix: " + ex1 + " -> Result: " + Notation.evaluatePostfixExpression(ex1));

	            // 2nd example
	            String ex2 = "234*+"; // Expected output: 10.0
	            System.out.println("Postfix: " + ex2 + " -> Result: " + Notation.evaluatePostfixExpression(ex2));

	            // 3rd example
	            String ex3 = "23+4*"; // Expected output: 1.0
	            System.out.println("Postfix: " + ex3 + " -> Result: " + Notation.evaluatePostfixExpression(ex3));

	        } catch (InvalidNotationFormatException | ArithmeticException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    
		// provided examples
//		double evalEasyPostfix = 9.0;	
//		double evalIntermediatePostfix = 29.0;
//		double evalComplexPostfix = 141.0;
//		
//		 try {
//			 	double result = Notation.evaluatePostfixExpression(easyPostfix);
//	            System.out.println("Postfix: " + evalEasyPostfix + " -> Result: " + Notation.evaluatePostfixExpression(result);
//
//	           
//	        } catch (InvalidNotationFormatException | ArithmeticException e) {
//	            System.out.println("Error: " + e.getMessage());
//	        }
		
	}

}
