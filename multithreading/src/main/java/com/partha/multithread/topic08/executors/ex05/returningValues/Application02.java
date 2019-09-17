package com.partha.multithread.topic08.executors.ex05.returningValues;

/**
 * Strategy2: returning values using normal threads
 * @author partha
 *
 */
public class Application02 {

	public static void main(String[] args) {
		
		System.out.println("starting "+Thread.currentThread().getName());
		Thread t = new Thread(new MyTask(10, 20, new SumObserver()));
		t.start();
		System.out.println("completing "+Thread.currentThread().getName());
	}
	
	
	static interface ResultListener<T> {
		
		public void notifyResult(T result);
	}
	
	static class SumObserver implements ResultListener<Integer>{

		@Override
		public void notifyResult(Integer result) {
			System.out.println("the result is = "+ result.intValue());
		}
		
	}
	
	
	static class MyTask implements Runnable{
		
		int a,b,result;
		ResultListener<Integer> listener;
		
		public MyTask(int a, int b,ResultListener<Integer> listener ) {
			super();
			this.a = a;
			this.b = b;
			this.listener = listener;
		}


		@Override
		public void run() {
			try {
				System.out.println("starting "+Thread.currentThread().getName());
				Thread.currentThread().sleep(2000);
				this.result = a +b;
				this.listener.notifyResult(result);
				System.out.println("completing "+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

}
