package com.partha.multithread.topic06.threadpoolAndExecutor.fixedsize02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * here am  submitting tasks of type callable to the executor service which
 * return a future
 * @author partha
 *
 */
public class Application {

	public static void main(String[] args) {
		try{
			
		ExecutorService executor=Executors.newFixedThreadPool(2);
		List<Future<Integer>> results=new ArrayList<>();

		for(int i=0;i<5;i++){
			 results.add( executor.submit(new Processor(i)));
			 //similarly it is also possible to take the results into map
			 //with some key say threadname
		}

		executor.shutdown();		
		System.out.println("all tasks submitted");
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
			
			//reading the results
			System.out.println("\n\n now printing results");
			for(Future f: results){
				System.out.println(f.get());
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("all tasks completed");
		}
		catch(Exception ex){
			ex.getStackTrace();
		}
	}
		

}



class Processor implements Callable{

	//this attribute is declared to identity each thread
	private int id;



	public Processor(int id) {
		super();
		this.id = id;
	}



	@Override
	public Integer call() throws Exception {
		System.out.println("Starting: "+ id);
		System.out.println("thread hashcode:"+Thread.currentThread().hashCode());
		try {
			//this is to simulate time taken in doing some useful task
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Completed: "+ id);
		return new Integer(id);
	}

}

