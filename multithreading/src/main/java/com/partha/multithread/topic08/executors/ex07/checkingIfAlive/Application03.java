package com.partha.multithread.topic08.executors.ex07.checkingIfAlive;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Application03 {

	public static void main(String[] args) {
		try {
			System.out.println("starting main thread");
			
			ExecutorService executor = Executors.newFixedThreadPool(2);
			
			//since a runnable doesnt return any value so we dont mention the future type
			FutureTask future1 = new FutureTask<Void>(new MyTask1(),null);
			
			FutureTask<Integer> future2 = new FutureTask<Integer>(new MyTask2(10,20));
			
			//since the callable returns value 
			executor.submit(future1);
			executor.submit(future2);
			executor.shutdown();
			
			for(int i=0;i<2;i++){
				Thread.currentThread().sleep(500);
				System.out.println(""+future1.isDone());
				System.out.println(""+future2.isDone());
			}
			
			System.out.println(future2.get());
			System.out.println("completing main thread");
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
	
	public static class MyTask1 implements Runnable {

		@Override
		public void run() {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	
	public static class MyTask2 implements Callable<Integer> {

		private int a,b;		

		public MyTask2(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public Integer call() throws Exception {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return a+b;
		}

	}

}
