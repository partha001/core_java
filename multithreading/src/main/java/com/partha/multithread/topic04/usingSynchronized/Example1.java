package com.partha.multithread.topic04.usingSynchronized;

/**
 * this example is to understand object level locking
 * here the two threads alternatively accesses the Counter object.
 * when the other thread goes to sleep the other access it.
 * @author partha
 *
 */
public class Example1 {

	public static void main(String[] args) {

		Counter1 counter=new Counter1();
		
		new Thread(new Worker1(counter)).start();
		new Thread(new Worker1(counter)).start();
		
//		Thread t1=new Thread(new Worker1(counter));
//		Thread t2=new Thread(new Worker1(counter));
		
		
		
	}

}


class Counter1{
	
	private int count=0;
	
	public void increment(){
		System.out.println("threadid:"+ Thread.currentThread().hashCode() + "   has entered the increment method");
		synchronized(this){
			System.out.println("threadid:"+ Thread.currentThread().hashCode() + "   counter"+count++);
		}
	}
	
}


class Worker1 implements Runnable{
	
	private Counter1 counter;
	
	public Worker1(Counter1 counter) {
		super();
		this.counter = counter;
	}


	@Override
	public void run() {
		try{
		for(int i=1;i<=5;i++){
			counter.increment();
			Thread.currentThread().sleep(2000);
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}