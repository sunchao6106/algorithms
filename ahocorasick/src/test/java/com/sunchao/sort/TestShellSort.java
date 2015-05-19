package com.sunchao.sort;

import java.util.Arrays;

import junit.framework.TestCase;

public class TestShellSort extends TestCase {
	
	private ShellSort ss = new ShellSort();
	
	public void testShellSort(){
		int[] array = {5,7,9,2,3,0,1,3,5,645,23,11,87};
		
		System.out.println("sort begin : "+ Arrays.toString(array));
		 
	    ss.shellSort(array);
	    
	    System.out.println("sort end : "+ Arrays.toString(array));
	}

}
