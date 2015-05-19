package com.sunchao.sort;

import java.util.Arrays;

import junit.framework.TestCase;

public class TestMergeSort extends TestCase {

	 private MergeSort ms = new MergeSort();
	 
	 public void testMergeSort(){
		 
		    int[] array = {5,7,9,2,3,0,1,3,5,645,23,11,87};
			
			System.out.println("sort begin : "+ Arrays.toString(array));
			 
		    ms.mergeSort(array);
		    
		    System.out.println("sort end : "+ Arrays.toString(array));
	 }
}
