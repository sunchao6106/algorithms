package com.sunchao.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *  singleLinkedList
 *  
 * @author sunchao
 *
 * @param <E>
 */
public class SingleLinkedList<E> implements List<E>{
	private int size;
	private Node<E> head ,tail;
	
	
	public SingleLinkedList(){
		this.size = 0 ;
		head = tail = null;
	}
	
	public E getFirst(){
		if(head == null) return null;
		return head.value;
	}
	
	public E getLast(){
		if(tail == null) return null;
		return tail.value;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void add(E ele) {
         if(tail == null){
        	 head = tail = new Node(ele);
         }else{
        	 Node newNode = new Node(ele);
        	 tail.next = newNode;
        	 tail = newNode;
         }
         size++;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void add(int index, E ele) {
	   if(size == 0){
		   Node<E> newNode =  new Node(ele);
		   head = tail = newNode;
		   size++;
		   return;
	   }
	   int point = index,shift = 1;
	   if(point > size) point = size;
	   Node<E> node = head;
	   while(shift < point){
		   node = node.next;
		   shift++;
	   }
	   Node<E> newNode = new Node(ele);
	   newNode.next = node.next;
	   node.next = newNode;
	   size++;
	   if(newNode.next == null)
		   tail = newNode;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addAll(E[] eles) {
	   if(eles.length == 0) return;
	   if(size == 0){
		   Node<E> node = new Node(eles[0]);
		   head = node;
		   for(int i = 1 ; i < eles.length ;i++){
			   node.next = new Node(eles[i]);
			   node = node.next;
		   }
		   tail = node;
	   }else{
		     Node<E> node = tail ;
		     for(int i = 0 ; i < eles.length ; i++){
		    	 node.next = new Node(eles[i]);
		    	 node = node.next;
		     }
		     tail = node;
	   }
	   size += eles.length;
	}

	public void clear() {
		head = tail = null;
		size = 0;
	}

	public boolean contains(E ele) {
		Node<E> node = head;
		while(node != null){
			if(node.value ==  ele) 
				return true;
			node = node.next;
		}
		return false;
	}

	public E get(int index) {
		if(isEmpty() || index >= size) throw new IllegalStateException();
		int shift = 0;
		Node<E> node = head;
		while(shift < index){
			node = node.next;
			shift++;
		}
		return node.value;
	}

	public boolean isEmpty() {
		return size == 0 ;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Iterator iteraor() {
		// TODO Auto-generated method stub
		return new Search();
	}

	public E remove(int index) {
		    if(isEmpty() || index >= size) throw new IllegalStateException();
		    if(size == 1){
				Node<E> node = head;
				clear();
				return node.value;
			}
			Node<E> pre = null,cur = head;
			int shift = 0;
			while(shift < index){
		       pre = cur ;
		       cur = cur.next;
		       shift++;
			}
			
			if(pre == null){
				head = head.next;
			}else{
				pre.next = cur.next;
				if(pre.next == null)
					tail = pre;
			}
			size--;
			return cur.value;
	}

	public boolean remove(E ele) {
		if(isEmpty()) return false;
		Node<E> pre = null,cur = head;
		while(cur != null){
			if(cur.value == ele || cur.value.equals(ele)){
				if(pre == null)
					head = cur.next;
				else{
				     pre.next = cur.next;
				     if(pre.next == null)
				    	 tail = pre;
			   	}
				size--;
				return true;
			}
			pre = cur;
			cur = cur.next;
		}
		return false;
	}

	public int size() {
		return size;
	}
 
	@SuppressWarnings("rawtypes")
	private class Search implements Iterator{
		public Search(){
			node = SingleLinkedList.this.head;
		}
		private Node<E> node;
		
		public boolean hasNext() {
		 if(node != null) return true;
		 return false;
		}
		public Object next() {
			if(!hasNext()) throw new NoSuchElementException();
			Node<E> returnNode = node;
			node = node.next;
			return returnNode;
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	@SuppressWarnings("unchecked")
	private static class Node<E>{
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
		
		public Node(E value){
			this.value = value;
		}
		
	}
}
