package com.sunchao.sort;

public class InsertSort {

	public  void  insertSort(int[] array){
		int i,j;
		if(array.length == 0 || array.length ==1) return;
		for(i = 1 ; i < array.length ; i++){
			int tmp = array[i];
			for(j = i ; j > 0 && tmp < array[j-1] ; j-- )
				array[j] = array[j - 1];
			array[j] = tmp;
		}
	}
}
