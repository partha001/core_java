package com.partha.multithread.topic08.executors.ex06.daemonThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Application02 {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newCachedThreadPool(new DaemonThreadFactory());
		executor.execute(new MyTask(1000));
		executor.execute(new MyTask(1500));
		executor.execute(new MyTask(2000));
		executor.execute(new MyTask(2500));
		executor.shutdown();
		
		
	}


	public static class MyTask implements Runnable{

		int sleepDuration ;

		public MyTask(int sleepDuration) {
			super();
			this.sleepDuration = sleepDuration;
		}

		@Override
		public void run() {
			try {
				boolean isDaemonThread = Thread.currentThread().isDaemon();
				String threadType = isDaemonThread ? "DaemonThread" : "UserThread";
				System.out.println("starting threadType:"+ threadType+ "  "+Thread.currentThread().getName());
				for(int i=0;i<5;i++){

					Thread.currentThread().sleep(this.sleepDuration);
				}

				System.out.println("completing threadType:"+ threadType+ "  "+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	public static class DaemonThreadFactory implements ThreadFactory{
		
		static int count = 1 ;

		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r);
			t.setName("mythread-"+ count++);
			if(count%2==0){
				t.setDaemon(true);
			}
			return t;
		}
		
	}

}
