package com.sunchao.string;

/**
 * 256
 * get the first and no repeat char
 * @author sunchao
 *
 */
public class FirstNoRepeatChar {
 // O(n)
	public static char getFirstAndNoRepeatChar(String s){
		if(s == null) return (char) -1;
		char[] charArray = s.toCharArray();
		int length = charArray.length;
		if(length == 1) return s.charAt(0);
		int[] hashTable = new int[256];
		int i;
		for( i = 0; i < length; i++){
			hashTable[charArray[i]]++;
		}
		for(i = 0; i < length ; i++){
			if(hashTable[charArray[i]] == 1)
				break;
		}
		if(i == length)
			return (char) -1;
		return charArray[i];
	}
	
	public static void main(String args[]){
		char c = getFirstAndNoRepeatchar("abaccdeff");
		System.out.println(c);
	}
	//O(n^2)
	public static char getFirstAndNoRepeatchar(String s){
		if(s == null) return (char) -1;
		if(s.length() == 1) return s.charAt(0);
		int i,j;
		for( i = 0 ; i < s.length() ; i++){
			char c = s.charAt(i);
			for(j = i + 1; j < s.length() ; j++){
				if(c == s.charAt(j))
					break;
			}
			if(j == s.length())
				return s.charAt(i);
		}
		return (char)-1;
	}
}
