package com.sunchao.sort;

public class BinarySort {

	 public void binarySort(int[] array){
		if(array.length == 0 || array.length == 1) return;
		int i,j,left,right,center;
		for(i = 0 ; i < array.length ; i++){
			int tmp = array[i];
			left = 0 ; right = i - 1;
			while(left <= right){
				center = (left + right) >> 1;
			    if(tmp < array[center])
			    	right = center - 1;
			    else
			    	left = center + 1;
			}
			for(j = i ; j > left ; j--)
				array[j] = array[j-1];
			array[j] = tmp;
			
		}
	 }
}
