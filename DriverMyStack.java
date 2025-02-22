import java.util.ArrayList;
import java.util.Arrays;

public class DriverMyStack {

	public static void main(String[] args) {
		
		
		int capacity = 5; // start out with 5 elements
		MyStack <String> stack = new MyStack<>(5);
		
		stack.push("a");
		stack.push("b");
		stack.push("c");
		
		MyStack <Double> stackD = new MyStack<>(5);
		stackD.push(10);
		stackD.push(11);
		stackD.push(12);
		// testing to String
		System.out.println( "StackD: " + stackD.toString());
		
		// testing to String
		System.out.println( "Stack: " + stack.toString());
		
		// testing to String delimiter
		System.out.println( "Stack: " + stack.toString("***"));
		
		// testing public boolean isEmpty() { should return FALSE
		System.out.println( "Stack is empty: " + stack.isEmpty());
		
		// testing public boolean isFull() { return false
		System.out.println("Stack is full: " + stack.isFull());
		
		stack.push("e");
		System.out.println( "Stack: " + stack.toString());
		stack.push("f"); // should return full now
		System.out.println( "Stack: " + stack.toString());
		System.out.println("Stack is full: " + stack.isFull());
		stack.push("f");
		
//		// testing public T pop() throws StackUnderflowException 
//		System.out.println("Stack is full: " + stack.pop()); // 1st removal
//		System.out.println( "Stack: " + stack.toString("***"));
//		
//		System.out.println("Stack is full: " + stack.pop()); // 2nd removal
//		System.out.println( "Stack: " + stack.toString("***"));
//		System.out.println("Stack is full: " + stack.pop()); // 3rd removal
//		System.out.println( "Stack: " + stack.toString("***"));
//		System.out.println("Stack is full: " + stack.pop()); // 4th removal
//		System.out.println( "Stack: " + stack.toString("***"));
//		System.out.println("Stack is full: " + stack.pop()); // 5th removal
//		// does it show " "StackUnderflowException()
//		System.out.println( "Stack: (note has been emptied now)" + stack.toString("***"));
//		
////		System.out.println("Stack is full: " + stack.pop()); // 5th removal
////		// SHOWS " "StackUnderflowException()
////		System.out.println( "Stack: (note has been emptied now)" + stack.toString("***"));
//		
//		// CHECKING public int size() {
//		System.out.println( "Stack size is : " + stack.size());
//		
//		// testing public boolean push(Object e) throws StackOverflowException
//		stack.push("a");
//		stack.push("b");
//		stack.push("c");
//		stack.push("d");
//		stack.push("e"); // capacity is 5 or at max
//		System.out.println( "Stack: " + stack.toString("***"));
////		// beyond capacity - should throw overflow exception
////		stack.push("f");
////		// THROWS OVERFLOW EXCEPTION
//		
//		stack.pop();
//		stack.pop();
//		stack.pop();
//		stack.pop();
//		stack.pop(); // popped all five
//		
//		ArrayList<String> list = new ArrayList<>(Arrays.asList("g", "h", "i"));
//		// testing public void fill(ArrayList<T> list)
//		stack.fill(list);
//		System.out.println("Stack's contents now " + stack.toString("***"));
//		
//		// ALL METHODS CHECKED
	}

}