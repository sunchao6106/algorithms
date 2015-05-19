package com.sunchao.stackandqueue;

import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;

/**
 * limited queue
 * 
 * @author sunchao
 *
 * @param <E>
 */

public class Queue<E> {
	private static final int CAPACITY = 10;
	private int head,tail;
	private E[] data;
	
	@SuppressWarnings("unchecked")
	public Queue(){
		head = tail = 0;
		data = (E[])new Object[CAPACITY];
	}
	
	public boolean isEmpty(){
		return head == tail;
	}
	
	public boolean offer(E e){
		if((tail + 1) % data.length == head) return false;
		data[tail] = e;
		tail = (tail + 1) % data.length;
		return true;
	}
	
	public E peek(){
		if(head == tail) throw new IllegalStateException();
		E e = data[head];
		return e;
	}
	public E pop(){
		if(head == tail) throw new IllegalStateException();
		E e = data[head];
		head = (head + 1) % data.length;
		return e;
	}
	

}
