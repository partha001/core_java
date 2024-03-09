package com.partha.leetcode;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i/
 * @author partha
 *
 */
public class MaximumAverageSubarray1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * TC: O(n), SC: O(1)
	 * @author partha
	 *
	 */
	private static class Solution {
	    public double findMaxAverage(int[] nums, int k) {
	        double currSum = 0;

	        for (int i = 0; i < k; i++) {
	            currSum += nums[i];
	        }

	        double max = currSum;
	        int l = 0, r = k;

	        while (r < nums.length) {
	            currSum += nums[r++] - nums[l++];
	            max = Math.max(max, currSum);
	        }

	        return max / k;
	    }
	}
	
	//same algo but written in differeent way.
	private static class Solution2 {
	    public double findMaxAverage(int[] nums, int k) {
	        int n = nums.length;
	        int currentSum = 0;
	        int maxSum = Integer.MIN_VALUE;
	        for(int i=0;i<nums.length;i++){
	            if(i<k-1){
	                currentSum += nums[i];
	            }else if(i==k-1){
	                currentSum += nums[i];
	                maxSum = Math.max(maxSum, currentSum);
	            }else{
	                currentSum += -nums[i-k] + nums[i];
	                maxSum = Math.max(maxSum, currentSum);
	            }
	        }
	        return (double)maxSum/k;
	    }
	}


}
