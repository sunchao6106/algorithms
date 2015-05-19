package com.sunchao.list;

import java.util.Iterator;

public interface List<E> {

	 void add(E ele);
	 void add(int index ,E ele);
	 void addAll(E[] eles);
	 void clear();
	 boolean contains(E ele);
	 E get(int index);
	 boolean isEmpty();
	 Iterator<E> iteraor();
	 E remove(int index);
	 boolean remove(E ele);
	 int size();
	 
}
