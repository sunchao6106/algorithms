package com.sunchao.sort;

public class ShellSort {
	
	public void shellSort(int[] array){
		if(array.length == 0 || array.length == 1) return;
		int gap,i,j ;
		for(gap = array.length / 2 ; gap >= 1  ; gap /= 2){
			for(i = gap ; i < array.length ; i++){
				int tmp = array[i];
				for(j = i ; j - gap >= 0 && tmp < array[j-gap] ; j -= gap )
					array[j] = array[j-gap];
				array[j] = tmp;
			}
		}
	}

}
