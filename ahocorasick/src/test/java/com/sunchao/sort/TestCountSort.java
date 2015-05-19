package com.sunchao.sort;
import java.util.Arrays;

import junit.framework.*;
public class TestCountSort extends TestCase {
	
	private CountSort cs = new CountSort();
	
	public void testCountSort(){
		
		int[] array = {5,7,9,2,3,1,3,5,23,11,25};
		
		System.out.println("sort begin : "+ Arrays.toString(array));
		 
	    cs.countSort(array,25);
	    
	 //   System.out.println("sort end : "+ Arrays.toString(array));
	}

}
