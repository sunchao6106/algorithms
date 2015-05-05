package com.sunchao.ahocorasick;

import java.util.HashSet;
import java.util.Set;
    
  /*
   * trie tree'node  
   *  Author : Tom Sun
   * 
   */

class State{

	   private static final int THRESHOLD_TO_USE_SPARSE = 3;
	   
	   
	   private int depth;
	   private EdgeList edgeList;
	   private State fail;
	   private Set outputs;
	   
	   public State(int depth){  
		   this.depth = depth;
		   if(depth > THRESHOLD_TO_USE_SPARSE)
			   edgeList =  new SparseEdgeList();
		   else
			   edgeList =  new DenseEdgeList();
		   fail = null;
		   outputs = new HashSet();
	   }
	   
	   public State extend(byte b){
		   if(this.edgeList.get(b) != null)
			   return this.edgeList.get(b);
		   State newState = new State(this.depth+1);
		   this.edgeList.put(newState, b);
		   return newState;
	   }
	   
	   public State extendAll(byte[] b){
		   State state = this;
		   for(int i = 0 ; i < b.length ; i++){
			   if(state.edgeList.get(b[i]) != null)
				   state = state.edgeList.get(b[i]);
			   else
				   state = state.extend(b[i]);   
		   }
		   return state;
	   }
	    
	   /**
	    * Returns the size of the tree rooted at this State.  Note: do
        * not call this if there are loops in the edgelist graph, such as
        * those introduced by AhoCorasick.prepare().
	    * 
	    * 
	    */
	   
	   public int size(){
		   byte[] keys = this.edgeList.keys();
		   int result = 1;
		   for(int i = 0 ; i < keys.length ; i++)
			   result += edgeList.get(keys[i]).size();
		   return result;
	   }
	   
	   public State get(byte b){
		   return this.edgeList.get(b);
	   }
	   
	   public void put(State s, byte b){
		   this.edgeList.put(s, b);
	   }
	   
	   public byte[] keys(){
		   return this.edgeList.keys();
	   }
	   
	   public State getFail(){
		   return this.fail;
	   }
	   
	   public void setFail(State s){
		   this.fail = s;
	   }
	   
	   public void addOutputs(Object o){
		   this.outputs.add(o);
	   }
	   
	   public Set getOutputs(){
		   return this.outputs;
		   
	   }
}
