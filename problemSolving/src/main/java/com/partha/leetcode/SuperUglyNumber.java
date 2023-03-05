package com.partha.leetcode;

/**
 * https://leetcode.com/problems/super-ugly-number/
 * @author partha
 *
 */
public class SuperUglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * using dp
	 * @author partha
	 *
	 */
	private static class Solution {
	    public int nthSuperUglyNumber(int n, int[] primes) {
	       long dp[] = new long[n+1];
	        int pointers[] = new int[primes.length];
	        dp[0] = 1;
	        for(int i =1;i<dp.length;i++){
	            dp[i] = Integer.MAX_VALUE;
	            for(int j =0;j<primes.length;j++){
	                dp[i] = Math.min(dp[i],dp[pointers[j]]*primes[j]);
	            }
	            for(int j =0;j<primes.length;j++){
	                if(dp[i] == dp[pointers[j]]*primes[j]){
	                    pointers[j]++;
	                }
	            }
	        }
	        return (int)dp[n-1];
	    }
	}

}
