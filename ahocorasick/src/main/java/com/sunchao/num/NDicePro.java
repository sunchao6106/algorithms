package com.sunchao.num;
/**
 * N Dice Probabilities
 * 
 * @author sunchao
 *
 */
public class NDicePro {
	
	private static final int G_MAXVALUE = 6;
	
	public static void printProbabities(int number){
		if(number < 1)
			return;
		
		int[][] pProbabilities =  new int[2][];
		pProbabilities[0] = new int[G_MAXVALUE * number + 1];
		pProbabilities[1] = new int[G_MAXVALUE * number + 1];
		for(int i = 0; i < G_MAXVALUE * number + 1; ++i){
			pProbabilities[0][i] = 0;
			pProbabilities[1][i] = 0;
		}
		
		int flag = 0;
		for(int i = 1; i <= G_MAXVALUE; ++i)
			pProbabilities[flag][i] = 1;
		
		for(int k = 2; k <= number; ++k){
			for(int i = 0; i < k; ++i)
				pProbabilities[1-flag][i] = 0;
			
			for(int i = k; i <= G_MAXVALUE * k; ++i){
				pProbabilities[1 -flag][i] = 0;
				for(int j = 1; j <= i && j <=G_MAXVALUE; ++j)
					pProbabilities[1-flag][i] += pProbabilities[flag][i-j];
			}
			flag = 1 -flag;
		}
		
		double total = Math.pow((double)G_MAXVALUE, number);
		for(int i = number; i <= G_MAXVALUE * number; ++i){
			double ratio = (double)pProbabilities[flag][i] / total;
			System.out.println("the sum is : " + i +",the probability is :" + ratio );
		}
	}
	
	public static void main(String args[]){
		int number = 3;
		printProbabities(number);
	}

}
