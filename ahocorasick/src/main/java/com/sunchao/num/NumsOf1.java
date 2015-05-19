package com.sunchao.num;
/**
 * n is positive,with 1 t0 n
 * 
 * @author sunchao
 *
 */
public class NumsOf1 {
	
	public static long getNumsOf1Between1AndN(long n){
		if(n <= 0) return  -1;
		long counts = 0;
		for(long i = 1; i <= n; i++)
			counts += getNumsOf1(i);
		return counts;
	}

	private static long getNumsOf1(long n){
		long counts = 0;
		while(n != 0){
			if(n % 10 == 1)
				counts++;
			n = n / 10;
		}
		return counts;
	}
	public static void main(String args[]){
		long counts = getNumsOf1Between1AndN(1230000000);
		long counts1 = getNumsOf1Between1AndN2(1230000000);
		System.out.println(counts);
		System.out.println(counts1);
	}
	
	//O(n);
	public static long getNumsOf1Between1AndN2(long n){
		if(n <= 0) return -1;
		long counts = 0;
		long Factor = 1;
		//  lower bit nums 
		long lowerNum = 0;
		// current nums
		long curNum = 0;
		// high nums
		long highNum = 0;
		
		while(n / Factor != 0){
			lowerNum = n - (n / Factor) * Factor;
			curNum = (n / Factor) % 10;
			highNum = n /(Factor * 10);
			//如果为0,出现1的次数由高位决定
			if(curNum == 0)
				 //等于高位数字 * 当前位数
				counts += highNum * Factor;
			else if(curNum == 1)
				 //高位数字 * 当前位数 + 低位数字 + 1
				counts += highNum * Factor + lowerNum + 1;
			else 
				//如果大于1,出现1的次数由高位决定
				//（高位数字+1）* 当前位数
				counts += (highNum + 1) * Factor;
			Factor *= 10;//前进一位；
		}
		return counts;
	}
}
