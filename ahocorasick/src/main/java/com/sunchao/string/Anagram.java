package com.sunchao.string;
/**
 * Anagram
 *   e.g.  evil => live
 * @author sunchao
 *
 */
public class Anagram {
 // O(n)
	public static boolean isAnagram(String s1,String s2){
		if(s1.length() == 0 || s2.length() == 0)
			return false;
	    int length1 = s1.length();
	    int length2 = s2.length();
	    if(length1 != length2)
	    	return false;
	    int[] hashTable = new int[256];
	    for(int i = 0; i < length1; i++){
	    	hashTable[s1.charAt(i)]++;
	    }
	    for(int j =0 ; j < length2; j++){
	    	hashTable[s2.charAt(j)]--;
	    }
	    for(int k = 0; k < 256; k ++){
	    	if(hashTable[k] != 0)
	    		return false;
	    }
	    return true;
	}
	
	public static void main(String args[]){
		boolean flag =  isAnagram("evilj","live");
		System.out.println(flag);
	}
}
