package com.partha.multithread.topic06.threadpoolAndExecutor.singleThreadPool01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Application {

	public static void main(String[] args) {
		ExecutorService executor=Executors.newSingleThreadExecutor();

		for(int i=0;i<3;i++){
			executor.submit(new Processor(i));
		}

		executor.shutdown();
		System.out.println("all tasks submitted");
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("all tasks completed");

	}
}



class Processor implements Runnable{

	//this attribute is declared to identity each thread
	private int id;

	public Processor(int id) {
		super();
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Starting: "+ id);
		System.out.println("thread hashcode:"+Thread.currentThread().hashCode());
		try {
			//this is to simulate time taken in doing some useful task
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Completed: "+ id);
	}
}
