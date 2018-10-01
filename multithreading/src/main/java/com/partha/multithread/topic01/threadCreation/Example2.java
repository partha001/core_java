package com.partha.multithread.topic01.threadCreation;

/**
 * this program shows how to implement the thread using Runnable interface
 * @author partha
 *
 */
public class Example2 {
	
	public static void main(String[] args) {
		Thread t1=new Thread(new Job());
		Thread t2=new Thread(new Job());
		t1.start();
		t2.start();



	}

}


class Job implements Runnable{

	@Override
	public void run() {
		for (int i=0;i<5;i++){
			System.out.println("Hello "+i);			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
