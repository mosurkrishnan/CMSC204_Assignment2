import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotationSTUDENT_TEST {
	
	public String n1 = "(3+4)";					// convertInfixToPostfix - answer 7
	public String n2 = "(2+(3*4))";				// convertInfixToPostfix - answer 14
	public String n3 = "((2+3)*4)";			// convertInfixToPostfix - answer 20
	
	public String n1PostFix = "34+";			// COMPLIMENT convertInfixToPostfix
	public String n2PostFix = "234*+";		// COMPLIMENT convertInfixToPostfix
	public String n3PostFix = "23+4*";		// COMPLIMENT convertInfixToPostfix
	
	public double evalN1Postfix = 7.0;
	public double evalN2Postfix = 14.0;
	public double evalN3Postfix = 20.0;
//	Postfix: 34+ -> Result: 7.0
//	Postfix: 234*+ -> Result: 14.0
//	Postfix: 23+4* -> Result: 20.0
	
	@BeforeEach	
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testConvertInfixToPostfix() {
		String postfixResult = Notation.convertInfixToPostfix(n1);
		assertEquals(n1PostFix, postfixResult);
		
		String postfixResult2 = Notation.convertInfixToPostfix(n2);
		assertEquals(n2PostFix, postfixResult2);
		String postfixResult3 = Notation.convertInfixToPostfix(n3);
		assertEquals(n3PostFix, postfixResult3);
	}
	//***********************
	@Test
	public void testConvertPostfixToInfix() {
		String infixResult = Notation.convertPostfixToInfix(n1PostFix);
		assertEquals(n1, infixResult);
	
		String infixResult2 = Notation.convertPostfixToInfix(n2PostFix);
		assertEquals(n2, infixResult2);
		
		String infixResult3 = Notation.convertPostfixToInfix(n3PostFix);
		assertEquals(n3, infixResult3);
	}
	@Test
	public void testEvaluatePostfixExpression() {
		double result = Notation.evaluatePostfixExpression(n1PostFix);
		assertEquals(evalN1Postfix, result, .001);
		
		double result2 = Notation.evaluatePostfixExpression(n2PostFix);
		assertEquals(evalN2Postfix, result2, .001);
		
		double result3 = Notation.evaluatePostfixExpression(n3PostFix);
		assertEquals(evalN3Postfix, result3, .001);
		
		
	}
	

}
