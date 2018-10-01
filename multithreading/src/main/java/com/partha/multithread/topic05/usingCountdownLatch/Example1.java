package com.partha.multithread.topic05.usingCountdownLatch;

import java.util.concurrent.CountDownLatch;

public class Example1 {
	

	public static void main(String[] args) {
		
		try{
		
		CountDownLatch latch= new CountDownLatch(3);
		new Thread(new Worker1(latch),"thread1").start();
		new Thread(new Worker1(latch),"thread2").start();
		new Thread(new Worker1(latch),"thread3").start();
		new Thread(new Worker1(latch),"thread4").start();
		new Thread(new Worker1(latch),"thread5").start();
		new Thread(new Worker1(latch),"thread6").start();
		new Thread(new Worker1(latch),"thread7").start();
		
		
		latch.await();
		System.out.println("hello world");
		
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
}


class Worker1 implements Runnable{
	
	CountDownLatch latch;
	
	

	public Worker1(CountDownLatch latch) {
		super();
		this.latch = latch;
	}


	@Override
	public void run() {
		try{
			for(int i=1;i<=3;i++){
				System.out.println("threadid:"+ Thread.currentThread().hashCode() + "   threadname:"+Thread.currentThread().getName());
				Thread.sleep(3000);
			}
			
			latch.countDown();
			System.out.println("threadid:"+ Thread.currentThread().hashCode() + "   threadname:"+Thread.currentThread().getName()+"   latchCount"+latch.getCount());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}


