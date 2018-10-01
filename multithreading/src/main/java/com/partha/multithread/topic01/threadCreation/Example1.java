package com.partha.multithread.topic01.threadCreation;

/**
 * shows how to create threads by extending Thread
 * @author partha
 *
 */
public class Example1 {

	public static void main(String[] args) {
		//thus there are two threads running simultaneously
				Runner runner1=new Runner();
				runner1.start();

				Runner runner2=new Runner();
				runner2.start();


	}

}


class Runner extends Thread{

	public void run(){
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

