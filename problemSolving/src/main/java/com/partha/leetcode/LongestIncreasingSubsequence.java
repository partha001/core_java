package com.partha.leetcode;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * @author biswaspa
 *
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * /Time: O(n2) space: O(n)
	 * @author biswaspa
	 *
	 */
	private static class Solution {
	    public int lengthOfLIS(int[] nums) {
	     if(nums.length == 0){ // case 1 
	            return 0;
	        }
	        
	        if(nums.length == 1){ // case 2
	            return 1;
	        }
	        
	        int dp[] = new int[nums.length];
	        
	        for(int i = 0;i<nums.length;i++){
	            dp[i] = 1;
	        }
	        int max = 0;
	        
	        for(int i = 1;i<nums.length;i++){
	            for(int j = 0;j<i;j++){
	                if(nums[j]<nums[i] && dp[j]+1 > dp[i]){
	                    dp[i] = dp[j] + 1;
	                }
	            }
	        }
	        
	        for(int i = 0;i<dp.length;i++){
	            if(dp[i] > max){
	                max = dp[i];
	            }
	        }
	        
	        return max;
	        
	    }
	}

}
