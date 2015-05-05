package com.sunchao.ahocorasick;

import junit.framework.*;

public class TestAll extends TestCase {

	public Test testSuite(){
		
		TestSuite suite = new TestSuite();
		
		suite.addTestSuite(TestQueue.class);
		
		suite.addTestSuite(TestState.class);
		
		suite.addTestSuite(TestAhoCorasick.class);
		
		return suite;
	}
}
