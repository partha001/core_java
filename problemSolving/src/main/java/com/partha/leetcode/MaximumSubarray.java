package com.partha.leetcode;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * @author partha
 *
 */
public class MaximumSubarray {

	public static void main(String[] args) {

	}


	public int maxSubArray(int[] nums) {
		if(nums.length==0)
			return 0;

		int[] dp = new int[nums.length]; //contains max sum till ith element
		dp[0] = nums[0];
		int result = dp[0]; //contains overall max
		for(int i=1;i<nums.length;i++){
			dp[i] = Math.max( nums[i] , dp[i-1]+ nums[i]);
			result = Math.max(result, dp[i]);
		}
		return result;
	}
	
	
	
	//using kadane's algo to get rid of the dp array
	private static class Solution2 {
		public int maxSubArray(int[] nums) {

			int maxEndingHere = nums[0];
			int maxSoFar = nums[0];

			for (int i = 1; i < nums.length; i++) {
				int x = nums[i];
				maxEndingHere = Math.max(x, maxEndingHere + x);
				maxSoFar = Math.max(maxSoFar, maxEndingHere);
			}

			return maxSoFar;

		}
	}
}





