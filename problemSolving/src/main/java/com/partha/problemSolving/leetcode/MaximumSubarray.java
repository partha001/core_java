package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * @author partha
 *
 */
public class MaximumSubarray {

	public static void main(String[] args) {

	}
	
	private static class Solution1 {
	    public int maxSubArray(int[] nums) {
	        if(nums.length==0)
	            return 0;
	        
	        int[] dp = new int[nums.length];
	        dp[0] = nums[0];
	        int result = dp[0];
	        for(int i=1;i<nums.length;i++){
	            dp[i] = Math.max( nums[i] , dp[i-1]+ nums[i]);
	            result = Math.max(result, dp[i]);
	        }
	        return result;
	    }
	}

}
