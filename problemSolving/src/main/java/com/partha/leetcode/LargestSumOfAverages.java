package com.partha.leetcode;

/**
 * https://leetcode.com/problems/largest-sum-of-averages
 * @author partha
 *
 */
public class LargestSumOfAverages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	/**
	 * 
	 * @author partha
	 *
	 */
	class Solution {
		double ans = 0;
		public double largestSumOfAverages(int[] nums, int k) {
			return solve(nums,0,k,new double[nums.length][k+1]);
		}

		public double solve(int[] nums,int idx,int k,double[][] dp){
			if(k == 1){
				double sum = 0;
				for(int i=idx;i<nums.length;i++){
					sum += nums[i];
				}
				return sum/(nums.length - idx);
			}

			if(dp[idx][k] != 0){
				return dp[idx][k];
			}

			double max = 0;
			for(int i=idx;i<nums.length;i++){
				double avg = 0;
				for(int j=idx;j<i+1;j++){
					avg += nums[j];
				}
				avg = avg / (i + 1 - idx);
				if(i+1<nums.length && k>1){
					double v = solve(nums,i+1,k-1,dp);
					max = Math.max(max,avg+v);
				}
			}
			return dp[idx][k] = max;
		}

	}

}
