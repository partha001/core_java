package com.partha.problemSolving.leetcode;

import java.util.Stack;

public class DaillyTemperatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * brute force : timeComplexity : O(nxn)  spaceComplexity:O(1)
	 * @author biswaspa
	 *
	 */
	static class Solution {
	    public int[] dailyTemperatures(int[] T) {
	        int size = T.length;
	        int[] result = new int[size];
	        if(size<=1)
	            return result;
	        
	        for(int i=0;i<size-1;i++){
	            
	            for(int j=i+1;j<size;j++){
	                if(T[i]<T[j]){
	                    result[i]=j-i;
	                    break;
	                }
	                    
	            }
	        }
	        return result;
	    }
	}
	
	
	static class Solution2 {
	    public int[] dailyTemperatures(int[] T) {
	        int n = T.length;
	        int [] listOfTemp = new int [n];
	        Stack<Integer> stack = new Stack<>();
	        for (int i=n-1; i>=0; i--) {
	            while (!stack.isEmpty() && T[i] >= T[stack.peek()])
	                stack.pop();
	            listOfTemp[i] = stack.isEmpty() ? 0 : stack.peek() - i;
	            stack.push(i);
	        }
	        return listOfTemp;
	    }
	}

}
