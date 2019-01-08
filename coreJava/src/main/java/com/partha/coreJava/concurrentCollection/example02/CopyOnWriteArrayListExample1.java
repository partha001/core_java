package com.partha.coreJava.concurrentCollection.example02;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * this program is to explore the methods addIfAbsent() and addAllAbsent()
 * @author partha
 *
 */
public class CopyOnWriteArrayListExample1 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("A");
		list.add("B");
		
		CopyOnWriteArrayList list2 = new CopyOnWriteArrayList();
		list2.addIfAbsent("A");
		list2.addIfAbsent("C");
		list2.addAll(list);
		
		
		ArrayList list3 = new ArrayList();
		list3.add("A");
		list3.add("E");
		
		list2.addAllAbsent(list3);
		System.out.println(list2);
	}

}
