package com.partha.multithreading.test1;

import java.util.stream.IntStream;

public class App {

	public static void main(String[] args) {
//		Thread t1 = new Test();
//		t1.start();
//		System.out.println("exiting main thread");
		
		Thread t1 = new Thread(new Test1());
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("exiting main thread");
		
		
//		Thread t2 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				IntStream.range(1, 10).forEach(i -> {
//					try {
//						System.out.println(i);
//						Thread.currentThread().sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				});
//			}
//		});
//		
//		t2.start();
	}
	
	
	

}


class Test extends Thread {
	
	String name;

	@Override
	public void run() {
		IntStream.range(1, 10).forEach(i -> {
			try {
				System.out.println(i);
				this.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	
}


class Test1 implements Runnable{

	@Override
	public void run() {
		IntStream.range(1, 10).forEach(i -> {	
				System.out.println(i);
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		});
	}
	
}

