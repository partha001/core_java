package com.partha.multithread.topic01.threadCreation;

/**
 * this program shows how to declare theads as anonymous inner class
 * @author partha
 *
 */
public class Example3 {

	public static void main(String[] args) {
		Thread t1= new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i=0;i<5;i++){
					System.out.println("Hello "+i);			
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}

				}
			};

		});

		t1.start();


	}

}
