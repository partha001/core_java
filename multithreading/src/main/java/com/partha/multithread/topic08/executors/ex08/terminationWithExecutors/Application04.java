package com.partha.multithread.topic08.executors.ex08.terminationWithExecutors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;



public class Application04 {

	public static void main(String[] args) {

		try {

			System.out.println("["+Thread.currentThread().getName()+"] starting main thread");
			MyCallableBlocking task1 = new MyCallableBlocking(50);
			MyCallableNonBlocking task2 = new MyCallableNonBlocking();
			MyRunnableBlocking task3 = new MyRunnableBlocking();
			MyRunnableNonBlocking task4 = new MyRunnableNonBlocking();
			
			ExecutorService executor = Executors.newCachedThreadPool();
			Future<Integer> future1 = executor.submit(task1);
			Future<Integer> future2 = executor.submit(task2);
			Future future3 = executor.submit(task3);
			Future future4 = executor.submit(task4);
			
			TimeUnit.MILLISECONDS.sleep(1000);
			executor.shutdownNow();
			
			System.out.println("["+Thread.currentThread().getName()+"] all threads terminated: "+
								executor.awaitTermination(1000, TimeUnit.MILLISECONDS));
			
			System.out.println("["+Thread.currentThread().getName()+"] future1: "+
					future1.get());
			
			System.out.println("["+Thread.currentThread().getName()+"] future2: "+
					future2.get());

			System.out.println("["+Thread.currentThread().getName()+"] ending main thread");

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static class MyCallableBlocking implements Callable<Integer>{

		private int findFactorialFor;

		public MyCallableBlocking(int findFactorialFor) {
			super();
			this.findFactorialFor = findFactorialFor;
		}


		@Override
		public Integer call() throws InterruptedException  {
			System.out.println("["+Thread.currentThread().getName()+"] started");
			int result = 1;

			for(int i=1;i<=findFactorialFor;i++){
				result = result *i;
				System.out.println("["+Thread.currentThread().getName()+"] printing intermediate result : "+ result);

				//try {
					TimeUnit.MILLISECONDS.sleep(500);
//				} catch (InterruptedException e) {
//					System.out.println("["+Thread.currentThread().getName()+"] sleep interrupted. Cancelling ...");
//					//break;
//				}

			}
			System.out.println("["+Thread.currentThread().getName()+"] completed");
			return result ;
		}

	}

	public static class MyCallableNonBlocking implements Callable<Integer>{

		@Override
		public Integer call()  {
			System.out.println("["+Thread.currentThread().getName()+"] started");
			int result = 0;
			for(int i =0 ;i< 100000;i++){
				result = longRunningTask();
				System.out.println("["+Thread.currentThread().getName()+"] intermediate_result:"+result);

				if(Thread.interrupted()){
					break;
				}

			}

			System.out.println("["+Thread.currentThread().getName()+"] completed");
			return result ;
		}

		//this method is to simulate a long-running non-blocking job
		private int longRunningTask(){
			List<Integer> list = new ArrayList<>();
			Random random = new Random();
			for(int i=0;i<1000000;i++){
				list.add(random.nextInt(1000000));
			}

			list = list.stream()
					.sorted()
					.collect(Collectors.toList());

			return list.stream().reduce((a,b) -> a+b).orElse(0);
		}


	}



	public static class MyRunnableBlocking implements Runnable{

		@Override
		public void run()  {
			System.out.println("["+Thread.currentThread().getName()+"] started");
			int result = 1;

			for(int i=1;;i++){

				System.out.println("["+Thread.currentThread().getName()+"] printing intermediate result : "+ result);

				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					System.out.println("["+Thread.currentThread().getName()+"] sleep interrupted. Cancelling ...");
					break;
				}

			}
			System.out.println("["+Thread.currentThread().getName()+"] completed");
		}

	}
	
	public static class MyRunnableNonBlocking implements Runnable{

		@Override
		public void run()  {
			System.out.println("["+Thread.currentThread().getName()+"] started");
			int result = 0;
			for(int i =0 ;i< 100000;i++){
				result = longRunningTask();
				System.out.println("["+Thread.currentThread().getName()+"] intermediate_result:"+result);

				if(Thread.interrupted()){
					break;
				}

			}

			System.out.println("["+Thread.currentThread().getName()+"] completed");
			//return result ;
		}

		//this method is to simulate a long-running non-blocking job
		private int longRunningTask(){
			List<Integer> list = new ArrayList<>();
			Random random = new Random();
			for(int i=0;i<1000000;i++){
				list.add(random.nextInt(1000000));
			}

			list = list.stream()
					.sorted()
					.collect(Collectors.toList());

			return list.stream().reduce((a,b) -> a+b).orElse(0);
		}


	}

}
