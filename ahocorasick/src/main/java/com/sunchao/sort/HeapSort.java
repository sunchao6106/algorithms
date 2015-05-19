package com.sunchao.sort;
/**
 * build max heap;
 * @author sunchao
 *
 */
public class HeapSort {

	private void swap(int[] array,int x,int y){
		int tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
	}
	
	private int parent(int index){
		return (index - 1) >> 1;
	}
	
	private int leftChild(int index){
		return ((index + 1) << 1) -1;
	}
	
	private int rightChild(int index){
		return (index + 1) << 1;
	}
	
	public void heapSort(int[] array){
		if(array.length == 0 || array.length == 1) return ;
		buildMaxHeap(array);
		for(int i = array.length - 1 ; i > 0 ; i--){
			swap(array,0,i);
			heapify(array,0,i);
		}
	}

	private void heapify(int[] array,int index,int length){
		int next = index;
		int left = leftChild(index);
		int right = rightChild(index);
		if(left < length && array[left] > array[next])
			next = left;
		if(right < length && array[right] > array[next])
			next = right;
		if(next == index)  return;
		swap(array,index,next);
		heapify(array,next,length);
	}
	
	public void heapify(int[] array,int index){
		heapify(array,index,array.length);
	}
	/**
	 * the max heap with the direction of upstream;
	 * @param array
	 */
	public void buildMaxHeap(int[] array){
		int length = array.length;
		for(int i = (length - 2) >> 1 ; i >= 0 ; i--){
			heapify(array,i,length);
		}
	}
}
