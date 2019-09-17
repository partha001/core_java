package com.partha.multithread.topic08.executors.ex09.exceptionHandling;

import java.lang.Thread.UncaughtExceptionHandler;

public class Application02 {

	public static void main(String[] args) {
		System.out.println("["+Thread.currentThread().getName()+  "]   started");
		
		Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler("handler1"));
		
		try{
			new Thread(new MyTask()).start();
			new Thread(new MyTask()).start();
			System.out.println("["+Thread.currentThread().getName()+  "]   after starting the two threads");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("["+Thread.currentThread().getName()+  "]   completed");
	}
	
	
	public static class MyTask implements Runnable{

		@Override
		public void run() {
			throw new RuntimeException();
		}
		
	}
	
	
	public static class MyExceptionHandler implements UncaughtExceptionHandler{	
		
		private String handlerId;
		
		
		public MyExceptionHandler(String handlerId) {
			super();
			this.handlerId = handlerId;
		}

		public MyExceptionHandler() {
			super();
		}


		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("["+Thread.currentThread().getName()+  "]   started");
			System.out.println("["+Thread.currentThread().getName()+  "]   caught exception in thread "+ t.getName() +"  => "+e.getMessage());
			System.out.println("["+Thread.currentThread().getName()+  "]   completed");
		}
		
	}

}
