package com.sunchao.sort;

import java.util.Arrays;

public class MergeSort {
	
	private void swap(int[] array,int x,int y){
		int tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
	}
	
	private void mergeSort(int[] array,int[] tmp,int lo,int hi){
		
		if(lo < hi){
			int center = (lo + hi) >> 1;
		    mergeSort(array, tmp, lo, center);
		    mergeSort(array, tmp, center+1, hi);
		    merge(array, tmp, lo, center, hi);
		}
	}

	private void merge(int[] array,int[] tmp,int loPos,int loEnd,int hiEnd){
		int hiPos = loEnd + 1;
		int tmpPos = loPos;
		int nums = hiEnd - loPos +1;
		while(loPos <= loEnd && hiPos <= hiEnd){
			if(array[loPos] < array[hiPos])
				tmp[tmpPos++] = array[loPos++];
			else
				tmp[tmpPos++] = array[hiPos++];
		}
		while(loPos <= loEnd)
			tmp[tmpPos++] = array[loPos++];
		while(hiPos <= hiEnd)
			tmp[tmpPos++] = array[hiPos++];
		for(int i = 0 ; i < nums ; i++ , hiEnd--)
			array[hiEnd] = tmp[hiEnd];
		
	}
	
	public void mergeSort(int[] array){
		int[] tmp = new int[array.length];
		mergeSort(array,tmp,0,array.length-1);
	}
	
	
	public static void  mergeSort1(int[] array,int[] copy){
		if(array.length == 0 || array.length == 1) return;
		int length  =  array.length;
		
		for(int i = 0;  i < length ; i++){
			copy[i] = array[i];
		}
		merge1(array,copy,0,length-1);
	}
	
	private static void merge1(int[] array,int[] copy,int start,int end){
		if(start == end){
			copy[start] = array[start];
			return;
		}
		int center =(end - start) /2;
		merge1(copy,array,start,start+center);
		merge1(copy,array,start+center+1,end);
		int i =  start+center;
		int j  = end;
		int indexCopy = end;
		while( i >= start && j >= start+center+1){
			if(array[i] > array[j])
				copy[indexCopy--] = array[i--];
			else
				copy[indexCopy--] = array[j--];
		}
		
		for(; i >= start ; --i){
			copy[indexCopy--] = array[i];
		}
		
		for(; j >= start+center+1;--j){
			copy[indexCopy--] = array[j];
		}
	}
	public static void main(String[] args){
		int[] array = {7,4,5,6,8};
		int[] tmp = new int[5];
		mergeSort1(array,tmp);
		System.out.println(Arrays.toString(tmp));
	}
}
