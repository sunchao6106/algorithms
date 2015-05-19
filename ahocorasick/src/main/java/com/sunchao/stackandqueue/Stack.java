package com.sunchao.stackandqueue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * array initialization must know the type of element;
 * 
 * @author sunchao
 *
 * @param <E>
 */
public class Stack<E> {
	private static final float FACTOR = 0.75F;
	private static final int INIT_CAPACITY = 10;
	
	//private Class<E> type;
	private E[] array;
	private int used;
	private int capacity;
	/*@SuppressWarnings("unchecked")
	public Stack(Class<E> type){
		this.type = type;
		array = (E[])Array.newInstance(type, INIT_CAPACITY);
	}*/
	
	@SuppressWarnings("unchecked")
	public Stack(){
		array = (E[]) new Object[INIT_CAPACITY];
		used = 0;
		capacity = INIT_CAPACITY;
	}
	
	
	
	private void ensureCapacity(){
		if(used >= capacity * FACTOR){
			array = Arrays.copyOf(array, capacity << 1);
		}
	}
	
	public boolean isEmpty(){
		return used == 0;
	}
	
	public int size(){
		return used;
	}
	
	public void push(E ele){
		ensureCapacity();
		array[used++] = ele;
	}
	
	public E peek(){
		assert used != 0;
		E top = array[used-1];
		return top;
	}
	
	public E pop(){
		assert used != 0;
		return array[--used];
		
	}
}
