package com.partha.multithreading.test1;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Practice {
	
	public static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	
	public static void main(String[] args) {
		
		
		Thread producerThread = new Thread(new Runnable(){
			@Override
			public void run() {
				produce();
			}
			
		});
		
		
		Thread consumerThread = new Thread(new Runnable(){
			@Override
			public void run() {
				consume();
			}
			
		});
		
		
		producerThread.start();
		consumerThread.start();
		
		try {
			producerThread.join();
			consumerThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static void produce(){
		Random random = new Random();
		try {
			while(true){
				System.out.println("entering value in queue");
				queue.put(random.nextInt(100));
				System.out.println("entered value in queue");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void consume(){
		try {
			Thread.currentThread().sleep(1000);
			while(true){
				System.out.println(queue.take());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}



