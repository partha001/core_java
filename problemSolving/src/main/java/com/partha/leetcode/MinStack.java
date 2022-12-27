package com.partha.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack/
 * @author partha
 *
 */
public class MinStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private static class MinStackImpl1 {

	    Stack<Integer> stack ;
	    Stack<Integer> minStack;
	    
	    /** initialize your data structure here. */
	    public MinStackImpl1() {
	        stack = new Stack();
	        minStack = new Stack();
	    }
	    
	    public void push(int val) {
	        stack.push(val);
	        if(minStack.size()==0 || minStack.peek()>=val){ // >= is required since in case of repitation the element must be allowed
	            minStack.push(val);
	        }
	    }
	    
	    public void pop() {
	       if(stack.peek().equals(minStack.peek()))
	           minStack.pop();
	        stack.pop();
	    }
	    
	    public int top() {
	        return stack.peek();
	    }
	    
	    public int getMin() {
	        return minStack.peek();
	    }
	}

	/**
	 * Your MinStack object will be instantiated and called as such:
	 * MinStack obj = new MinStack();
	 * obj.push(val);
	 * obj.pop();
	 * int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */

}
