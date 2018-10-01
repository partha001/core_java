package com.partha.multithread.topic02.useVolatile;

import java.util.Scanner;

/**
 * this is to undestand the need of volatile
 * @author partha
 *
 */
public class Example01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Processor proc1=new Processor();
		proc1.start();
		
		System.out.println("Press enter to stop");
		Scanner scanner =new Scanner(System.in);
		scanner.nextLine();
		
		proc1.shutdown();
	}

}
 

class Processor extends Thread{
	
	private boolean running = true ;
	
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

