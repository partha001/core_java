package com.partha.coreJava.concurrentCollection.example01;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * this is to demonstrate that if multiple threads works on same collection and try to do
 * structural change then it will ConcurrentModificationException
 * @author partha
 *
 */
public class MyThread extends Thread {
	
	static ArrayList list = new ArrayList();

	public void run(){
		try{
			Thread.sleep(5000);
		}catch(Exception ex){			
			ex.printStackTrace();
		}
		System.out.println("the child thread is updating the list");
		list.add("D");
	}
	
	public static void main(String[] args) throws InterruptedException {
		list.add("A");
		list.add("B");
		list.add("C");
		MyThread t = new MyThread();
		t.start();
		Iterator itr = list.iterator();
		while(itr.hasNext()){
			String s= (String)itr.next();
			System.out.println("main thread is iterating list and current object is : "+ s);
			Thread.sleep(3000);
		}
	}
}
