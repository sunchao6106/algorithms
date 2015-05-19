package com.sunchao.string;
/**
 * O(n)
 * Remove The Repeat Char
 * @author sunchao
 *
 */

public class RemoveTheRepeatchar {

	public static String getTheStringRemoveTheRepeatChar(String s){
		if(s == null || s.length() == 1) return s;
		int[] hashTable = new int[256];
		StringBuilder sb =  new StringBuilder();
		for(int i = 0; i < s.length() ;i++){
		    if(hashTable[s.charAt(i)] == 1)
		    	continue;
		    hashTable[s.charAt(i)]++;
		    sb.append(s.charAt(i));
			
		}
		return sb.toString();
	}
	
	public static void main(String args[]){
		String s = getTheStringRemoveTheRepeatChar("googlee");
		System.out.println(s);
	}
}
