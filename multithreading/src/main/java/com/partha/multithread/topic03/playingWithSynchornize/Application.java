package com.partha.multithread.topic03.playingWithSynchornize;



/**
 * this is to see whether locks are acquired at method level or at object level
 * @author partha
 *
 */
public class Application {

	public static void main(String[] args) {
		Counter counter = new Counter();


		Thread t1=new Thread(new Processor1(counter));
		Thread t2=new Thread(new Processor2(counter));

		t1.start();
		t2.start();

		try{
			t1.join();
			t2.join();
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

}

class Processor1 implements Runnable{

	private Counter counter ;

	public Processor1(Counter counter){
		super();
		this.counter=counter;
	}

	@Override
	public void run() {
		counter.method1();
	}

}


class Processor2 implements Runnable{

	private Counter counter ;

	public Processor2(Counter counter){
		super();
		this.counter=counter;
	}

	@Override
	public void run() {
		counter.method2();
	}

}




class Counter{

	private String test="hello";

	//public synchronized void method2(){
	public void method2(){
		try {
			//synchronized(this){
				for(int i=0;i<10;i++){
					System.out.println("executing-method2 threadname:"+Thread.currentThread().hashCode()+ "       time"+System.currentTimeMillis());
					Thread.currentThread().sleep(1000);
					System.out.println(test+=",");
				}
			//}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	//public synchronized void method1(){
	public void method1(){
		try {
			synchronized(this){
				for(int i=0;i<10;i++){
					System.out.println("executing-method1 threadname:"+Thread.currentThread().hashCode()+ "       time"+System.currentTimeMillis());
					Thread.currentThread().sleep(1000);
					System.out.println(test+="," );
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
