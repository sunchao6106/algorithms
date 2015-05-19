package com.sunchao.array;
/**
 * 
 * @author sunchao
 *
 */
public class MoreThatHalfNum {

	private static void swap(int[] array, int x, int y){
		int tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
	}
	
    private static int random(int left, int right){
    	int size = right - left + 1;
    	return left + (int)Math.random() % size; 
    }
	
	private static int partition(int[] array, int left, int right){
		int key = array[right];
		int pos = left-1;
		for(int i = left; i < right; i++){
			if(array[i] < key){
				swap(array,++pos,i);
			}
		}
		swap(array,++pos,right);
		return pos;
	}
	
	public static int randomPartition(int[] array,int left, int right){
		int length = array.length;
		if(length == 0 || left < 0 || right >= length) return -1;
		int random = random(left,right);
		swap(array,random,right);
		return partition(array,left,right);
	}
	
	public static int moreThanHalfNum(int[] array){
		int length = array.length;
		if(length == 0) return -1;
		int middle = length >> 1;
		int start = 0, end = length -1;
		
		int index = randomPartition(array, start, end);
		while(index != middle){
			if(index > middle){
				end = index -1;
				index = randomPartition(array, start, end);
			}else{
				start = index +1;
				index = randomPartition(array, start, end);
			}
		}
			
		int result = array[middle];
		return result;
	}
	
	public static int checkTheTotalNum(int[] array){
		int num = moreThanHalfNum(array);
		System.out.println(num);
		int length = array.length;
		int count =0 ;
		for(int i = 0 ; i < length ; i++){
			if(array[i] == num)
				count++;
		}
		if(count > (length >> 1))
			return 1;
		else
			return 0;
	}
	

	
	public static void main(String args[]){
		int[] array ={3,6,1,2,4,7,9,10};
		int  key =checkTheTotalNum(array);
		System.out.println(key);
	}
}
