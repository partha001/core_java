package com.partha.ds01.queue.example01;

public class ImplementingQueueUsingArray {

	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.enqueue(10);
		queue.enqueue(20);
		//queue.enqueue(30); //uncommenting will throw an exception
		System.out.println(queue.toString());
		
		//testing the dequeue()
		System.out.println("calling dequeue :"+ queue.dequeue());
		System.out.println("calling dequeue :"+ queue.dequeue());
		
		//calling dequeue again will throw exception since there is no item to be dequeued
		System.out.println("calling dequeue :"+ queue.dequeue());
		

		int number=13;
		int result =1;
		for(int i=1;i<=number;i++){
			result*=i;
		}
	}
	
	
	public int factorial(int number){
		if(number==0){
			return 1;
		}else{
			return number*factorial(number-1);
		}
	}

}


class Queue{

	//private int head = -1;
	private int tail = -1;
	private int maxSize = 2;

	int[] arr = new int[maxSize];

	// utility methods start here
	public void enqueue(int value){
		if(tail<maxSize-1){
			arr[++tail]=value;
		}else{
			throw new RuntimeException("element cant be enqueued as queue is full");
		}
	}

	public int dequeue(){
		if(tail>=0){
			int result = arr[0];
			for(int i=1;i<=tail;i++){
				arr[i-1]= arr[i];
			}
			tail--;
			return result;		
		}else{
			throw new RuntimeException("no element to dequeue as the queue is empty");
		}
	}
	
	
	@Override
	public String toString(){
		String result="[";
		for(int i=0;i<=tail;i++){
			result += arr[i] +" ";
		}
		return result +"]";
	}

	// utility methods end here
}
