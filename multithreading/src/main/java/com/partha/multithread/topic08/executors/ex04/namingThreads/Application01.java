package com.partha.multithread.topic08.executors.ex04.namingThreads;

/**
 * this example shows default naming of threads by jvm
 * @author partha
 *
 */
public class Application01 {

	public static void main(String[] args) {
		System.out.println("starting thread: "+ Thread.currentThread().getName());
		new Thread(new MyThread()).start();
		new Thread(new MyThread()).start();
		System.out.println("completing thread: "+ Thread.currentThread().getName());
	}
	
	
	static class MyThread implements Runnable{
		
		//int id = 0;

		@Override
		public void run() {
			String currentThreadName = Thread.currentThread().getName();
			System.out.println("starting thead: "+currentThreadName);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("completing thead: "+currentThreadName);
		}
		
	}

}
