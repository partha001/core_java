package com.partha.coreJava.concurrentCollection.example02;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * this is a basic example program on CopyOnWriteArraySet
 * thus heterogenous objects are allowed
 * null is allowed
 * duplicates are now allowed
 * thus is just a threadsafe version of the set
 * @author partha
 *
 */
public class CopyOnWriteArraySetExample1 {

	public static void main(String[] args) {
		CopyOnWriteArraySet s = new CopyOnWriteArraySet();
		s.add("D");
		s.add("B");
		s.add("C");
		s.add("A");
		s.add(null);
		s.add(10);
		s.add("D");
		System.out.println(s);
	}

}
