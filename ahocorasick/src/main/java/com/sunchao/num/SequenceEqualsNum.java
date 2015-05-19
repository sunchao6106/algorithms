package com.sunchao.num;
/**
 * Get a sequence which the length at least 2 is equals a number
 * which is positive.
 * @author sunchao
 *
 */
public class SequenceEqualsNum {

	public static void getSequenceAtLeast2EqualsNum(int num){
		if(num < 3)
			return;
		int left = 1,right = 2;
		int middle = (num + 1) >> 1;
		int curSum = left + right;
		while(left < middle){
			if(curSum == num)
				printNumSequence(left, right);
			while(curSum < num){
				curSum -= left;
				left++;
				if(curSum == num)
					printNumSequence(left, right);
			}
			right++;
			curSum += right;
		}
		
	}
	public static void printNumSequence(int left,int right){
		for(int i = left ; i <= right; i++){
			System.out.print(i+"");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		getSequenceAtLeast2EqualsNum(19);
	}
}
