package com.sunchao.sort;

import java.util.Arrays;

import junit.framework.TestCase;

public class TestQuickSort extends TestCase {

	// private QuickSort qs = new QuickSort();
	 private QuickSort1 qs = new QuickSort1();
	 
	 public void testBubbleSort(){
		 
		    int[] array = {5,7,9,2,3,0,1,3,5,645,23,11,87,66,235,127,34,77,26};
			
			System.out.println("sort begin : "+ Arrays.toString(array));
			 
		    qs.quickSort(array);
		    
		    System.out.println("sort end : "+ Arrays.toString(array));
	 }
}