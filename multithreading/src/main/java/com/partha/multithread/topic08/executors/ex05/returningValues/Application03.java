package com.partha.multithread.topic08.executors.ex05.returningValues;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * returning values from threads executed using executor service
 * @author partha
 *
 */
public class Application03 {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		
		Future<Integer> result1 = service.submit(new MyTask(10, 20));
		Future<Integer> result2 = service.submit(new MyTask(20, 20));
		Future<Integer> result3 = service.submit(new MyTask(30, 20));
		Future<Integer> result4 = service.submit(new MyTask(40, 20));
		
		service.shutdown();
		try {
			System.out.println("result1 ="+ result1.get());
			System.out.println("result2 ="+ result2.get());
			System.out.println("result3 ="+ result3.get());
			System.out.println("result4 ="+ result4.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	
	static class MyTask implements Callable<Integer>{
		
		int a,b;
		
		public MyTask(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public Integer call() throws Exception {
			return a+b;
		}

	
	}

}
