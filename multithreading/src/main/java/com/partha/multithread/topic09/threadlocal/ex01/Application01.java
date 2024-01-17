package com.partha.multithread.topic09.threadlocal.ex01;

/**
 * this program show how thread local stores the values set by each thread in isolated fashion
 * thus value set by one thread into threadLocal can not be accessed by another thread
 * @author biswa
 *
 */
public class Application01 {

    public static void main(String[] args) throws InterruptedException {
    	
    	ThreadLocal<String> threadLocal = new ThreadLocal<String>();
    	
    	/**
    	 * within each thread we
    	 * 1.get the value and print 
    	 * 2.set the value and print
    	 * 3.remove the value and print
    	 */
    	
    	Thread thread1 = new Thread(() -> {
    		try {
    			System.out.println("thread1 printing:"+ threadLocal.get());
    			threadLocal.set("value1");
				Thread.sleep(3000);
				System.out.println("thread1 printing:" + threadLocal.get());
				threadLocal.remove();
				System.out.println("thread1 printing:" + threadLocal.get());
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
				System.out.println("thread2 printing:" + threadLocal.get());
				threadLocal.remove();
				System.out.println("thread2 printing:" + threadLocal.get());
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
    }
	

}




	



