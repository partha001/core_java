package com.partha.multithread.topic03.usingJoin;

/**
 * this program shows the problem without join
 * here the output is way less than 20000 because before the 
 * two threads can complete the main thread exits
 * while the two other threads run the background
 * 
 * in other words understanding the need of join
 * @author partha
 *
 */
public class Example01 {

	private int count=0;

	public static void main(String[] args) {
		Example01 app=new Example01();
		app.doWork();
	}
	
	public void doWork(){
		Thread t1=new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i=0;i<10000;i++){
					count++;
				}
			}
			
		});
		
		Thread t2=new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i=0;i<10000;i++){
					count++;
				}
			}
			
		});
		
		t1.start();
		t2.start();
		
		
		System.out.println("count is: "+count);
		
	}


}
