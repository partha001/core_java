package com.partha.multithread.topic08.executors.ex04.namingThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * this example shows default thread naming strategy for threads in a pool
 * @author partha
 *
 */
public class Application04 {

	public static void main(String[] args) {
		System.out.println("starting thread: "+ Thread.currentThread().getName());
		
		ExecutorService executorService = Executors.newCachedThreadPool();
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

}
