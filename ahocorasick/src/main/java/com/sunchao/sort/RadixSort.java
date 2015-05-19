package com.sunchao.sort;

import java.util.ArrayList;

/**
 * radix sort
 * @author sunchao
 *
 */
public class RadixSort {

	private void swap(int[] array,int x, int y){
		int tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
	}
	
	public void radixSort(int[] array){
		int max = array[0];
		for(int i = 1 ; i < array.length ; i++)
			if(array[i] > max)
				 max = array[i];
		int radix = 0 ;
		while(max > 0){
			max /= 10;
			radix++;
		}
		ArrayList<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
        for(int i = 0 ; i < 10 ; i++)
        	queue.add(new ArrayList<Integer>());
        for(int i = 0 ; i < radix ; i++){
        	for(int j = 0 ; j < array.length ; j++){
        		int index =  array[j] % (int)Math.pow(10 , i + 1)/(int) Math.pow(10, i);
        		ArrayList<Integer> list = queue.get(index);
        		list.add(array[j]);
        	}
        	int count = 0 ;
        	for(int k = 0 ; k < 10 ; k++){
        		ArrayList<Integer> list = queue.get(k);
        		while(list.size() > 0)
        			 array[count++] = list.remove(0);
        	}
        }
        
		
	}
	
}
