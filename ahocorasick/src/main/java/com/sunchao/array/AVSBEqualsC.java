package com.sunchao.array;
/**
 * the array is sorted
 * Find two numbers in array which the total number sum equals another number
 * @author sunchao
 *
 */
public class AVSBEqualsC {

	public static void  getAVSBEqualsC(int[] array,int c){
		int length = array.length;
		if(length == 2)
			return;
		int left  = 0,right = length-1;
		while(left < right){
			if(array[left] + array[right] == c){
				System.out.println("A is =>" + array[left]  + "  B is => " + array[right]);
				break;
			}
			else if(array[left] + array[right] < c)
				left++;
			else
				right--;
		}
	}
	
	public static void main(String args[]){
		int[] array = {1,3,4,6,7,8,10};
	    getAVSBEqualsC(array, 12);	
	}
}
