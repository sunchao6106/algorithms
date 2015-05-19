package com.sunchao.eightqueen;

/**eight queen(with limit of the same x and y and )
 * 
 * @author sunchao
 *
 */
public class EightQueen {

	static int num = 0;
	int queens = 8;
	static int columnIndex[] = new int[8];
	
	public EightQueen(){
		
		for(int i = 0 ; i < 8 ; i++){
			columnIndex[i] = i;
		}
	}
	
   public boolean check(int[] columnIndex){
	   int length = columnIndex.length;
	   for(int i = 0 ; i < length ; i++){
		   
		   for(int j = i+1 ;j < length ; j++){
			   
			   if(i -j == columnIndex[i] - columnIndex[j] || j -i == columnIndex[i] - columnIndex[j])
				   
				   return false;
		   }
		   
	   }
	   return true;
   }
   
   private void swap(int[] columnIndex, int x, int y){
	   int tmp = columnIndex[x];
	   columnIndex[x] = columnIndex[y];
	   columnIndex[y] = tmp;
   }
   
   public void permutation(int[] columnIndex){
	   if(columnIndex.length == 0) return;
	   permutation(columnIndex,0,columnIndex.length);
   }
   
   private void print(int[] columnIndex){
	   for(int i = 0 ; i < columnIndex.length ; i++){
		   System.out.print(columnIndex[i] +" ");
	   }
	   System.out.println();
   }
   private void permutation(int[] columnIndex,int index, int size){
	   if(index == size){
		   if(check(columnIndex)){
			   num++;
		       print(columnIndex);
		   }
	   }
	   else{
		   for(int i = index ; i < size ; i++){
			   swap(columnIndex,index,i);
			   permutation(columnIndex,index+1,size);
			   swap(columnIndex,index,i);
		   }
	   }
   }
   public static void main(String args[]){
	   EightQueen queen = new EightQueen();
	   queen.permutation(columnIndex);
	   System.out.println(num);
	   
   }
}
