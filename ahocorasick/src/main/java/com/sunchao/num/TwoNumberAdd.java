package com.sunchao.num;
/**
 * Two Number Add
 * except add sub mul div operation
 * @author sunchao
 *
 */
public class TwoNumberAdd {
/**3 = 011
 * 5 = 101
 *  ^  110
 *  & << 1 =001 << 1 = 010
 *   100  010 << 1 = 100
 *    000  100 << 1 = 1000;
 * @param num1
 * @param num2
 * @return
 */
	public static int add(int num1,int num2){
		int sum = 0, carry = 0;
		do{
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		}while(carry != 0);
		
		return num1;
	}
	
	public static void main(String args[]){
		
		int sum = add(3,5);
		System.out.println(sum);
	}
}
