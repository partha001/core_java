package com.partha.multithread.topic08.executors.ex08.terminationWithExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;



public class Application01 {

	public static void main(String[] args) {
		
		try {

			System.out.println(Thread.currentThread().getName()+" starting main thread");

			MyTask task1 = new MyTask(30);
			
			ExecutorService executor = Executors.newCachedThreadPool();
			executor.submit(task1);
			executor.shutdown();

		
			//the below line is to allow the thread to run for sometime
			TimeUnit.MILLISECONDS.sleep(700);
			
			//now shutting down
			task1.cancel();

			
			System.out.println(Thread.currentThread().getName()+" ending main thread");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public static class MyTask implements Callable<Integer>{

		private  volatile  boolean shutdown = false;
		private int findFactorialFor;

		public MyTask(int findFactorialFor) {
			super();
			this.findFactorialFor = findFactorialFor;
		}


		@Override
		public Integer call() throws Exception {
			int result = 1;

			for(int i=1;i<=findFactorialFor;i++){
				result = result *i;
				System.out.println(Thread.currentThread().getName()+" printing intermediate result : "+ result);

				TimeUnit.MILLISECONDS.sleep(200);


				synchronized (this) {
					if(this.shutdown){
						break;
					}
				}
			}
			System.out.println(Thread.currentThread().getName()+" now returning from task since");
			return result ;
		}


		public void cancel(){
			synchronized (this) {
				this.shutdown = true ;
			}
		}

	}

}
