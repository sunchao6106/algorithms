package com.sunchao.LRU;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A LRUCache based on <code>LinkedHashMap</code>
 * <p>
 * if the size of lrucache is full,and one entry added into,
 * the LRU element will be evicted;
 * </p>
 * @author sunchao
 *
 */
public class LRUCache<K,V> {
 /**
  * <p>
  *   the cache method is thread-safe,all methods is synchronized;
  * </p>
  */
	private static final float  LOAD_FACTOR = 0.75F;
	private LinkedHashMap<K,V> map ;
	private int cacheSize;
	private static final int DEFAULT_CACHE_CAPACITY = 32;
	
	public LRUCache(){
		this(DEFAULT_CACHE_CAPACITY);
	}
	
	/**
	 * 
	 * @param cacheSize
	 */
	public LRUCache(int cacheSize){
		this.cacheSize = cacheSize;
		int mapCapacity = (int)Math.ceil(cacheSize / LOAD_FACTOR) + 1;
		this.map =  new LinkedHashMap<K,V>(mapCapacity, LOAD_FACTOR, true){
			
			private static final long serialVersionUID = 1L;
			@Override
			protected boolean removeEldestEntry(Map.Entry<K, V> eldest){
				return size() > LRUCache.this.cacheSize;
			}
		};
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public synchronized V get(K key){
		
		return map.get(key);
	}
	/**
	 * 
	 * @param key
	 * @param value
	 */
	public synchronized void put(K key, V value){
		map.put(key, value);
	}
	/**
	 * 
	 */
	public synchronized void clear(){
		map.clear();
	}
	
	public synchronized int usedEntry(){
		return map.size();
	}
	
	public synchronized Collection<Map.Entry<K,V>> getAll(){
		return new ArrayList<Map.Entry<K,V>>(map.entrySet());
	}
}
