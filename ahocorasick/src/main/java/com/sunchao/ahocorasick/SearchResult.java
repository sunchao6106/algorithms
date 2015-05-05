package com.sunchao.ahocorasick;

import java.util.Set;



/**
 * 
 * <p>Holds the result of search so far. Includes  the outputs of
 * search finished as well as the last index of match</p>
 * 
 * <p> Internally , It also holds  enough  state to continue a running
 * match</p>
 * 
 * 
 * @author sunchao
 *
 */
public class SearchResult {

	State lastMatchedState ;
	byte[]  bytes;
	int lastIndex;
	
	SearchResult(State state ,byte[] bytes, int lastIndex){
		this.lastMatchedState = state;
		this.bytes = bytes;
		this.lastIndex =  lastIndex;
	}
	
	/**
	 * 
	 *  Return a Set outputs;
	 */
	
	public Set getOutputs(){
		return this.lastMatchedState.getOutputs();
	}
	
	/**
	 * Return the index  where  search terminates. Note
	 * that  this is one byte after the last matching character
	 * 
	 */
	
	public int getLastIndex(){
		return lastIndex;
	}
	
}
