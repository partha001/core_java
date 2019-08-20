package com.partha.multithread.topic08.executors.ex09.exceptionHandling;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * this example shows how to set different exception handler 
 * for different threads which are managed by the executor
 *
 */
public class Application06 {

	public static void main(String[] args) {
		System.out.println("["+Thread.currentThread().getName()+ "]  started" );
		
		
		//ExecutorService executor = Executors.newCachedThreadPool(new MyThreadFactory());
		ExecutorService executor = Executors.newCachedThreadPool(new MyThreadFactory());	
		executor.execute(new MyTask());
		executor.execute(new MyTask());
		executor.shutdown();
				
		System.out.println("["+Thread.currentThread().getName()+ "]  completed" );
		
	}
	
	
	public static class MyThreadFactory implements ThreadFactory {
		
		private int  taskid = 1;

		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r);
			synchronized (this) {
				t.setName("mythread"+taskid);
				if(taskid%2==0){
					t.setUncaughtExceptionHandler(new MyDefaultExceptionHandler1());
				}else{
					t.setUncaughtExceptionHandler(new MyDefaultExceptionHandler2());
				}
				taskid++;
			}
			
			return t;
		}
		
	}
	
	

	
	
	public static class MyTask implements Runnable {

		@Override
		public void run() {
			System.out.println("["+Thread.currentThread().getName()+ "]  started" );
			throw new RuntimeException("exception occured");		
		}
		
	}
	
	
	
	
	public  static class MyDefaultExceptionHandler1 implements UncaughtExceptionHandler{

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("handler-message1    threadname:"+t.getName() + " exception:"+e.getMessage());
		}
		
	}
	
	
	public  static class MyDefaultExceptionHandler2 implements UncaughtExceptionHandler{

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("handler-message2    threadname:"+t.getName() + " exception:"+e.getMessage());
		}
		
	}

}
