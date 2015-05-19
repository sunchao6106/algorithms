package com.sunchao.singlelinkedlist;
import java.util.Iterator;

import com.sunchao.list.SingleLinkedList;

import junit.framework.*;

public class TestSingleLinkedList extends TestCase {

	private SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
    public void testSingleLinkedList(){
    	list.add(2);
    	list.add(4);
    	list.add(5);
    	assertEquals(3, list.size());
    	assertEquals(true, list.contains(4));
    	assertFalse(list.contains(6));
    	assertEquals(2, (int)list.getFirst());
    	assertEquals(5, (int)list.getLast());
    	Integer[] array ={6,7,8};
    	list.addAll(array);
    	assertEquals(6, list.size());
    	assertTrue(list.contains(6));
    	assertEquals(8, (int)list.getLast());
    	list.remove(0);
    	assertFalse(list.contains(2));
    	assertEquals(4, (int)list.getFirst());
    	list.remove(new Integer(5));
    	assertFalse(list.contains(5));
    	
    	assertEquals(4, list.size());
    	assertEquals(4,(int)list.getFirst());
    	Iterator it = list.iteraor();
    	while(it.hasNext()){
    		System.out.println(it.next().toString());
    	}
    }
}
