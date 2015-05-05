package com.sunchao.ahocorasick;


 /*
  * 
  * The Array implementation of EdgeList ,Very fast lookup access(use array), but the memory .....
  * 
  */
    class DenseEdgeList  implements EdgeList {

      private State[] array;
      
      
      public DenseEdgeList(){
    	  
    	  array = new State[256];
    	  
    	  for(int i = 0 ; i < array.length ; i++){
    		  
    		  array[i]  = null;
    	  }
    	  
      }
    	 
      /*
       * The Unitity of converting to DenseEdgeList;
       * 
       * (non-Javadoc)
       * @see com.sunchao.morepatternstringmatch.EdgeList#get(byte)
       */
      public static DenseEdgeList fromSparse(SparseEdgeList list){
    	  
    	  byte[] keys  = list.keys();
    	  
    	  DenseEdgeList newInstance = new DenseEdgeList();
    	  
    	  for(int i =0 ; i < keys.length ;i++){
    		  
    		  newInstance.put(list.get(keys[i]),keys[i]);
    	  }
    	  
    	  return newInstance;
      }
      
      
	 
	  public State get(byte ch) {
		
		  return this.array[(int)ch & 0xFF];
	  }

	 
	  public void put(State state, byte ch) {
		
		  this.array[(int)ch & 0xFF] = state;
	  }

	 
	  public byte[] keys() {
		
		  int length = 0;
		  
		  for(int i = 0 ; i < array.length ;i++){
			  
			  if(array[i] != null)
				  
				  length ++;
			  
		  }
		  
		  byte[] b = new byte[length];
		  
		  int j = 0;
		  
		  for(int i = 0 ; i < array.length ; i++){
			  
			  if(array[i] != null){
				  
				  b[j++] = (byte)i;
			  }
		  }
		  
		  return b;
	  }

}
