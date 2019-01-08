package com.partha.coreJava.concurrentCollection.example02;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * this program demonstrates that while the main thread is iterating the list
 * the child thread is allowed to modify the list and we wont get any 
 * concurrentModificationException
 * @author partha
 *
 */
public class CopyOnWriteArrayListExample2  extends Thread {
	
	static CopyOnWriteArrayList list = new CopyOnWriteArrayList();
	
	public void run(){
		
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("child thread is updating the list");
			list.add("C");
	}

	public static void main(String[] args) throws InterruptedException {
		list.add("A");
		list.add("B");
		
		CopyOnWriteArrayListExample2 thread = new CopyOnWriteArrayListExample2();
		thread.start();
		Iterator itr = list.iterator();
		while(itr.hasNext()){
			String s = (String)itr.next();
			System.out.println("main thread is iterating list and current object is :"+s);
			Thread.sleep(3000);
		}
		System.out.println(list);
	}

}
