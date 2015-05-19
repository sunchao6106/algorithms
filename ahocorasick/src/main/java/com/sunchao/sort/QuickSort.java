package com.sunchao.sort;
/**
 * Median
 * @author sunchao
 *
 */
public class QuickSort {
	private static final int THRESHOLD = 10;
	private void swap(int[] array,int x ,int y){
		int tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
	}
	
	private int median3(int[] array,int left ,int right){
		int lo = array[left];
		int hi = array[right];
		int center = (left + right) >> 1;
		if(array[center] < lo) swap(array,left,center);
		if(hi < lo) swap(array,lo,right);
		if(hi < array[center]) swap(array,center,right);
		swap(array,center,right-1);
		return array[right - 1];
	}

	private void quickSort(int[] array,int left,int right){
		if(left + THRESHOLD  <= right){
			int pivot = median3(array, left, right);
			int i = left,j = right - 1;//因为median3已经对三个数排过序了；
			for(;;){
				while(array[--j] > pivot){}
				while(array[++i] < pivot){}
				if(i < j)
					swap(array,i,j);
				else
					break;
			}
			swap(array,i,right-1);
			quickSort(array,left,i-1);
			quickSort(array,i+1,right);
		}else{
			for(int i = left + 1 ; i <= right ; i++){// <=
				int tmp = array[i];
				int j;
				for(j = i ; j > 0 && tmp < array[j-1] ; j--)//tmp
					array[j] = array[j-1];
				array[j] = tmp;
			}
		}
	}
	public void quickSort(int[] array){
		quickSort(array,0,array.length-1);
	}
}
