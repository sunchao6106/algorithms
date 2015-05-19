package com.sunchao.array;
/**
 * Find the two numbers that only the two numbers in the array appear only one times
 * @author sunchao
 *
 */
public class FindNumsAppearOnce {

	/**
	 *  0 ^ A = A;
	 *  A ^ A = 0;
	 *  A ^ -1 = -A;
	 * @param array
	 */
	public static void findNumsAppearOnce(int[] array){
		int length = array.length;
		if(length  <= 2)
			return ;
		int resultExclusiveOR = 0;//
		for(int i = 0; i < length; i++)
			resultExclusiveOR ^= array[i];
	    int index  = getFirstBitIndexOf1(resultExclusiveOR);
	    int num1 = 0,num2 = 0;
	    for(int i = 0 ; i < length ; i++){
	    	if(isBitEquals1(array[i], index))
	    		num1 ^= array[i];
	    	else 
	    		num2 ^= array[i];
	    }
	    System.out.println("The first num =>" + num1 + "The second num =>" + num2);
	}
	
	public static boolean isBitEquals1(int num,int index){
		if(((num >> index) & 0x1) == 1)
			return true;
		else 
			return false;
	}
	public static int getFirstBitIndexOf1(int num){
		int i = 0;
		for(; i < 32 ; i++)
			if(((num >> i) & 0x1) == 1)
				break;
		return i;
	}
	
	public static void main(String args[]){
		int[] array = {2,3,5,7,5,6,7,8,9,1,1,2,8,3};
		findNumsAppearOnce(array);
	}
}
