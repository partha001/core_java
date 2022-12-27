package com.partha.leetcode;

import java.util.Stack;

/*
 * @source : https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1
 */
public class NextLargerElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	static class Solution
	{
	    //Function to find the next greater element for each element of the array.
	    public static long[] nextLargerElement(long[] arr, int n)
	    { 
	      Stack<Long> stack = new Stack<Long>();
	      for(int i=n-1;i>=0;i--){
	           
	           while( !stack.isEmpty() && stack.peek()<=arr[i]){
	               stack.pop();
	           }
	           
	           if(stack.isEmpty()){
	               stack.push(arr[i]);
	               arr[i] = -1;
	           }else{
	        	   //replacing the value on top of stack using the current element
	               long current = arr[i];
	               arr[i] = stack.peek();
	               stack.push(current);
	           }
	           
	      }
	      return arr;	
	    } 
	}

}
