package com.partha.multithread.topic08.executors.ex09.exceptionHandling;

import java.lang.Thread.UncaughtExceptionHandler;

public class Application04 {

	public static void main(String[] args) {
		System.out.println("["+Thread.currentThread().getName()+  "]   started");

		MyDefaultExceptionHandler defaultHandler = new MyDefaultExceptionHandler();
		System.out.println("default handler hashcode:"+ defaultHandler.hashCode());
		
		Thread.setDefaultUncaughtExceptionHandler(defaultHandler);

		Thread t1 = new Thread(new MyExceptionLeakingTask1(),"thread1");

		Thread t2 = new Thread(new MyExceptionLeakingTask2(),"thread2");
		MyExceptionHandler myExceptionHandler = new MyExceptionHandler();
		System.out.println("thread-specific handler hashcode:"+ myExceptionHandler.hashCode());
		t2.setUncaughtExceptionHandler(myExceptionHandler);
		
		t1.start();
		t2.start();

		System.out.println("["+Thread.currentThread().getName()+  "]   after starting the two threads");

		System.out.println("["+Thread.currentThread().getName()+  "]   completed");
	}


	public static class MyExceptionLeakingTask1 implements Runnable{

		@Override
		public void run() {
			throw new RuntimeException("mesage1");
		}

	}

	public static class MyExceptionLeakingTask2 implements Runnable{

		@Override
		public void run() {
			throw new RuntimeException("message2");
		}

	}


	public static class MyDefaultExceptionHandler implements UncaughtExceptionHandler{	

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("["+getHandlerName()+  "   threadname:"+t.getName()+" ]  started");
			System.out.println("["+getHandlerName()+  "   threadname:"+t.getName()+" ]  exception details:"+e.getMessage());
			System.out.println("["+getHandlerName()+  "   threadname:"+t.getName()+" ]  completed");
		}

		private String getHandlerName(){
			return ""+this.hashCode();
		}

	}

	public static class MyExceptionHandler implements UncaughtExceptionHandler{	

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("["+getHandlerName()+  "   threadname:"+t.getName()+" ]  started");
			System.out.println("["+getHandlerName()+  "   threadname:"+t.getName()+" ]  exception details:"+e.getMessage());
			System.out.println("["+getHandlerName()+  "   threadname:"+t.getName()+" ]  completed");
		}

		private String getHandlerName(){
			return ""+this.hashCode();
		}

	}


}
