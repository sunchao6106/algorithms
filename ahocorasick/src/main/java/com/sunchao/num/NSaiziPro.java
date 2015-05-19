package com.sunchao.num;
/**
 * N shai zi and  get the sum of N;
 * and get probability
 * @author sunchao
 *
 */
public class NSaiziPro {

	private static int G_MAXVALUE = 6;
	/**
	 * N 个 筛子 和从 n 到 6n ,数组长度为6n-n+1;
	 *深度搜索 
	 * 筛子 Dice
	 * @param number
	 */

	/**
	 * n => the number of dice;
	 * s => the sum of dices;
	 * F(n,s) => the number of the sum; which is DP solution.
	 * 递推公式  F(n,s) = F(n-1,s-1)+ F(n-1,s-2)+ F(n-1,s-3)+F(n-1,s-4)+F(n-1,s-5)+F(n-1,s-6);
	 * F(1,s) = 1
	 * 
	 * @param number
	 */
	public static void printProbabilities(int number){
		
		int dLen = number * G_MAXVALUE + 1;
		
		int[][] F = new int[number + 1][];
		
		for(int i = 0; i <= number; i++)
			F[i] = new int[dLen];
		
		setCount(F, number, dLen);
		
		double total = Math.pow((double)G_MAXVALUE,number);
		
		int nCur = number;
		while(nCur < dLen){
			double ratio = (double)F[number][nCur] / total;
			System.out.println("The sum is :" + nCur +" , the probability is : " + ratio);
			nCur++;
		}
		
		
	}
	
	public static void main(String args[]){
		int number = 3;
		printProbabilities(number);
	}
	
	private static void setCount(int[][] F, int diceNum, int dLen){
		
		for(int i = 0; i <= diceNum; i++)
			for(int j = 0; j < dLen; j++)
				F[i][j] = 0;
		
		for(int i = 0; i <= G_MAXVALUE; i++)
			F[1][i] = 1;
		
		for(int i = 2; i <= diceNum; i++)
			for(int j = i; j <= G_MAXVALUE * i; j++)
				for(int k = 1; j > k && k <= G_MAXVALUE; k++)
					F[i][j] += F[i-1][j-k];
		
	}
}
