package com.sunchao.array;
/**
 * get the first key and the last key ,the number of the key
 * equals the length of end - first
 * 
 * The Number of a num in the sorted array
 * @author sunchao
 *
 */
public class TheNumsInSortedArray {

	/**
	 * get the first index of key
	 * 
	 * @param array
	 * @param key
	 * @param left
	 * @param right
	 * @return
	 */
	public static int getFirstKey(int[] array, int key, int left ,int right){
		if(left > right) return  -1;
		int middleIndex = (left + right) >> 1;
		int middleData  =  array[middleIndex];
		if(middleData == key){
			if((middleIndex > 0 && array[middleIndex - 1] != key) || middleIndex == 0)
				return middleIndex ;
			else
				right = middleIndex -1;
		}else if(middleData > key)
			right  = middleIndex -1;
		else
			left = middleIndex + 1;
			
		return getFirstKey(array,key,left,right);
	}
	/**
	 * get the last index of key
	 * 
	 * @param array
	 * @param key
	 * @param left
	 * @param right
	 * @return
	 */
	public static int getLastKey(int[] array,int key,int left,int right){
		if(left > right)
			return  -1;
		int middleIndex = (left + right) >> 1;
		int middleData = array[middleIndex];
		if(middleData == key){
			if(middleIndex < array.length -1 &&  array[middleIndex+1] != key || middleIndex == array.length -1)
				return middleIndex;
			else 
				left = middleIndex + 1;
		}else if(middleData > key)
			right  = middleIndex -1;
		else
			left  = middleIndex +1;
		return getLastKey(array,key,left,right);
	}
	/**
	 * O(logn)
	 * @param array
	 * @param key
	 * @return
	 */
	public static int getNumberOfKey(int[] array,int key){
		int length =  array.length ;
		if(length == 0) return  -1;
		int num = 0;
		int first = getFirstKey(array, key, 0, length-1);
		int last = getLastKey(array,key,0,length -1);
		if(first > -1 && last > -1)
			num = last - first + 1;
		return num;
		
	}
	
	public static void main(String args[]){
		int[] array = {1,2,3,3,3,3,3,3,3,4,5};
		int key = 3;
		int num = getNumberOfKey(array,key);
		System.out.println(num);
	}
}
