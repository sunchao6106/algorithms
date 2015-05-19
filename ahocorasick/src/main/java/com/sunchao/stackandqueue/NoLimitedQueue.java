package com.sunchao.stackandqueue;

import java.util.ArrayList;
/**
 * No limited queue
 * 
 * @author sunchao
 *
 * @param <E>
 */
public class NoLimitedQueue<E> {
	
	private ArrayList<E> l1;
	private ArrayList<E> l2;
	
	public NoLimitedQueue(){
		l1 = new ArrayList<E>();
		l2 = new ArrayList<E>();
	}
	
	public boolean isEmpty(){
		return l1.isEmpty() && l2.isEmpty();
	}
	
	public void offer(E e){
		l2.add(e);
	}
	public E peek(){
		if(isEmpty()) throw new IllegalStateException();
		if(l1.isEmpty()){
			for(int i = l2.size() - 1 ; i >= 0 ; i--)
				 l1.add(l2.remove(i));
	    	assert l2.isEmpty();
		    assert !l1.isEmpty();
		}
		return l1.get(l1.size() - 1);	
		
	}
	public E pop(){
		if(isEmpty()) throw new IllegalStateException();
		if(l1.isEmpty()){
			for(int i = l2.size() - 1 ; i >= 0 ; i--)
				 l1.add(l2.remove(i));
		    assert l2.isEmpty();
		    assert !l1.isEmpty();
		}
		return l1.remove(l1.size() - 1);	
		}
}
