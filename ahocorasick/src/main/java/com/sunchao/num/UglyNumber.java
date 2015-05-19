package com.sunchao.num;

/**Ugly Number with the factor of 2,3,5
 * 
 * @author sunchao
 *
 */
public class UglyNumber {

	public static boolean isUgly(int num){
		if(num < 1){
			return false;
		}
		while(num % 2 == 0)
			 num /= 2;
		while(num % 3 == 0)
			 num /= 3;
		while(num % 5 == 0)
			num /= 5;
		return num == 1 ? true : false;
	}
	
	public static int getUglyNumber(int index){
		int counts = 0 ;
		int number = 0;
		while(counts < index){
			++number;
			if(isUgly(number))
				counts++;
		}
		return number;
	}
	
	public static void main(String args[]){
		//int number = getUglyNumber(1500);
		int number = getUglyNumber2(1500);
		System.out.println(number);
	}
	
	/**
	 * 
	 * 
	 */
	public static int getUglyNumber2(int index){
		if(index <= 0)
			return  -1;
		int[] uglyNumbers = new int[index];
		uglyNumbers[0] = 1;
		int nextUglyIndex = 1;
		int multiply2 = 0,multiply3 = 0,multiply5 = 0;
		while(nextUglyIndex < index){
			
			int min  = min(uglyNumbers[multiply2]*2, uglyNumbers[multiply3]*3, uglyNumbers[multiply5]*5);
			
			uglyNumbers[nextUglyIndex] = min;
			
			while(uglyNumbers[multiply2]*2 <= uglyNumbers[nextUglyIndex])
				multiply2++;
			while(uglyNumbers[multiply3]*3 <= uglyNumbers[nextUglyIndex])
				multiply3++;
			while(uglyNumbers[multiply5]*5 <= uglyNumbers[nextUglyIndex])
				multiply5++;
			++nextUglyIndex;
		}
		return uglyNumbers[index -1];
	}
	
	public static int min(int number1,int number2,int number3){
		int min = (number1  < number2) ? number1 : number2;
		return (min < number3) ? min : number3;
		
	}
}
