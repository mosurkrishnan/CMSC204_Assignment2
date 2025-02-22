
public class DriverNotation {

	public static void main(String[] args) {
		
		// FOR TESTING Notation.convertInfixToPostfix
		        
        String easyInfix = "2+(3*4)";
        String intermediateInfix = "((3*(5+4))+2)";
        String complexInfix = "(3+(((5*7)-(((8/2)-1)*4))*6))";
        String invalidInfixExpression = "(3+5)*4)-2";
        
    	
    	//*****************************************************
    	System.out.println("Analyzing infix expressions:");
    	
    	System.out.println("Analyzing easyInfix = 2+(3*4)");
        try {
            String postfixExpression = Notation.convertInfixToPostfix(easyInfix);
            System.out.println("Postfix Expression: " + postfixExpression);
        } catch (InvalidNotationFormatException e) {
            System.out.println("Error: Invalid infix expression format.");
        }   
        
        System.out.println("Analyzing intermediateInfix = \"((3*(5+4))+2)\"");
        try {
            String postfixExpression = Notation.convertInfixToPostfix(intermediateInfix);
            System.out.println("Postfix Expression: " + postfixExpression);
        } catch (InvalidNotationFormatException e) {
            System.out.println("Error: Invalid infix expression format.");
        }    
        
        System.out.println("Analyzing complexInfix = \"(3+(((5*7)-(((8/2)-1)*4))*6))\"");
        try {
            String postfixExpression = Notation.convertInfixToPostfix(complexInfix);
            System.out.println("Postfix Expression: " + postfixExpression);
        } catch (InvalidNotationFormatException e) {
            System.out.println("Error: Invalid infix expression format.");
        }   
        
        System.out.println("Analyzing invalidInfixExpression = \"(3+5)*4)-2\"");
        try {
            String postfixExpression = Notation.convertInfixToPostfix(invalidInfixExpression);
            System.out.println("Postfix Expression: " + postfixExpression);
        } catch (InvalidNotationFormatException e) {
            System.out.println("Error: Invalid infix expression format.");
        }   

	}

}
