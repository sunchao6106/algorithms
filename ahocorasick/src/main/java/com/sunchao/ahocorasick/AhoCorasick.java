package com.sunchao.ahocorasick;

import java.util.Iterator;


 /**
  * The AhoCorasick Trie Tree as ac(DFA),which use as more 
  * 
  * pattern string match;
  * 
  * @author sunchao
  *
  */
public class AhoCorasick {
	
	private State root;
	private boolean prepared;
	
	public AhoCorasick(){
		root = new State(0);
		prepared = false;
	}
	
	public void add(byte[] keyword ,Object output){
		if(this.prepared)
			throw new IllegalStateException
			("can't add keyword after the prepared() be called!");
		State  lastState = this.root.extendAll(keyword);
		lastState.addOutputs(output);
	}
	
	public void prepare(){
		this.prepareFailTransaction();
		this.prepared = true;
		
	}
	
	public Iterator search(byte[] bytes){
		return new Searcher(this , this.startSearch(bytes));
		
	}
	
	SearchResult startSearch(byte[] bytes){
		if(!this.prepared)
			throw new IllegalStateException
		       	("can't start until prepare()");
		return continueSearch(new SearchResult(this.root,bytes ,0));
		
		
		
	}
	
	SearchResult continueSearch(SearchResult lastResult){
		byte[]  bytes =  lastResult.bytes;
		State state = lastResult.lastMatchedState;
		for(int i = lastResult.lastIndex ; i < bytes.length ; i++){
			byte b = bytes[i];
			while(state.get(b) ==  null)
				state = state.getFail();
			state = state.get(b);
			if(state.getOutputs().size() > 0)
				 return new SearchResult(state,bytes,i+1);
			
		}
		return null;
	}
	
	private void prepareFailTransaction(){
		Queue  queue = new Queue();
		for(int i =0 ; i < 256 ; i++){
			if(this.root.get((byte)i) != null){
				this.root.get((byte)i).setFail(this.root);
				queue.add(this.root.get((byte)i));
			} 
		}
		this.prepareRoot();
		while(!queue.isEmpty()){
			State state = queue.pop();
			byte[] keys = state.keys();
			for(int i = 0 ;  i < keys.length ; i++){
				State r = state;
				byte a = keys[i];
				State s = r.get(a);
				queue.add(s);
				r =  r.getFail();
				while(r.get(a) == null)
					r =  r.getFail();
				s.setFail(r.get(a));
				s.getOutputs().addAll(r.get(a).getOutputs());
				
			}
		}
		
	}
	/**
	 * Set  all the out transactions of  the root itself,if no
	 * transaction exists yet at the point
	 */
	private void prepareRoot(){
		for(int i = 0 ; i < 256 ; i++){
			if(this.root.get((byte)i) ==  null)
				this.root.put(this.root, (byte)i);
			
		}
	}
	
	State getRoot(){
		return this.root;
	}

}
