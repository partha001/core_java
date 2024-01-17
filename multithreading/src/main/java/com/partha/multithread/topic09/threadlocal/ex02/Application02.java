package com.partha.multithread.topic09.threadlocal.ex02;

/**
 * this program show how to declare threadLocal with initial value
 * @author biswa
 *
 */
public class Application02 {
	
	public static void main(String[] args) throws InterruptedException {
		
		/**
		 * this show how we can provide implementation to the threadLocal by overriding its methods. 
		 * the key methods are . 1.initialValue 2.get 3.set and 4.remove 
		 * for get/set/remove there is actually very less reason to override. the method which is often overriden is initialValue()
		 */
		ThreadLocal<String> threadLocal = new ThreadLocal<String>() {

			@Override
			protected String initialValue() {
				return "this is the initial value";
			}			
		};
		
		
		
		
		
		/** the above implementation can also be written as shown below using the builder pattern.
		 * thus we can also declare the above threadLocal as shown below. and it would do the same thing
		**/
		//ThreadLocal<String> threadLocal2 = ThreadLocal.withInitial(() -> { return "initial value";}); //the withInitial takes a supplier
		
		
		Thread thread1 = new Thread(() -> {
    		try {
    			System.out.println("thread1 printing:"+ threadLocal.get());
    			threadLocal.set("value1");
				Thread.sleep(3000);
				System.out.println("thread1 printing:" + threadLocal.get());
				Thread.sleep(3000);
				threadLocal.remove();
				System.out.println("thread1 printing:"+ threadLocal.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}, 
        "thread1");
    	
    	
    	
    	Thread thread2 = new Thread(() -> {
    		try {
    			System.out.println("thread2 printing:"+ threadLocal.get());
    			threadLocal.set("value2");
				Thread.sleep(3000);
				System.out.println("thread2 printing: " + threadLocal.get());
				Thread.sleep(3000);
				threadLocal.remove();
				System.out.println("thread2 printing:"+ threadLocal.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}, 
        "thread2");
    	
    	thread1.start();
    	thread2.start();
    	
    	thread1.join();
    	thread2.join();
    	
    	/** 
    	 * it is also to be noted here that if we pass an initial value then after doing threadLocal.remove() if we call
    	 * ThreadLocal.get() then it will return the inital value
    	 */
	}

}
