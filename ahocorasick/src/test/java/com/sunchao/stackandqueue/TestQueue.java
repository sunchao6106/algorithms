package com.sunchao.stackandqueue;

import junit.framework.TestCase;

public class TestQueue extends TestCase {
	private Queue1<Integer> queue = new Queue1<Integer>();
	//private NoLimitedQueue<Integer> queue = new NoLimitedQueue<Integer>();
	public void testQueue(){

		int[] array = {5,6,8,9,3,4,2,5,6,0,11,56,78};
		
		for(int i = 0 ; i < array.length ; i++){
			queue.offer(array[i]);
		}
		
		assertEquals(5, (int)queue.peek());
		assertEquals(5, (int)queue.pop());
		//assertTrue(stack.isEmpty());
		assertEquals(6, (int)queue.pop());
		assertEquals(8, (int)queue.pop());
		assertEquals(9, (int)queue.pop());
		assertEquals(3, (int)queue.pop());
		assertEquals(4, (int)queue.pop());
		assertEquals(2, (int)queue.pop());
		assertEquals(5, (int)queue.pop());
		assertEquals(6, (int)queue.pop());
		assertEquals(0, (int)queue.pop());
		assertEquals(11, (int)queue.pop());
		assertEquals(56, (int)queue.pop());
		assertEquals(78, (int)queue.pop());
		
	}
	

}
