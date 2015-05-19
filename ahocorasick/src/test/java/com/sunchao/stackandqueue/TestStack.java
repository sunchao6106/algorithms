package com.sunchao.stackandqueue;

import junit.framework.*;

public class TestStack extends TestCase {
	
	private Stack<Integer> stack = new Stack<Integer>();
	
	public void testStack(){
	
		int[] array = {5,6,8,9,3,4,2,5,6,0,11,56,78};
		
		for(int i = 0 ; i < array.length ; i++){
			stack.push(array[i]);
		}
		
		assertEquals(78, (int)stack.peek());
		assertEquals(78, (int)stack.pop());
		//assertTrue(stack.isEmpty());
		assertEquals(56, (int)stack.pop());
		assertEquals(11, (int)stack.pop());
		assertEquals(0, (int)stack.pop());
		assertEquals(6, (int)stack.pop());
		assertEquals(5, (int)stack.pop());
		assertEquals(2, (int)stack.pop());
		assertEquals(4, (int)stack.pop());
		assertEquals(3, (int)stack.pop());
		assertEquals(9, (int)stack.pop());
		assertEquals(8, (int)stack.pop());
		assertEquals(6, (int)stack.pop());
		assertEquals(5, (int)stack.pop());
	}

}
