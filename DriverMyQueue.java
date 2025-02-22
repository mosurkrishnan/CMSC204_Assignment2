import java.util.ArrayList;
import java.util.LinkedList;

public class DriverMyQueue {

	public static void main(String[] args) {
		
		
		try {
			MyQueue <String> queue = new MyQueue <>(5);		// starting size of 5 for example
			
			// adding or "enqueue-ing" new elements
			queue.enqueue("+");	
			queue.enqueue("/");		
			queue.enqueue("+");
			System.out.println("Queue: " + queue.toString());
			
			queue.dequeue(); // dequeue "+"
			System.out.println("Queue: " + queue.toString());
			
			queue.dequeue(); // remove first in
			queue.dequeue(); // remove next in
			System.out.println("is Queue empty: " + queue.isEmpty()); // should be true
			
			ArrayList<String> data = new ArrayList<>();
			data.add("A");
			data.add("b");
			data.add("c");
			data.add("d");
			data.add("e");
			queue.fill(data); // testing fill method
			System.out.println("is Queue full: " + queue.isFull()); // should be true
			System.out.println("Queue: " + queue.toString());
			
			System.out.println("Size of Queue is : " + queue.size()); // check public int size() {
//			queue.enqueue("Krishnan");
//			System.out.println("Queue: " + queue.toString()); // gets full now
//																// linkedlist expands automatically? 
			System.out.println(queue.toString("*-*"));	
			
			// now Queue is full. what if we "fill it again with same arraylist"
			// should say it is full
			queue.fill(data); // testing fill method
			System.out.println("is Queue full: " + queue.isFull()); // should be true
			System.out.println("Queue: " + queue.toString());
			
			System.out.println("Size of Queue is : " + queue.size()); // check public int size() {
			
		} catch (QueueOverflowException | QueueUnderflowException e) {
			System.out.println("Error: " + e.getMessage());
			
		}
		
		
	}

}
