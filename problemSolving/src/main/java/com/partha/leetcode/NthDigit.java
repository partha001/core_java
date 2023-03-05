package com.partha.leetcode;

/**
 * https://leetcode.com/problems/nth-digit
 * @author partha
 *
 */
public class NthDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * TC O(logn)
	 * SC O(1)
	 * @author partha
	 *
	 */
	private static class Solution {
	    public int findNthDigit(int n) {
	        int count = 1;
	        long end = 9;
	        long start = 1;
	        boolean flag = false;
	        while(!flag) {
	            if((end - start + 1) * count > n) flag = true;
	            else {
	                n -= ((end - start + 1) * count);
	                end = end*10 + 9;
	                count++;
	                start *= 10;
	            }
	        }
	        int nextRem = n % count;
	        long targetValue = start + n / count - 1;
	        if(nextRem != 0) {
	            targetValue++;
	            nextRem = count - nextRem;
	            while(nextRem != 0) {
	                targetValue /= 10;
	                nextRem--;
	            } 
	        }
	        return (int)targetValue % 10;
	    }
	}
	
}
