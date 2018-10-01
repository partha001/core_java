package com.partha.multithread.topic04.usingSynchronized;

/**
 * using synchronized with static attributes provides us with class level locks
 * @author partha
 *
 */
public class Example4StaticSynchronized {

	public static void main(String[] args) {
		new Thread(new Worker4()).start();
		new Thread(new Worker4()).start();

	}

}


class Counter4{

	private static int count=0;

	public static synchronized void increment(){
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


class Worker4 implements Runnable{

	@Override
	public void run() {
		try{
			Counter4.increment();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}


}