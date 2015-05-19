package com.sunchao.string;

public class RecursiveStringPermutation {
    //Permutation pailie
	/**
	 * Permutation 
	 * @param s
	 * @param x
	 * @param y
	 * @return
	 */
	private static boolean isSwap(char[] s,int x,int y){
		for(int i = x ; i < y ; i++)
			if(s[i] == s[y])
				return false;
		return true;
	}
	private static void swap(char[] s, int x, int y){
		char tmp = s[x];
		s[x] = s[y];
		s[y] =tmp;
	}
	public static void recursivePermutation(String s){
		if(s ==  null || s.length() == 0) return ;
		char[] array = s.toCharArray();
		permutation(array, 0, array.length);
	}
	
	private static void permutation(char[] array, int index, int size){
		if(index == size){
			for(int i = 0 ; i < array.length ; i++)
				System.out.print(array[i]+"");
			System.out.println();
		}else{
			for(int i = index ; i < size ; i++){
				if(isSwap(array,index,i)){
				      swap(array, index, i);
				      permutation(array, index+1, size);
				      swap(array, index, i);
				}
			}
		}
	}
	
	private static void permutation1(char[] array, int index, int size){
		if(index == size){
			for(int i = 0 ; i < array.length ; i++)
				System.out.print(array[i] + "");
			System.out.println();
		}else{
			for(int i = index ; i < size ; i++){
				if(isSwap(array, index, i)){
					swap(array,index,i);
					permutation(array,index+1,size);
					swap(array,index,i);
				}
			}
		}
	}
	public static void main(String args[]){
		String s = "acac";
		recursivePermutation(s);
	}
}
