package com.partha.coreJava.concurrentCollection.example02;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * this is to demonstrate that every update operation will be performed on a separate copy
 * hence after getting the iterator if we are trying to perform any modification to the list 
 * then it be reflected to the iterator
 * @author partha
 *
 */
public class CopyOnWriteArrayListExample4 {

	public static void main(String[] args) {
		CopyOnWriteArrayList list = new CopyOnWriteArrayList();
		
		
		list.add("A");
		list.add("B");
		list.add("C");
		
		Iterator itr = list.iterator();
		list.add("D");
		
		while(itr.hasNext()){
			String s = (String) itr.next();
			System.out.println(s);
		}
		
	}

}
