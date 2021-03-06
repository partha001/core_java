package com.partha.multithread.topic08.executors.ex03.singleThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

	public static void main(String[] args) {
		System.out.println("starting main thread");
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(new Thread(new MyThread(), "thread1"));
		executor.submit(new Thread(new MyThread(), "thread2"));
		executor.shutdown();
		System.out.println("completing main thread");
	}

	static class MyThread implements Runnable{

		@Override
		public void run() {
			System.out.println("thread:"+ Thread.currentThread().getName()+ " started");
			for(int i=0;i<5;i++){
				try {
					Thread.currentThread().sleep(1000);
					System.out.println("thread:"+Thread.currentThread().getName()+ "  "+i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
			System.out.println("thread:"+ Thread.currentThread().getName()+ " completed");
		}
		
	}
}
