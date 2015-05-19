package com.sunchao.sort;
import java.util.Arrays;

import junit.framework.*;

public class TestInsertSort extends TestCase {

	private InsertSort is = new InsertSort();
	
	public void testInsertSort(){
		
		int[] array = {5,7,9,2,3,0,1,3,5,645,23,11,87};
		
		System.out.println("sort begin : "+ Arrays.toString(array));
		 
	    is.insertSort(array);
	    
	    System.out.println("sort end : "+ Arrays.toString(array));
	}
}
