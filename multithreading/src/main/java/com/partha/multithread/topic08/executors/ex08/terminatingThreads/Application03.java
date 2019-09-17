package com.partha.multithread.topic08.executors.ex08.terminatingThreads;


import java.util.concurrent.TimeUnit;

public class Application03 {

	public static void main(String[] args) {

		try {

			System.out.println("starting main thread");

			MyTask task1 = new MyTask();
			Thread t1 = new Thread(task1,"thread1");

			System.out.println("Threadname: "+ t1.getName() + "   interruptedStatus:"+ t1.interrupted());
			t1.start();

			//the below line is to allow the thread to run for sometime
			TimeUnit.MILLISECONDS.sleep(500);

			System.out.println("Threadname: "+ t1.getName() + "   interruptedStatus:"+ t1.interrupted());
			t1.interrupt();


			System.out.println("ending main thread");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static class MyTask implements Runnable{


		@Override
		public void run() {

			System.out.println("Threadname: "+ Thread.currentThread().getName() + "   start");
			try {
				for(int i = 0;;i++){
					TimeUnit.MILLISECONDS.sleep(1000);
				}
			} catch (InterruptedException e) {
				System.out.println("interrupt exception thrown");
				e.printStackTrace();
			}
			System.out.println("Threadname: "+ Thread.currentThread().getName() + "   end");

		}	

	}

}
