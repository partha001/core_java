package com.partha.leetcode;

import java.util.Stack;

/**
 * @source : https://leetcode.com/problems/daily-temperatures/submissions/
 * @author biswaspa
 *
 */
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
	
	
	/**
	 * note1: that the stack is used to store the index of the next greater element and not actual temperature value.
	 * 
	 * thus when stack is not empty we find the difference between stack.peek() - currentIndex = difference of days
	 * @author partha
	 *
	 */
	static class Solution2 {
	    public int[] dailyTemperatures(int[] T) {
	        int n = T.length;
	        int [] listOfTemp = new int [n];
	        //note stack does not contain temperature but the index
	        Stack<Integer> stack = new Stack<>();
	        for (int i=n-1; i>=0; i--) {
	            while (!stack.isEmpty() && T[i] >= T[stack.peek()])
	                stack.pop();
	            listOfTemp[i] = stack.isEmpty() ? 0 : stack.peek() - i; //finding difference of days
	            stack.push(i);
	        }
	        return listOfTemp;
	    }
	}

}
