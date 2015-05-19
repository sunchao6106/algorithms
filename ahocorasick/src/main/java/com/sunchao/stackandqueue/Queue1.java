package com.sunchao.stackandqueue;

import java.util.Arrays;

public class Queue1<E> {

	private static final int INIT_CAPACITY = 10;
	
	private int capacity;
	private int head,tail;
	private E[] data;
	
	@SuppressWarnings("unchecked")
	public Queue1(){
		capacity = INIT_CAPACITY;
		data = (E[]) new Object[capacity];
		head = tail = 0;
	}
	
	private void ensureCapacity(){
			data = Arrays.copyOf(data, capacity <<= 1);
	}
	
	public boolean isEmpty(){
		return head == tail;
	}
	
	public boolean offer(E e){
		if((tail + 1) % capacity == head)
			ensureCapacity();
		data[tail] = e;
		tail = (tail + 1) % capacity;
		return true;
	}
	
	public E peek(){
		if(isEmpty()) throw new IllegalStateException();
		return data[head];
	}
	public E pop(){
		if(isEmpty()) throw new IllegalStateException();
		E e = data[head];
		head = (head + 1) % capacity;
		return e;
	}
}
