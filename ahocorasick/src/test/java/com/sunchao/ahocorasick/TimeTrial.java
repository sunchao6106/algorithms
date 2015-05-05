package com.sunchao.ahocorasick;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimeTrial {

	 public static void main(String args[]) throws IOException{
		 
		 long startTime = System.currentTimeMillis();
		 AhoCorasick tree = new AhoCorasick();
		 BufferedReader  reader = new BufferedReader(
				 new InputStreamReader(new FileInputStream("C:\\java\\java\\dict\\word")));
		 String line ;
		 while((line = reader.readLine()) != null){
			 tree.add(line.trim().getBytes(), null);
			 
		 }
		 tree.prepare();
		 long endTime  = System.currentTimeMillis();
		 System.out.println("endTime - startTime : " + (endTime - startTime) + "millseconds");
		 
	 }
}
