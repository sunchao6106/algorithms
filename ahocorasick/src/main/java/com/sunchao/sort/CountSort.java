package com.sunchao.sort;

import java.util.Arrays;

/**
 *  countSort guide: the elements of array must be positive value , and
 *  the range of elements must be define , and need to know  the most biggest element;
 *  
 * @author sunchao
 *
 */
public class CountSort {

	public void countSort(int[] array,int max){
		int[] helper = new int[max+1];
		int[] arraycopy = new int[array.length];
		for(int i = 0 ; i < array.length ; i++){
			helper[array[i]]++;
		}
		for(int j = 1 ; j < helper.length ; j++ ){
			helper[j] += helper[j-1];
		}
		for(int k = array.length - 1 ; k >= 0 ; k--){
			int index = array[k];
			int pos = helper[index] - 1;
			arraycopy[pos] = array[k];
			helper[index]--;
		} 
		//System.arraycopy(array, 0, arraycopy, 0, arraycopy.length-1);
		System.out.println(Arrays.toString(arraycopy));
	}
}
