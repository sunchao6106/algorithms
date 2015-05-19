package com.sunchao.sort;

import java.util.Arrays;

import junit.framework.TestCase;

public class TestSelectSort extends TestCase {

	private SelectSort bs = new SelectSort();
	 
	 public void testSelectSort(){
		 
		    int[] array = {5,7,9,2,3,0,1,3,5,645,23,11,87};
			
			System.out.println("sort begin : "+ Arrays.toString(array));
			 
		    bs.selectSort(array);
		    
		    System.out.println("sort end : "+ Arrays.toString(array));
	 }
}
