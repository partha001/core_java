package com.partha.multithread.topic08.executors.ex08.terminationWithExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;



public class Application03 {

	public static void main(String[] args) {
		
		try {

			System.out.println("["+Thread.currentThread().getName()+"] starting main thread");

			//this is a callable task
			MyTask task1 = new MyTask(30);
			
			//this is a runnable task
			MyTask2 task2 = new MyTask2();
			
			ExecutorService executor = Executors.newCachedThreadPool();
			
			Future result1 = executor.submit(task1);
			Future result2 = executor.submit(task2);
		
			executor.shutdown();

		
			//the below line is to allow the thread to run for sometime
			TimeUnit.MILLISECONDS.sleep(700);
			result1.cancel(true);
			result2.cancel(true);
			
			
			System.out.println("["+Thread.currentThread().getName()+"] ending main thread");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public static class MyTask implements Callable<Integer>{

		private int findFactorialFor;

		public MyTask(int findFactorialFor) {
			super();
			this.findFactorialFor = findFactorialFor;
		}


		@Override
		public Integer call()  {
			int result = 1;

			for(int i=1;i<=findFactorialFor;i++){
				result = result *i;
				System.out.println("["+Thread.currentThread().getName()+"] printing intermediate result : "+ result);

				try {
					TimeUnit.MILLISECONDS.sleep(200);
				} catch (InterruptedException e) {
					System.out.println("["+Thread.currentThread().getName()+"] sleep interrupted. Cancelling ...");
					break;
				}

			}
			System.out.println("["+Thread.currentThread().getName()+"] now returning from task");
			return result ;
		}

	}
	
	
	
	public static class MyTask2 implements Runnable{

		@Override
		public void run()  {
			int result = 1;

			for(int i=1;;i++){
				
				System.out.println("["+Thread.currentThread().getName()+"] printing intermediate result : "+ result);

				try {
					TimeUnit.MILLISECONDS.sleep(200);
				} catch (InterruptedException e) {
					System.out.println("["+Thread.currentThread().getName()+"] sleep interrupted. Cancelling ...");
					break;
				}

			}
			System.out.println("["+Thread.currentThread().getName()+"] now returning from task");
		}

	}

}
