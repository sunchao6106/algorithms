package com.sunchao.sort;

public class QuickSort1 {
	private void swap(int[] array,int x,int y){
	    int tmp = array[x];
	    array[x] = array[y];
	    array[y] = tmp;
	}
	
	private int partition(int[] array,int lo ,int hi){
		int pivot = array[hi];
		int i = lo -1;
		for(int j = lo ; j < hi ; j++){
			if(array[j] < pivot)
				swap(array,++i,j);

		}
		swap(array,++i,hi);
		return i;
	}
	
	private void quickSort(int[] array,int lo,int hi){
		if(lo < hi){
			int center = partition(array, lo, hi);
			quickSort(array,lo,center-1);
			quickSort(array, center+1, hi);
		}
	}
	
	public void quickSort(int[] array){
		   quickSort(array,0,array.length-1);
	}

}
