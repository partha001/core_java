package com.partha.multithread.topic04.usingSynchronized;

/**[in case of last example]
 * in last example there was a synchronized block inside the increment().
 * thus two threads can enter the method howeve only one can enter the synchronized block at one time
 * [in case of previous example]
 * 
 * [in case of this example]
 * its the entire increment() which is synchronized. thus when the first thread puts lock on the entire couter
 * object and thread to can use the counter object only after thread one is complete using the object
 * @author partha
 *
 */

public class Example3MethodSynchronization {

	public static void main(String[] args) {

		Counter3 counter=new Counter3();

		new Thread(new Worker3(counter)).start();
		new Thread(new Worker3(counter)).start();
		
	}

}


class Counter3{

	private int count=0;

	public synchronized void increment(){
		try{
			System.out.println("threadid:"+ Thread.currentThread().hashCode() + "   has entered the increment method");
			//synchronized(this){
				for(int i=1;i<=5;i++){
					System.out.println("threadid:"+ Thread.currentThread().hashCode() + "   counter"+count++);
					Thread.currentThread().sleep(2000);
				}			
			//}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}


class Worker3 implements Runnable{

	private Counter3 counter;

	public Worker3(Counter3 counter) {
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
