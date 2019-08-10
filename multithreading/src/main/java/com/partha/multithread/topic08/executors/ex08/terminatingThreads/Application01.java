package com.partha.multithread.topic08.executors.ex08.terminatingThreads;

public class Application01 {

	public static void main(String[] args) {
	
		try {
			
			System.out.println("starting main thread");
			
			MyTask task1 = new MyTask();
			MyTask task2 = new MyTask();
			
			Thread t1 = new Thread(task1,"task1");
			Thread t2 = new Thread(task2,"task2");
			
			t1.start();
			t2.start();
			Thread.currentThread().sleep(1000);
			
			task1.cancel();
			task2.cancel();
			
			System.out.println("ending main thread");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public static class MyTask implements Runnable{

		public volatile boolean flag = true;

		@Override
		public void run() {
			
			try {
				while(true){
					Thread.currentThread().sleep(200);
					System.out.println("name: "+ Thread.currentThread().getName() + "   status: running");
					if(!this.flag){
						break;
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
		public void cancel(){
			synchronized (this) {
				this.flag = false;
			}
		}

	}

}
