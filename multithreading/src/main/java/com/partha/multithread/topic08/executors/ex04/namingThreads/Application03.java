package com.partha.multithread.topic08.executors.ex04.namingThreads;

/**
 * this example shows how to name threads while creation
 * @author partha
 *
 */
public class Application03 {

	public static void main(String[] args) {
		System.out.println("starting thread: "+ Thread.currentThread().getName());
		
		//this has again got two ways of doing it.
		//first using the constuctor of the thread which takes a name apart from runnable instance
		new Thread(new MyThread(),"mythread1").start();
		
		//second way is to create the thread and then immediately after creation setting the name before starting it
		//however for this we need to have referrence of the thread created
		Thread thread2 = new Thread(new MyThread());
		thread2.setName("mythread2");
		thread2.start();
		
		
		
		System.out.println("completing thread: "+ Thread.currentThread().getName());
	}

	static class MyThread implements Runnable{
		
		
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
