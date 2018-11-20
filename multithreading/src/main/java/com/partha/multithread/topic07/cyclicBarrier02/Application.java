package com.partha.multithread.topic07.cyclicBarrier02;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *here all the threads are instances of the same runnable .
 *they all take the sleep duration as constructor argument.
 *they wait at the common point
 * @author partha
 *
 */
public class Application {

	public static void main(String[] args) {

		CyclicBarrier barrier= new CyclicBarrier(3);

		Thread t1= new Thread(new Worker(barrier,2000), "thread1");
		Thread t2= new Thread(new Worker(barrier,4000), "thread2");
		Thread t3= new Thread(new Worker(barrier,6000), "thread3");


		t1.start();
		t2.start();
		t3.start();

	}

}


class Worker implements Runnable{

	CyclicBarrier barrier;
	int sleepduration;

	public Worker(CyclicBarrier barrier,int sleepduartion){
		this.barrier=barrier;
		this.sleepduration=sleepduartion;
	}

	@Override
	public void run() {
		try{
			System.out.println(Thread.currentThread().getName() +" started "+System.currentTimeMillis());
			Thread.currentThread().sleep(this.sleepduration);
			System.out.println(Thread.currentThread().getName() +" reached await "+System.currentTimeMillis());
			this.barrier.await();
			System.out.println(Thread.currentThread().getName() +" resuming after crossing barrier "+ System.currentTimeMillis());
		}catch(InterruptedException ex){
			ex.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}