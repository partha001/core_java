package com.partha.multithread.topic08.executors.ex08.terminatingThreads;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Application02 {

	public static void main(String[] args) {
	
		try {
			
			System.out.println("starting main thread");
			
			MyTask task1 = new MyTask();
			Thread t1 = new Thread(task1,"thread1");
			
			System.out.println("Threadname: "+ t1.getName() + "   interruptedStatus:"+ t1.interrupted());
			t1.start();
			
			//the below line is to allow the thread to run for sometime
			TimeUnit.MILLISECONDS.sleep(2000);
			
			System.out.println("Threadname: "+ t1.getName() + "   interruptedStatus:"+ t1.interrupted());
			t1.interrupt();
			
			
			System.out.println("ending main thread");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public static class MyTask implements Runnable{
		
		public static final int DATA_SIZE = 100000;


		@Override
		public void run() {
			
			for(int i = 0;;i++){
				doSomeWork();
				
				if(Thread.interrupted()){
					System.out.println("*** Threadname: "+ Thread.currentThread().getName() + "   is interrupted hence cancelling");
					break;
				}
			}
			System.out.println("*** Threadname: "+ Thread.currentThread().getName() + "   "+ Thread.interrupted());
			System.out.println("*** Threadname: "+ Thread.currentThread().getName() + "   is being terminated");

		}
		
		
		//the below task is to simulating some long-running non-blocked process
		private void doSomeWork(){
			for(int i=0;i<2;i++){
				Collections.sort(generateDataSet());
			}
		}
		
		private List<Integer>  generateDataSet(){
			List intList = new ArrayList<>();
			Random randomGenerator = new Random();
			for(int i=0;i<DATA_SIZE;i++){
				intList.add(randomGenerator.nextInt(DATA_SIZE));
			}
			return intList;			
		}

	}

}
