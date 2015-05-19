package com.sunchao.sort;

public class SelectSort {
	
	private void swap(int[] array,int x,int y){
		//array[x] = array[x]^array[y];
		//array[y] = array[x]^array[y];
		//array[x] = array[x]^array[y];
		int tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
	}
	public void selectSort(int[] array){
		if(array.length == 0 || array.length == 1) return;
		int minIndex,minValue,tmp;
		for(int i = 0 ; i < array.length ; i++){
			minIndex = i;
			tmp = minValue = array[i];
			for(int j = array.length -1 ; j > i ; j--){
				if(array[j] < minValue){
					minIndex = j;
					minValue =  array[j];
				}
			}
			swap(array,i,minIndex);
		}
	}

}
