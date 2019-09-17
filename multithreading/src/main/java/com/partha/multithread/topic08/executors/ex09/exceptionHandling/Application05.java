package com.partha.multithread.topic08.executors.ex09.exceptionHandling;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * this example shows how to set a default exception handler to handle all
 * exceptions that arise in executor-tasks
 * @author partha
 *
 */
public class Application05 {

	public static void main(String[] args) {
		System.out.println("["+Thread.currentThread().getName()+ "]  started" );
		
		Thread.setDefaultUncaughtExceptionHandler(new MyDefaultExceptionHandler());
		
		//ExecutorService executor = Executors.newCachedThreadPool(new MyThreadFactory());
		ExecutorService executor = Executors.newCachedThreadPool();	
		executor.execute(new MyTask());
		executor.execute(new MyTask());
		executor.shutdown();
		
		
		ExecutorService executor2 = Executors.newCachedThreadPool();	
		executor2.execute(new MyTask());
		executor2.execute(new MyTask());
		executor.shutdown();
		
		System.out.println("["+Thread.currentThread().getName()+ "]  completed" );
		
	}
	
	

	
	
	public static class MyTask implements Runnable {

		@Override
		public void run() {
			System.out.println("["+Thread.currentThread().getName()+ "]  started" );
			throw new RuntimeException("exception occured");		
		}
		
	}
	
	
	public  static class MyDefaultExceptionHandler implements UncaughtExceptionHandler{

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("handler-message    threadname:"+t.getName() + " exception:"+e.getMessage());
		}
		
	}

}
