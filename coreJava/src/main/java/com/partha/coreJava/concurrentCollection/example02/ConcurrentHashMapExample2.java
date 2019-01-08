package com.partha.coreJava.concurrentCollection.example02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * this program shows that while one thread (i.e. the main thread ) is iterating the map the other 
 * thread is making modification to the map safely and this is possible since we are using ConcurrentHashMap
 * @author partha
 *
 */
public class ConcurrentHashMapExample2 extends Thread{

	static ConcurrentHashMap map= new ConcurrentHashMap<Integer, String>();
	
	//if we comment the above line and uncomment the below line then we will get 
	//Exception in thread "main" java.util.ConcurrentModificationException
	//static HashMap map= new HashMap<Integer, String>();
	
	public void run(){
		try{
			Thread.sleep(2000);
		}catch(Exception ex){

		}
		System.out.println("Child thread updating map");
		map.put(103, "C");
	}

	public static void main(String[] args) throws InterruptedException {
		map.put(101, "A");
		map.put(102, "B");
		ConcurrentHashMapExample2 thread= new ConcurrentHashMapExample2();
		thread.start();

		Set s1= map.keySet();
		Iterator itr = s1.iterator();
		while(itr.hasNext()){
			Integer i1 =(Integer)itr.next();
			System.out.println("main thread is iterating map and current entry is :"+i1+"..."+map.get(i1));
			Thread.sleep(3000);
		}
		System.out.println(map);
	}

}
