package com.partha.multithread.topic08.executors.ex09.exceptionHandling;

public class Application01 {

	public static void main(String[] args) {
		System.out.println("["+Thread.currentThread().getName()+  "]   started");
		try{
			new Thread(new MyTask()).start();
			new Thread(new MyTask()).start();
			System.out.println("["+Thread.currentThread().getName()+  "]   after starting the two threads");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("["+Thread.currentThread().getName()+  "]   completed");
	}
	
	
	public static class MyTask implements Runnable{

		@Override
		public void run() {
			throw new RuntimeException();
		}
		
	}

}
