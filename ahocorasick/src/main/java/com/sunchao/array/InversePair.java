package com.sunchao.array;
/**
 * The Inverse Pair of Array;
 * @author sunchao
 *
 */
public class InversePair {
	
	public static int getInversePair(int[] array){
		int length = array.length;
		if(array.length == 0 || array.length == 1) return 0;
		int[] copy = new int[length];
		for(int i = 0 ; i < length ;i++)
			copy[i] = array[i];
		return inversePairCore(array,copy,0,length -1);
	}
	
	
    private static int inversePairCore(int[] array,int[] copy,int start,int end){
    	if(start == end){
    		copy[start] = array[start];
    		return 0;
    	}
    	
    	int length = (end - start) >> 1;
		int left = inversePairCore(copy,array,start,start+length);
		int right = inversePairCore(copy,array,start+length+1,end);
		int i = start+length;
		int j = end;
		int indexCopy = end;
		int count =0;
		while(i >= start && j >= start+length+1){
			if(array[i] > array[j]){
				copy[indexCopy--] = array[i--];
				count += j - start - length;
			}
			else{
				copy[indexCopy--] = array[j--];
			}
		}
		for(; i >= start ; i--){
			copy[indexCopy--] = array[i];
		}
		for(; j >= start+length + 1;--j){
			copy[indexCopy --] = array[j];
		}
		
    	return left + right + count;	
    }
    
    public static void main(String args[]){
    	int[] array = {7,6,5,4,3,2,1};
    	int num =  getInversePair(array);
    	System.out.println(num);
    }
	
}
