package com.partha.multithread.topic08.executors.ex09.exceptionHandling;

import java.lang.Thread.UncaughtExceptionHandler;

public class Application03 {

	public static void main(String[] args) {
		System.out.println("["+Thread.currentThread().getName()+  "]   started");


		Thread t1 = new Thread(new MyExceptionLeakingTask1(),"thread1");
		t1.setUncaughtExceptionHandler(new MyExceptionHandler1());

		Thread t2 = new Thread(new MyExceptionLeakingTask2(),"thread2");
		t2.setUncaughtExceptionHandler(new MyExceptionHandler2());
		
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


	public static class MyExceptionHandler1 implements UncaughtExceptionHandler{	

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

	public static class MyExceptionHandler2 implements UncaughtExceptionHandler{	

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
