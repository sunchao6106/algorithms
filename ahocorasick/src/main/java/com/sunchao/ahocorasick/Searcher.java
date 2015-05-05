package com.sunchao.ahocorasick;

import java.util.*;

   /**
    * <p>
    *    Iterator that return a list of StateMatch
    * </p>
    * @author sunchao
    *
    */

 class Searcher implements Iterator {
  
	 
	private SearchResult currentResult;
	
	private  AhoCorasick tree;
	
	Searcher(AhoCorasick tree,SearchResult current){
		this.tree = tree;
		this.currentResult = current;
		
	}
	
	public boolean hasNext() {
		return (currentResult != null);
       		
	}

	
	public Object next() {
		if(! hasNext())
			throw new NoSuchElementException();
		Object result = currentResult;
		currentResult = tree.continueSearch(currentResult);
		return result;
		
	}


	public void remove() {
		throw new UnsupportedOperationException();
	}

}
