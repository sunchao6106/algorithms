package com.sunchao.array;

public class GreatestSumOfSubArray {
	
	public static int getGreatestSumOfArray(int[] array){
		int curSum = 0;
		int greatestSum = 0x80000000;
		if(array.length == 0) return greatestSum;
		if(array.length == 1) return array[0];
		for(int i = 0 ; i < array.length ; i++){
			if(curSum <= 0)
				curSum = array[i];
			else
				curSum += array[i];
			if(curSum > greatestSum)
				greatestSum = curSum;
		}
		return greatestSum;
	}
	
	
	public static void main(String args[]){
		int[] array = {1,-1,-2,-3,-4};
		int  x = getGreatestSumOfArray(array);
		System.out.println(x);
	}

}
