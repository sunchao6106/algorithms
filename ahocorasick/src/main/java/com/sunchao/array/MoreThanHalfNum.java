package com.sunchao.array;

public class MoreThanHalfNum {
	
	public static boolean checkTheNum(int[] array,int result){
		int counts = 0;
		for(int i = 0 ; i < array.length ;i++){
			if(array[i] == result)
				counts++;
		}
		if(counts > (array.length >> 1))
			return true;
		return false;
	}
	
	public static  int getMoreThanHalfNum(int[] array){
		int length = array.length;
		if(length == 0) return -1;
		int result = array[0];
		int counts  =1;
		for(int i = 1 ; i < length ; i++){
			if(counts == 0){
				result = array[i];
				counts = 1;
			}else if(array[i] == result)
				counts++;
			 else
				 counts--;
		}
		boolean isOK = checkTheNum(array, result);
		return isOK ? result : 0;
	}
   
	public static void main(String args[]){
		int[] array ={2,2,2,2,2,2,7,9,10};
		int  key =getMoreThanHalfNum(array);
		System.out.println(key);
	}
}
