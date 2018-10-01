package com.partha.multithread.topic02.useVolatile;

import java.util.Scanner;

/**
 * improving the above program using volatile
 * @author partha
 *
 */
public class Example02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Processor1 proc1=new Processor1();
		proc1.start();
		
		System.out.println("Press enter to stop");
		Scanner scanner =new Scanner(System.in);
		scanner.nextLine();
		
		proc1.shutdown();
	}


}


class Processor1 extends Thread{
	
	private volatile boolean running = true ;
	
	public void run(){

		while(running){
			System.out.println("hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown(){
		running = false;
	}
}

