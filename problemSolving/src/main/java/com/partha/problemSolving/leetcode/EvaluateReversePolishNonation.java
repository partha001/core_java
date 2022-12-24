package com.partha.problemSolving.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * @author partha
 *
 */
public class EvaluateReversePolishNonation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * TC: O(n)
	 * MC: O(n)
	 * @author partha
	 *
	 */
	private static class Solution {
	    public int evalRPN(String[] tokens) {
	        int i=0;
	        Stack<Integer> stack = new Stack();
	        while(i<tokens.length){
	            String current = tokens[i];
	            if(current.equals("+") || current.equals("-") || current.equals("*") || current.equals("/")){
	                int digit1 = stack.pop();
	                int digit2 = stack.pop();
	                int result = performOperation(digit1, digit2, current);
	                stack.push(result);
	            }else{
	                stack.push(Integer.parseInt(current));
	            }
	            i++;
	        }

	        return stack.pop().intValue();
	    }

	    private int performOperation(int digit1, int digit2, String operation){
	        if(operation.equals("+") )
	            return digit2 + digit1;
	        
	        if(operation.equals("-"))
	            return digit2 - digit1;
	        
	        if(operation.equals("/"))
	            return digit2 / digit1;

	        if(operation.equals("*"))
	            return digit2 * digit1;

	        throw new RuntimeException("not a valid operation");
	        
	    }
	}

}
