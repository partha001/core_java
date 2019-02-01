package com.partha.ds.stack.example01;

public class ImplementingStackUsingArray {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		System.out.println(stack.toString());
		
		//stack.push(30); //if we enter a third item it will throw exception since the size is full
		
		//now lets validate the peek
		System.out.println("calling peek() returns :"+stack.peek());
		
		//now lets validate the pop
		System.out.println("calling pop() returns :"+ stack.pop());
		System.out.println("calling pop() returns :"+ stack.pop());
		
		//if we uncomment the below line then it will throw exception since stack is empty now
		//hence no item to peek()
		//System.out.println("calling pop() returns :"+ stack.peek());
		
		//if we uncomment the below line then it will throw exception since stack is empty now
		//hence no item to pop()
		//System.out.println("calling pop() returns :"+ stack.peek());
		

	}

}

class Stack{

	//since the size of the array
	private int maxSize=2;
	//creating the arraystack. this will initialize all the elements in the array with 0
	private int[] arr= new int[maxSize];
	
	//defining a variable to point to the top index
	private int top=-1;
	
	/** operation related methods start here **/
	public void push(int value){
		if(top<maxSize -1){
			top++;
			arr[top]=value;
		}else{
			throw new RuntimeException("cant pushed as stack is full");
		}
	}
	
	
	public int pop(){
		if(top>=0){
			return arr[top--];
		}else{
			throw new RuntimeException("cant pop as stack is empty");
		}
	}
	
	
	public int peek(){
		if(top>=0){
			return arr[top];
		}else{
			throw new RuntimeException("cant peek as stack is empty");
		}
	}


	@Override
	public String toString() {
		String result="[";
		for(int i=top;i>=0;i--){
			result +=  arr[i]+ ",";
		}
		return result + "]";
	}
	
	/** operation related methods end here **/
	

}
