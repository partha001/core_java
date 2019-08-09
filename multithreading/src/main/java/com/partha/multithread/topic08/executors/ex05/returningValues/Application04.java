package com.partha.multithread.topic08.executors.ex05.returningValues;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Application04 {

	public static void main(String[] args) {

		ExecutorService service = Executors.newCachedThreadPool();

		CompletionService<Integer> tasks = new ExecutorCompletionService<Integer>(service);

		tasks.submit(new MyTask(10, 20));
		tasks.submit(new MyTask(20, 20));
		tasks.submit(new MyTask(30, 20));
		tasks.submit(new MyTask(40, 20));

		service.shutdown();

		try {
			for(int i=0;i<4;i++){
				Future<Integer> future = tasks.take();
				System.out.println(future.get());
			}


		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		catch (ExecutionException e) {
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
