package com.partha.multithread.topic08.executors.ex07.checkingIfAlive;

public class Appication01 {

	public static void main(String[] args) {
		try {
			System.out.println("starting main thread");
			Thread t1 = new Thread(new MyTask());

			boolean t1IsAlive = t1.isAlive();
			System.out.println(t1IsAlive);
		
			t1.start();
			
			while(t1.isAlive()){
				Thread.currentThread().sleep(400);
				System.out.println("the spawned thread is still alive");
			}
			
			System.out.println("completing main thread");

		} catch (Exception e) {
			e.printStackTrace();
		}


	}


	public static class MyTask implements Runnable {

		@Override
		public void run() {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
