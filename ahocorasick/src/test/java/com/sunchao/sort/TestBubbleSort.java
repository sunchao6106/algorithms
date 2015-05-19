package com.sunchao.sort;

import java.util.Arrays;

import junit.framework.TestCase;

public class TestBubbleSort extends TestCase {

	 private BubbleSort bs = new BubbleSort();
	 
	 public void testBubbleSort(){
		 
		    int[] array = {5,7,9,2,3,0,1,3,5,645,23,11,87};
			
			System.out.println("sort begin : "+ Arrays.toString(array));
			 
		    bs.bubbleSort(array);
		    
		    System.out.println("sort end : "+ Arrays.toString(array));
	 }
}

