package com.partha.multithread.topic03.someMethods;

/**
 * resolving the issue faced in the previous program using join
 * @author partha
 *
 */
public class Example02 {

	private int count=0;

	public static void main(String[] args) {
		Example02 app=new Example02();
		app.doWork();
	}
	
	public void doWork(){
		Thread t1=new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i=0;i<10000;i++){
					count++;
				}
			}
			
		});
		
		Thread t2=new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i=0;i<10000;i++){
					count++;
				}
			}
			
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		System.out.println("count is: "+count);
		
	}


}


//Now if both the threads increment the value of count 10000 each then the final printed value should be 20000.
//However in this case the program  output is 10817
//
//This is because  both the threads execute the statement 
//Count++
//i.e. count = count +1 ;
//
//this internally is a three step process in terms of microprocessor programming 
//get value of count
//add one to it 
//store it in count
//
//now while one thread performs c++  another thread also reads the old value of count and increments it and overwrites
//the same. Thus results in dirty read and write and finally value of count is printed as 10817
//
//however the previous problem is solved.i.e here the main thread proceeds only after the
//two other threads that it has spawned is complete


