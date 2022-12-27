package com.partha.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * https://www.geeksforgeeks.org/queue-using-stacks/
 * @author partha
 *
 */
public class ImplementQueueUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	//this design is enqueue expensive
	private static class MyQueue1 {
		
		Stack<Integer> stack1 ;
		Stack<Integer> stack2 ;

	    public MyQueue1() {
	        stack1 = new Stack<Integer>();
	        stack2 = new Stack<Integer>();
	    }
	    
	    public void push(int x) {
	        while(!stack1.isEmpty())
	        	stack2.push(stack1.pop());
	        
	        stack1.push(x);
	        
	        while(!stack2.isEmpty())
	        	stack1.push(stack2.pop());
	    }
	    
	    public int pop() {
	        return stack1.pop();
	    }
	    
	    public int peek() {
	        return stack1.peek();
	    }
	    
	    public boolean empty() {
	       return stack1.isEmpty();
	    }
	}
	
	
	//this is dequeue expensive
	class MyQueue2 {

	        Stack<Integer> stack1 ;
			Stack<Integer> stack2 ;

		    public MyQueue2() {
		        stack1 = new Stack<Integer>();
		        stack2 = new Stack<Integer>();
		    }
		    
		    public void push(int x) {
		    	stack1.push(x);
		    }
		    
		    public int pop() {
		        while(!stack1.isEmpty())
		        	stack2.push(stack1.pop());
		        
		        int x = stack2.pop();
		        
		        while(!stack2.isEmpty())
		        	stack1.push(stack2.pop());
		        return x;
		    }
		    
		    public int peek() {
		    	while(!stack1.isEmpty())
		        	stack2.push(stack1.pop());
		        
		        int x = stack2.peek();
		        
		        while(!stack2.isEmpty())
		        	stack1.push(stack2.pop());
		        return x;
		    }
		    
		    public boolean empty() {
		       return stack1.isEmpty();
		    }
	}

	
	//another way can be by using linkedList and holding a referrence of head and tail.
	private static class MyQueue {
	    
	    Node head;
	    Node last;
	    public MyQueue() {

	    }
	    
	    public void push(int x) {
	        Node newnode = new Node(x);
	        if(head ==  null){
	            head = newnode;
	            last = newnode;
	        }else{
	            last.next = newnode;
	            last = last.next;
	        }
	    }
	    
	    public int pop() {
	        if(head != null){
	            int val = head.val;
	            head = head.next;
	            return val;
	        }else{
	            return -1;
	        }
	    }
	    
	    public int peek() {
	        return head.val;
	    }
	    
	    public boolean empty() {
	        if(head ==  null){
	            return true;
	        }else{
	            return false;
	        }
	    }
	}

	private static class Node{
	    public int val;
	    public Node next;
	    
	    public Node(int val){
	        this.val = val;
	        this.next = null;
	    }
	}


}
