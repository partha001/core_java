package com.partha.multithread.topic06.threadpoolAndExecutor.rejectionHandler01;

import java.util.concurrent.ThreadPoolExecutor;

public class Worker implements Runnable {

	private int id;
	private String name="Worker";

	public Worker(int id)
	{
		this.id=id;
		System.out.println("Worker "+id+" Created");     
	}


	@Override
	public void run() {
		Thread curThread = Thread.currentThread();
		try{
			name=curThread.getName();
			System.out.println(name + " Executing " + id);
			Thread.sleep(1000);
			System.out.println(name + " Completed " + id);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
		
	public int getId() {
	     return id;
	 }


	 public void setId(int id) {
	     this.id = id;
	 }


	 @Override
	 public String toString() {
	     String s=name+" ID: "+id;
	     return s;
	 }


}
