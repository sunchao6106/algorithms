package com.sunchao.ahocorasick;


   interface EdgeList {
	   
	  State get(byte ch);
	  
	  void put(State state,byte ch);
	  
	  byte[] keys();

}
