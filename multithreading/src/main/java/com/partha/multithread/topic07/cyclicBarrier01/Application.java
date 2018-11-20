package com.partha.multithread.topic07.cyclicBarrier01;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * here all the threads are instances of different runnables
 * which wait at their individual barrier
 * @author partha
 *
 */
public class Application {

	public static void main(String[] args) {
		
		CyclicBarrier barrier= new CyclicBarrier(3);
		
		Thread t1= new Thread(new Worker1(barrier));
		Thread t2= new Thread(new Worker2(barrier));
		Thread t3= new Thread(new Worker3(barrier));
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}

class Worker1 implements Runnable{
	
	CyclicBarrier barrier;
	
	public Worker1(CyclicBarrier barrier){
		this.barrier=barrier;
	}

	@Override
	public void run() {
		try{
			System.out.println("worker1  started "+System.currentTimeMillis());
			Thread.currentThread().sleep(2000);
			System.out.println("worker1 reached await "+System.currentTimeMillis());
			this.barrier.await();
			System.out.println("worker1 resuming after crossing barrier "+ System.currentTimeMillis());
		}catch(InterruptedException ex){
			ex.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


class Worker2 implements Runnable{

CyclicBarrier barrier;
	
	public Worker2(CyclicBarrier barrier){
		this.barrier=barrier;
	}

	@Override
	public void run() {
		try{
			System.out.println("worker2  started "+System.currentTimeMillis());
			Thread.currentThread().sleep(4000);
			System.out.println("worker2 reached await "+System.currentTimeMillis());
			this.barrier.await();
			System.out.println("worker2 resuming after crossing barrier "+ System.currentTimeMillis());
		}catch(InterruptedException ex){
			ex.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}


class Worker3 implements Runnable{
	
	CyclicBarrier barrier;

	public Worker3(CyclicBarrier barrier){
		this.barrier=barrier;
	}

	@Override
	public void run() {
		try{
			System.out.println("worker3  started "+System.currentTimeMillis());
			Thread.currentThread().sleep(6000);
			System.out.println("worker3 reached await "+System.currentTimeMillis());
			this.barrier.await();
			System.out.println("worker3 resuming after crossing barrier "+ System.currentTimeMillis());
		}catch(InterruptedException ex){
			ex.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
