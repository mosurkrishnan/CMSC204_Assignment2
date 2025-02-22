import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 * @author Chandra S. Krishnan
 * Notation.java
 * This utilty class has 3 main methods: 
 * a) convertInfixToPostfix(String infix)
 * b) convertPostfixToInfix(String postfix)
 * c) evaluatePostfixExpression(String postfixExpr)
 */

public class Notation {
	/**
	 * Convert an infix expression into a postfix expression
	 * public static java.lang.String convertInfixToPostfix​(java.lang.String infix) throws InvalidNotationFormatException
	 * @param infix the infix expression in string format
	 * @return postfix.toString().trim(). the postfix expression in string format. essentially result of manipulation
	 * @throws InvalidNotationFormatException - if the infix expression format is invalid
	 */
	
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
        // Stack to hold operators and parentheses
        Stack<Character> operatorStack = new Stack<>();
        // Queue to store the final postfix expression (output)
        Queue<Character> postfixQueue = new LinkedList<>();

        // Read the infix expression from left to right
        // Loop through each character in the infix expression
        for (int i = 0; i < infix.length(); i++) {
            char current = infix.charAt(i);

            // 1. If the current character in the infix is a space, ignore it.
            // Ignore spaces
            if (current == ' ') {
                continue;
            }

            // 2. If the current character in the infix is a digit, copy it to the postfix solution queue
            														// add it to the output queue
            if (Character.isDigit(current)) {
                postfixQueue.add(current);
            }
            
            // 3️. If the current character in the infix is a left parenthesis, push it onto the stack 
            											// left parenthesis '(', push it onto the operator stack
            else if (current == '(') {
                operatorStack.push(current);
            }
            
            // 4️.  If the current character in the infix "is an operator", 
            							// If operator (+, -, *, /), process precedence rules**
            							// method - isAnOperator. Checks if character is an operator
            							// method - takesPrecedence. Manages precedence.  +- vs */
            else if (isAnOperator(current)) {
                // While there are operators on the stack with **higher or equal precedence**,
                // pop them and add to the queue before pushing the current operator
                while (!operatorStack.isEmpty() && takesPrecedence(operatorStack.peek()) >= takesPrecedence(current)) {
                    postfixQueue.add(operatorStack.pop());
                }
                // Push current operator onto the stack
                operatorStack.push(current);
            }

            // 5. If it's a right parenthesis ')', pop and process until '(' is found
            else if (current == ')') {
                // Pop operators and add to queue until we find '('
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfixQueue.add(operatorStack.pop());
                }
                // If the stack is empty and no '(' was found, throw an exception
                if (operatorStack.isEmpty()) {
                    throw new InvalidNotationFormatException("Mismatched parentheses");
                }
                // Pop the '(' but do NOT add it to the queue (it's just for grouping)
                operatorStack.pop();
            }

            // 6. If the character is invalid, throw an exception
            else {
                throw new InvalidNotationFormatException("Invalid character in expression");
            }
        }

        // 7. At the end, pop all remaining operators in the stack and add to queue
        while (!operatorStack.isEmpty()) {
            char top = operatorStack.pop();
            // If there are mismatched '(' remaining, it's an error
            if (top == '(') {
                throw new InvalidNotationFormatException("Mismatched parentheses");
            }
            postfixQueue.add(top);
        }

        // 8. Convert the queue to a string and return
        StringBuilder postfix = new StringBuilder();
        while (!postfixQueue.isEmpty()) {
            postfix.append(postfixQueue.poll()).append(""); // quickfix changed " " to "".
        }
        
        return postfix.toString().trim(); // Trim trailing space
    } // convertInfixToPostfix

    // Helper method to check if a character is an operator
    private static boolean isAnOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    } // end of isAnOperator

    // Helper method to determine precedence of operators
    private static int takesPrecedence(char operator) {
        switch (operator) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            default: return -1;
        }
    } // end of takesPrecedence
    
    //****************************************convertPostfixToInfix***********************************************
    /**
     * Convert the Postfix expression to the Infix expression
     * @param postfix - the postfix expression in string format
     * @return the infix expression in string format
     * @throws InvalidNotationFormatException- if the postfix expression format is invalid
     */
    
    public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
        // Stack to hold intermediate infix expressions
        Stack<String> stack = new Stack<>();

        // Read the postfix expression from left to right and to the following
        // Loop through each character in the postfix expression
        for (int i = 0; i < postfix.length(); i++) {
            char current = postfix.charAt(i);

            // A. If the current character in the postfix is a space, ignore it.
            if (current == ' ') {
                continue;
            }

            // B. If the current character is an operand, push it on the stack
            if (Character.isLetterOrDigit(current)) {
                stack.push(Character.toString(current));  // Convert char to String and push it
            } 
            
            // C. If the current character is an operator,
            else if (isAnOperator(current)) {
                // 1.	Pop the top 2 values from the stack. If there are fewer than 2 values throw an error
                if (stack.size() < 2) {
                    throw new InvalidNotationFormatException("Invalid postfix expression: not enough operands.");
                }

                // 2.	Create a string with 1st value and then the operator and then the 2nd value.
                String operand2 = stack.pop(); // First pop → second operand (right)
                String operand1 = stack.pop(); // Second pop → first operand (left)

                // 3.	Encapsulate the resulting string within parenthesis
                // ex. (operand1 operator operand2)
                String newExpression = "(" + operand1 + "" + current + "" + operand2 + ")";

                // 4.	Push the resulting string back to the stack
                stack.push(newExpression);
            } 
            
            // D. If character is invalid, throw an exception
            else {
                throw new InvalidNotationFormatException("Invalid character in postfix expression.");
            }
        }

        // When the postfix expression has been read: If there is only one value in the stack 
        // – it is the infix string, if more than one value, throw an error

        if (stack.size() != 1) {
            throw new InvalidNotationFormatException("Invalid postfix expression: too many operands.");
        }

        // Return final infix expression
        return stack.pop();
    } // end of convertPostfixToInfix
    
    // *****************************************evaluatePostFix *******************************************
    /**
     * Evaluates a postfix expression from a string to a double
     * @param postfixExpr - the postfix expression in String format
     * @return the evaluation of the postfix expression as a double
     * @throws InvalidNotationFormatException - if the postfix expression format is invalid
     */
    
    public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
        Stack<Double> stack = new Stack<>();
        
        // i. Read the postfix expression from left to right and to the following
        //	For loop through the postfix expression
        for (int i = 0; i < postfixExpr.length(); i++) {
            char c = postfixExpr.charAt(i);
            
            // ii. If the current character in the postfix expression is a space, ignore it. Ignore spaces
            if (c == ' ') {
                continue;
            }
            // If the character is a digit, push it to the stack
            else if (Character.isDigit(c)) {
                stack.push((double) (c - '0')); // Convert char to double
            }
            // iii. If the current character is an operand or left parenthesis, push on the stack
            //	If the character is an operator, perform calculation
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (stack.size() < 2) {
                    throw new InvalidNotationFormatException("Invalid postfix expression: not enough operands.");
                }
                
                // 2.	Perform the arithmetic calculation of the operator with the first popped value as the 
                //	right operand and the second popped value as the left operand. essentially "Pop" top two values
                double rightOperand = stack.pop();
                double leftOperand = stack.pop();
                double result = 0;
                
                // Perform the arithmetic operation
                switch (c) {
                    case '+':
                        result = leftOperand + rightOperand;
                        break;
                    case '-':
                        result = leftOperand - rightOperand;
                        break;
                    case '*':
                        result = leftOperand * rightOperand;
                        break;
                    case '/':
                        if (rightOperand == 0) {
                            throw new ArithmeticException("Division by zero is not allowed.");
                        }
                        result = leftOperand / rightOperand;
                        break;
                    default:
                        throw new InvalidNotationFormatException("Invalid operator found: " + c);
                }
                
                // 3.	Push the resulting value onto the stack OR "Push" result back onto stack
                stack.push(result);
            } 
            // If an invalid character is found
            else {
                throw new InvalidNotationFormatException("Invalid character in expression: " + c);
            }
        }
        
        // 	At the end, stack should have exactly one value, the final result
        // 	When the postfix expression has been read:
        //	If there is only one value in the stack – it is the result of the postfix expression, if 
        //	more than one value, throw an error
        if (stack.size() != 1) {
            throw new InvalidNotationFormatException("Invalid postfix expression: too many operands.");
        }   
        return stack.pop();
    } // end of evaluatePostFix
     

}

