package com.partha.coreJava.concurrentCollection.example02;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Iterator of ArrayList can perform remove operation but 
 * iterator of CopyOnWriteArrayList cant perform remove 
 * operation. Otherwise we will get runtimeException 
 * saying UnsupportedOperationException.
 * @author partha
 *
 */
public class CopyOnWriteArrayListExample3 {

	public static void main(String[] args) {
		CopyOnWriteArrayList list = new CopyOnWriteArrayList();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		System.out.println(list);
		//the above list will print [A, B, C, D]
		
		Iterator itr = list.iterator();
		while(itr.hasNext()){
			String s = (String) itr.next();
			if(s.equals("D"))
				itr.remove(); //this will give Exception in thread "main" java.lang.UnsupportedOperationException
		}
		System.out.println(list);

	}

}
