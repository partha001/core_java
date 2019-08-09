package com.partha.multithread.topic08.executors.ex05.returningValues;

/**
 * Strategy1: returning values using normal threads
 * this is program shows how to get procesing results from threads using runnable and not callable.
 * @author partha
 *
 */
public class Application01 {

	public static void main(String[] args) {

		try {
			MyTask task1 = new MyTask(10, 20);
			Thread thread1 = new Thread(task1);
			thread1.start();
			thread1.join();
			System.out.println("sum is :"+ task1.sum);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	static class MyTask implements Runnable{
		
		 int a;
		 int b;
		 int sum;
		
		public MyTask(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public void run() {
			String currentThreadName = Thread.currentThread().getName();
			System.out.println("starting thead: "+currentThreadName);
			try {
				Thread.sleep(3000);
				sum = a + b ;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("completing thead: "+currentThreadName);
		}		

	}

}
