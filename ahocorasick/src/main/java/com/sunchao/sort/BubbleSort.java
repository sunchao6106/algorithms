package com.sunchao.sort;

public class BubbleSort {

	private void swap(int[] array,int x,int y){
		int tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
	}
	public void bubbleSort(int[] array){
		if(array.length == 0 || array.length == 1) return;
		int i,j;
		for(i = 0 ; i < array.length-1 ; i++){
			for(j = 0 ; j < array.length -1 - i ; j++){
				if(array[j] > array[j+1])
					swap(array,j,j+1);
			}
				
		}
	}
}
