package com.sunchao.list;

import java.util.Iterator;

/**
 * 
 * @author sunchao
 *
 * @param <E>
 */
public class DoubleLinkedList<E> implements List<E> {
	
	private int size;
	private Node<E> head,tail;

	public DoubleLinkedList(){
		this.size = 0;
		head = tail = null;
	}
	/**
	 * 
	 * @return
	 */
	public E getHead(){
		if(head == null)
			return null;
		else
			return head.value;
	}
	/**
	 * 
	 */
	public E getTail(){
		if(tail == null)
			return null;
		else
			return tail.value;
	}
	/**
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void add(E ele) {
		Node node = new Node(ele);
        if(tail != null){
            tail.next = node;
            node.pre = tail;
            tail = node;
        }else
        	head = tail = node;
        size++;
	}
    /**
     * 
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void add(int index, E ele) {
		int size = size();
		
		if(size == 0){
			add(ele);
		}else{
		  if(index >= size)
			  add(ele);
		  else if(index <= 0){
			  Node  node = new Node(ele);
			  if(head == null)
				head = tail = node;
			  else{
				node.next = head;
				head.pre = node;
				head = node;
			  }
		 }else{
			   Node old = null;
			   Node node = new Node(ele);
			   int i = 0;
			   if(index < (size >> 1)){
				    old = head;
				    while(i != index){
					   old = old.next;
					   i++;
				     }
				     
			   }else{
				   i = size() - 1;
				   old = tail;
				   while(i != index){
					   old = old.pre;
					   i--;
				   }
			   }
			   old.pre.next = node;
	           node.pre = old.pre;
	           node.next = old;
	           old.pre =node;
		     }
	    }	
		size++;
	}
/**
 * 
 */
	public void addAll(E[] eles) {
		for(E e : eles)
			add(e);		
	}

	public void clear() {
		size = 0 ;
		head = tail = null;
	}

	@SuppressWarnings("rawtypes")
	public boolean contains(E ele) {
		Node node = head;
		while(node != null){
			if(node.value == ele)
				return true;
			node = node.next;
		}
		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public E get(int index) {
		  int size = size();
	      if(size == 0) return null;
	      if(index <= 0) return head.value;
	      if(index >= size) return tail.value;
	      int i = 0;
	      Node node = null;
	      if(index < (size >> 1)){
	    	  node = head;
	    	  while(i != index){
	    		  node = node.next;
	    		  i++;
	    	  }
	      }else{
	    	  node = tail;
	    	  i = size -1;
	    	  while(i != index){
	    		  node = node.pre;
	    		  i--;
	    	  }
	      }
	      return (E) node.value;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public Iterator<E> iteraor() {
		
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public E remove(int index) {
		int size = size();
		if(size == 0) return null;
		Node node = head;
		if(index <= 0){
			head = head.next;
			if(head != null)
				head.pre = null;
			else
				tail = null;
			return (E) node.value;
		}else if(index >= size){
			node = tail;
			tail = tail.pre;
			if(tail != null)
				tail.next = null;
			else
				head = null;
			return (E) node.value;
		}
		int i = 0;
		while(i != index){
			node = node.next;
			i++;
		}
		if(node.pre != null)
			node.pre.next = node.next;
		if(node.next != null)
			node.next.pre = node.pre;
		if(node == head)
			head = node.next;
		if(node == tail)
			tail = tail.pre;
	    return (E) node.value;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean remove(E ele) {
		Node node = head ;
		while(node !=  null){
			if(node.value == ele)
				break;
			node = node.next;
		}
		if(node == null) return false;
		else{
				if(node.pre != null)
					node.pre.next = node.next;
				if(node.next != null)
					node.next.pre = node.pre;
			    if(node == head)
			    	head = node.next;
			    if(node == tail)
			    	tail = tail.pre;
			    size--;
			    return true;
		}
	}

	public int size() {
		
		return size;
	}
	
	private static class Node<E>{
		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof Node)) return false;
			Node<E> node = (Node<E>) obj;
			if(node.value.equals(this.value) || node.value == this.value) return true;
			return false;
		}

		@Override
		public int hashCode() {
			int result = 0 ;
			return result += 31 * this.value.hashCode();
		}

		@Override
		public String toString() {
			return this.value.toString();
		}

		E value ;
		Node<E> next;
		Node<E> pre;
		public Node(E value){
			this.value = value;
		}
		
	}

}
