package com.partha.multithread.topic06.threadpoolAndExecutor.rejectionHandler01;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedExecutionHandlerExample {
	
	 public static ThreadPoolExecutor executor=(ThreadPoolExecutor) Executors.newFixedThreadPool(5);

	 public static ThreadPoolExecutor alternateExecutor=(ThreadPoolExecutor) Executors.newFixedThreadPool(5);

	 public static void main(String[] args) {
	     RejectedExecutionHandler handler=new MyRejectedExecutionHandler();
	     executor.setRejectedExecutionHandler(handler);
	     System.out.println("Starting ThreadPoolExecutor");
	     Worker[] workers=new Worker[10];
	     for(int i=0;i<10;i++){
	         workers[i]=new Worker(i);
	         executor.execute(workers[i]);
	         if(i==6)
	             executor.shutdown();// The executor is terminated intentionally to check the RejectedExecutionHandler
	     }
	     executor.shutdown();
	     while(!executor.isTerminated()){
	         //Waiting for the termination of executor
	     }

	     System.out.println("Execution Completed");
	     alternateExecutor.shutdown();
	     while(!alternateExecutor.isTerminated()){
	         //Waiting for the termination of alternateExecutor
	     }
	     System.out.println("Alternate Execution Completed");
	 }
}
