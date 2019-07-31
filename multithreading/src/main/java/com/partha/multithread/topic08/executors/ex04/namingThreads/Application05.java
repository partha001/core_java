package com.partha.multithread.topic08.executors.ex04.namingThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * this example shows how to provide our own naming strategy while working with executors
 * @author partha
 *
 */
public class Application05 {

	public static void main(String[] args) {
		System.out.println("starting thread: "+ Thread.currentThread().getName());
		
		ExecutorService executorService = Executors.newCachedThreadPool(new MyThreadFactory());
		executorService.submit(new MyThread());
		executorService.submit(new MyThread());
		executorService.submit(new MyThread());
		executorService.shutdown();		
		
		System.out.println("completing thread: "+ Thread.currentThread().getName());
	}

	static class MyThread implements Runnable{
		
		
		@Override
		public void run() {
			String currentThreadName = Thread.currentThread().getName();
			System.out.println("starting thead: "+currentThreadName);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("completing thead: "+currentThreadName);
		}		

	}
	
	static class MyThreadFactory implements ThreadFactory {

		int id =0;
		
		@Override
		public Thread newThread(Runnable r) {
			//1.inside this we have to create a new thread and pass the runnable input
			//2.set the name of thread 
			//3.finally return the thread
			Thread t = new Thread(r);
			t.setName("mythread_"+ id++ );
			return t;
			
		}
		
	}

}
