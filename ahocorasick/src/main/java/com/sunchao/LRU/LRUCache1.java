package com.sunchao.LRU;


import java.util.concurrent.ConcurrentHashMap;

/**
 * This LRUCache combine with the hashTable and two single list;
 * 
 * @author sunchao
 *
 */
public class LRUCache1<K,V> {

	private static final int DEFAULT_CACHE_CAPACITY = 32;
	private int cacheSize;
	private ConcurrentHashMap<K,Entry<K,V>> map;
	@SuppressWarnings("rawtypes")
	private Entry head,tail;
	
	
	public LRUCache1(){
		this(DEFAULT_CACHE_CAPACITY);
	}
	
	public LRUCache1(int cacheSize){
		this.cacheSize = cacheSize;
		head = tail =null;
		this.map = new ConcurrentHashMap<K,Entry<K,V>>();
	}
	/**
	 * 
	 * @param key
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public V get(K key){
		Entry entry = getEntry(key);
		if(entry == null) return null;
		moveToHead(entry);
		return  (V) entry.value;
	}
	
	@SuppressWarnings("rawtypes")
	public String toString(){
		StringBuilder sb = new StringBuilder();
		Entry entry = head;
		while(entry != null){
			sb.append(String.format("%s : %s", entry.key,entry.value));
			entry = entry.next;
		}
		return sb.toString();
	}
	
	public void clear(){
		head = tail = null;
		map.clear();
	}
	/**
	 * 
	 * @param key
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Entry getEntry(K key){
		return map.get(key);
	}
	/**
	 * 
	 * @param entry
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void moveToHead(Entry entry){
		if(entry == head) return;
		if(entry.pre != null) entry.pre.next = entry.next;
		if(entry.next != null) entry.next.pre = entry.pre;
		if(entry == tail) tail = entry.pre;
		if(head == null || tail == null){
			head = tail = entry;
		}
		entry.next = head;
		head.pre = entry;
		head = entry;
		entry.pre = null;
			
	}
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	private void removeTail(){
		if(tail != null){
			tail = tail.pre;
			if(tail == null)
				 head = null;
			else
				tail.next = null; 
		}
	}
	/**
	 * 
	 * @param key
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void remove(K key){
		Entry entry = getEntry(key);
		if(entry != null){
			if(entry.pre != null)
				entry.pre.next = entry.next;
			if(entry.next != null)
				entry.next.pre = entry.pre;
			if(entry == head) 
				head = entry.next;
			if(entry == tail)
				tail = entry.pre;
		}
		map.remove(key);
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void put(K key, V value){
		Entry entry = getEntry(key);
		if(entry == null){
			if(map.size() >= cacheSize){
				map.remove(tail.key);
				removeTail();
			}
			entry = new Entry();
			entry.key = key;
		}
		entry.value = value;
		moveToHead(entry);
		map.put(key, entry);
	}
	
	@SuppressWarnings("rawtypes")
    static class Entry<K,V>{
		Entry pre;
		Entry next;
		K key;
		V value;
	}
}
