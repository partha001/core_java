package com.partha.multithread.topic04.usingSynchronized;
/*
 * here i have shifted for loop-with-sleep from inside thread class to the counter class.
 * here both the threads enter the method. but as one thread enter the synchronized block [object]
 * level lock is  acquired the other goes into waiting state.
 * 
 */
public class Example2ObjectLocking {

	public static void main(String[] args) {

		Counter2 counter=new Counter2();

		new Thread(new Worker2(counter)).start();
		new Thread(new Worker2(counter)).start();

	}

}


class Counter2{

	private int count=0;

	public void increment(){
		try{
			System.out.println("threadid:"+ Thread.currentThread().hashCode() + "   has entered the increment method");
			synchronized(this){
				for(int i=1;i<=5;i++){
					System.out.println("threadid:"+ Thread.currentThread().hashCode() + "   counter"+count++);
					Thread.currentThread().sleep(2000);
				}			
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}


class Worker2 implements Runnable{

	private Counter2 counter;

	public Worker2(Counter2 counter) {
		super();
		this.counter = counter;
	}


	@Override
	public void run() {
		try{
			counter.increment();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}


}
