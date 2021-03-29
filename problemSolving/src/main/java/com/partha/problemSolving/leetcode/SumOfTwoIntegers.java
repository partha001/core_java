package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/sum-of-two-integers/
 * @author partha
 *
 */
public class SumOfTwoIntegers {
	
	public static void main(String[] args) {
		
	}
	

	private static class Solution {
	    public int getSum(int a, int b) {
	         int ans = 0, carry = 0;
	    
	    while(b != 0){
	        ans = a ^ b;
	        carry = (a & b) << 1;
	        
	        a = ans;
	        b = carry;
	    }
	    
	    return a;
	    }
	}

}
