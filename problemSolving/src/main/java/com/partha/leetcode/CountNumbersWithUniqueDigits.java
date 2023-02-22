package com.partha.leetcode;

/**
 * https://leetcode.com/problems/remove-duplicate-letters
 * @author partha
 *
 */
public class CountNumbersWithUniqueDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * https://www.youtube.com/watch?v=nrDNGVW59c8
	 * @author partha
	 *
	 */
	private static class Solution {
	    public int countNumbersWithUniqueDigits(int n) {
	        if(n==0)
	            return 1;
	        
	        int ans =10;
	        int start = 9;
	        int current = 9;
	        while(n>1 ){
	            current *= (start--);
	            ans += current;
	            n--;
	        }
	        return ans;
	    }
	}

}
