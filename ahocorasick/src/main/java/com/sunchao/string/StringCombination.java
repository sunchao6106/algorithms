package com.sunchao.string;

import java.util.Stack;

/**
 * string combination
 * @author sunchao
 *
 */
public class StringCombination {
	
	public static void combination(String s){
		assert s != null;
		char[] array = s.toCharArray();
		if(array.length == 0) return;
		Stack<Character> stack = new Stack<Character>();
		int i, length = s.length();
		for(i = 1 ; i <= length ; i++)
			combination(array,0,i,stack);
	}
    private static void combination(char[] array, int index, int num , Stack<Character> stack){
	   if(num == 0){
		   System.out.println(stack.toString());
		   return;
	   }
	   if(index == array.length)
		   return ;
	   stack.push(array[index]);
	   combination(array, index+1, num-1, stack);
	   stack.pop();
	   combination(array,index+1,num,stack);
   }
   
   public static void main(String args[]){
	   String s = "abcdf";
	   combination(s);
   }
}
