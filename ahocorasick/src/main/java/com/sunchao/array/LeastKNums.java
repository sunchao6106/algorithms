package com.sunchao.array;

import java.util.Arrays;
import java.util.Random;

public class LeastKNums {
	
	 private static void swap(int[] array, int x, int y){
		 int tmp = array[x];
		 array[x] = array[y];
		 array[y] = tmp;
	 }
	private static int random(int left,int right){
		int size = right - left + 1;
		return left + (int)Math.random() % size;
	}
	
	public static int partition(int[] array, int left, int right){
		if(array.length == 0 || left < 0 || right >= array.length) return -1;
		int pos = left - 1;
		int pivot = array[right];
		for(int i = left ; i < right ; i++){
			if(array[i] < pivot){
				swap(array,++pos,i);
			}
		}
		swap(array,++pos,right);
		return pos;
	}
	
	public static int randomPartition(int[] array,int left,int right){
		if(array.length == 0 || left < 0 || right >= array.length) return -1;
		int random = random(left,right);
		swap(array,random,right);
		return partition(array,left,right);
	}
	
	public static void getLeastKNum(int[] array,int k,int[] tmp){
		if(k <= 0 || k >= array.length || array.length == 0)  return;
		int start =0,end = array.length -1;
		int index = randomPartition(array, start, end);
		while(index != k -1){
			if(index > k -1){
				end = index -1;
				index = randomPartition(array, start, end);
			}else{
				start = index + 1;
				index = randomPartition(array, start, end);
			}
		}
		for(int i = 0; i < k ;i++){
			tmp[i] = array[i];
		}
	}
	 
	
	 public static void main(String args[]){
			int[] array ={7, 8, 9, 54, 6, 4, 2, 1, 12, 33};
			int[] tmp = new int[7];
			getLeastKNum(array, 7, tmp);
			System.out.println(Arrays.toString(tmp));
			
			
		}

}
