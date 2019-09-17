package com.partha.multithread.topic08.executors.ex06.daemonThreads;

public class Application01 {

	public static void main(String[] args) {
		
		//interchange the sleep duration and note the difference in output
		Thread t1 = new Thread(new MyTask(2000),"thread1");
		t1.start();
		
		
		Thread t2 = new Thread(new MyTask(1000),"thread2");
		t2.setDaemon(true);
		t2.start();
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

}
