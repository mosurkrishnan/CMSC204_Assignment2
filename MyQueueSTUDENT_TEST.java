import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class MyQueueSTUDENT_TEST {
	public MyQueue<String> queue;
	public String a="A", b="B", c="C", d="D", e="E", f="F";
	public ArrayList<String> data = new ArrayList<String>();
	// STUDENT: student tests will use the doubleQ
		public MyQueue<Double> doubleQ;
		public double g= 10, h = 11, i = 12, j = 13, k = 14, l = 15;
		public ArrayList<Double> doubleFill = new ArrayList<Double>();
	

	@BeforeEach
	public void setUp() throws Exception {
		queue = new MyQueue<String>(5);
		queue.enqueue(a);
		queue.enqueue(b);
		queue.enqueue(c);	
		//STUDENT: add setup for doubleQ for student tests
				doubleQ = new MyQueue<Double>(5);
				doubleQ.enqueue(g);
				doubleQ.enqueue(h);
				doubleQ.enqueue(i);
				
	}

	@AfterEach
	public void tearDown() throws Exception {
		queue = null;
		doubleQ = null;
	}

	@Test
	public void testIsEmpty() {
		assertEquals(false,queue.isEmpty());
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		assertEquals(true, queue.isEmpty());
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(a, queue.dequeue());
			assertEquals(b, queue.dequeue());
			assertEquals(c, queue.dequeue());
			//Queue is empty, next statement should cause QueueUnderFlowException
			queue.dequeue();
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		catch (QueueUnderflowException e){
			assertTrue("This should have caused an QueueUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
	}
	@Test
	public void testDequeueStudent() {
		//Use the doubleQ for student tests
		try {
			// a b c d e f	stringQ
			// g h i j k l	doubleQ
			assertEquals(g, doubleQ.dequeue(), 0.00);
			//System.out.println("size is " + doubleQ.size());
			assertEquals(h, doubleQ.dequeue(), 0.00);
			//System.out.println("size is " + doubleQ.size());
			assertEquals(i, doubleQ.dequeue(), 0.00);
			//System.out.println("size is " + doubleQ.size());
			//Queue is empty, next statement should cause QueueUnderFlowException
			doubleQ.dequeue();
			//System.out.println("size is " + doubleQ.size());
			assertTrue("This should have caused an StackUnderflowException", false);
		}
		catch (QueueUnderflowException e){
			assertTrue("This should have caused an StackUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackUnderflowException", false);
		}
	}
	
	@Test
	public void testSize() {
		assertEquals(3, queue.size());
		queue.enqueue(d);
		assertEquals(4, queue.size());
		queue.dequeue();
		queue.dequeue();
		assertEquals(2, queue.size());
	}

	@Test
	public void testEnqueue() {
		try {
			assertEquals(3, queue.size());
			assertEquals(true, queue.enqueue(d));
			assertEquals(4, queue.size());
			assertEquals(true, queue.enqueue(e));
			assertEquals(5, queue.size());
			//Queue is full, next statement should cause QueueOverFlowException
			queue.enqueue(f);
			assertTrue("This should have caused an QueueOverflowException", false);
		}
		catch (QueueOverflowException e){
			assertTrue("This should have caused an QueueOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueOverflowException", false);
		}
	}
	@Test
	public void testEnqueueStudent() {
		//Use the doubleQ for student tests
		try {
			
			// a b c d e f
			// g h i j k l
			assertEquals(3, doubleQ.size());
			assertEquals(true, doubleQ.enqueue(j));
			assertEquals(4, doubleQ.size());
			assertEquals(true, doubleQ.enqueue(k));
			assertEquals(5, doubleQ.size());
			//Queue is full, next statement should cause QueueOverFlowException
			doubleQ.enqueue(l); //  "l" really is alphabet L
			assertTrue("This should have caused an StackOverflowException", false);
		}
		catch (QueueOverflowException e){
			assertTrue("This should have caused an StackOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackOverflowException", false);
		}
	}

	@Test
	public void testIsFull() {
		assertEquals(false, queue.isFull());
		queue.enqueue(d);
		queue.enqueue(e);
		assertEquals(true, queue.isFull());
	}

	@Test
	public void testToString() {
		assertEquals("ABC", queue.toString());
		queue.enqueue(d);
		assertEquals("ABCD", queue.toString());
		queue.enqueue(e);
		assertEquals("ABCDE", queue.toString());
	}
	@Test
	public void testToStringStudent() {
		//Use the doubleQ for student tests
		//Use the doubleQ for student tests
				// a 	b 	c 	d 	e 	f
				// g 	h 	i 	j 	k 	l
				// 10	11	12	13 	14	15
				assertEquals("10.011.012.0", doubleQ.toString());
				doubleQ.enqueue(j);
				assertEquals("10.011.012.013.0", doubleQ.toString());
				doubleQ.enqueue(k);
				assertEquals("10.011.012.013.014.0", doubleQ.toString());
	}

	@Test
	public void testToStringDelimiter() {
		assertEquals("A%B%C", queue.toString("%"));
		queue.enqueue(d);
		assertEquals("A&B&C&D", queue.toString("&"));
		queue.enqueue(e);
		assertEquals("A/B/C/D/E", queue.toString("/"));
	}

	@Test
	public void testFill() {
		data.add("Jack");
		data.add("Jill");
		data.add("John");
		//start with an empty queue
		queue = new MyQueue<String>(5);
		//fill with an ArrayList
		queue.fill(data);
		assertEquals(3,queue.size());
		assertEquals("Jack", queue.dequeue());
		assertEquals("Jill", queue.dequeue());
		assertEquals("John", queue.dequeue());		
	}


}
