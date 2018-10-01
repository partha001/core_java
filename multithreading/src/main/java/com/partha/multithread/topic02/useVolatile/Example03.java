package com.partha.multithread.topic02.useVolatile;

public class Example03 {

	
	public static void main(String[] args) {
		
//		//if there is one writer and one/many readers then 
//		//the results are as expected and volatile works fine
//		new Thread(new Writer(),"writer1").start();
//		new Thread(new Reader(),"reader1").start();
//		new Thread(new Reader(),"reader2").start();
		
		//however if there are many writers then volatile fails to 
		//give correct result
		new Thread(new Writer(),"writer1").start();
		new Thread(new Writer(),"writer2").start();
		new Thread(new Reader(),"reader1").start();
	}

}


class Reader implements Runnable{

	@Override
	public void run() {
		try{
			for(int i=0;i<7;i++){
				Thread.sleep(100);
				System.out.println("threadname: "+Thread.currentThread().getName()+"    counter:"+Counter.counter);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}



class Writer implements  Runnable{

	@Override
	public void run() {
		try{
			for(int i=0;i<5;i++){
			Counter.counter++;
			System.out.println("threadname: "+Thread.currentThread().getName()+"    counter:"+Counter.counter);
			Thread.sleep(100);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}



class Counter{
	
	public static volatile int counter=0;
	
}
