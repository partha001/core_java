package com.partha.multithread.topic09.threadlocal.ex03;

/**
 * this program shows how to set values in threadLocal lazily
 * @author biswa
 *
 */
public class Application03 {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		ThreadLocal<String> threadLocal = new ThreadLocal<String>();

		Thread thread1 = new Thread(() -> {
    		try {
    			System.out.println("initalValue:"+ threadLocal.get());
    			if(threadLocal.get()==null)
    				threadLocal.set("setting the value in threadlocal lazily");
    			Thread.sleep(3000);
    			System.out.println(threadLocal.get());
    			Thread.sleep(3000);
    			threadLocal.remove();
    			Thread.sleep(3000);
    			System.out.println(threadLocal.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}, 
        "thread1");
    	
    	
    	
    	thread1.start();    	
    	thread1.join();
    	
    	/** 
    	 * it is also to be noted here that if we pass an initial value then after doing threadLocal.remove() if we call
    	 * ThreadLocal.get() then it will return the inital value
    	 */
	}

}
