package com.partha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/burst-balloons/
 * @author biswaspa
 *
 */
public class BurstBalloons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	/**
	 * https://www.youtube.com/watch?v=VFskby7lUbw
	 * @author partha
	 * this is the recursive approach
	 */
	
	private static class Solution1 {
		
		  public int maxCoins(int[] nums) {
				int n = nums.length;
				int[][] dp = new int[n+1][n+1];  //creating the dp array
				for(int i = 0 ; i <= n ; i++) 
					Arrays.fill(dp[i], -1); //filling each row with default -1

				//creating a copy of input array and copying values from initial array
				int[] arr = new int[n+2]; 
				arr[0] = arr[n+1] = 1;
				for(int i = 0 ; i < n ; i++)
		            arr[i+1] = nums[i];

				return dfs(arr , 1 , n , dp);
			}

			int dfs(int[] arr , int left , int right , int[][] dp){
				if(left > right)   //baseCase1: if invalid bounds
					return 0;

				if(dp[left][right] != -1)  //baseCase2: if value is already cached
					return dp[left][right];

				for(int k = left ; k <= right ; k++)
				{
					int leftResult =  dfs(arr , left , k-1 , dp);
					int rightResult = dfs(arr , k+1 , right , dp);
					dp[left][right] = (int)Math.max(dp[left][right] , arr[left-1]*arr[right+1]*arr[k] + leftResult + rightResult);
				}

				return dp[left][right];
			}
	}


	//same algo as LeetcodeOfficialSolution1  written in crisp way
	private static class Solution2 {
		public int maxCoins(int[] nums) {
			int[] dummy_num = new int[nums.length + 2];
			dummy_num[0] = dummy_num[dummy_num.length - 1] = 1;
			for(int i = 1;i <= nums.length;i ++)
				dummy_num[i] = nums[i - 1];
			int[][] dp = new int[dummy_num.length][dummy_num.length];
			for (int i = dummy_num.length - 3; i >= 0; i --) {
				for (int j = i + 2; j < dummy_num.length;j ++) {
					for (int k = i + 1; k < j; k ++)
						dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + dummy_num[i] * dummy_num[k] * dummy_num[j]);
				}
			}
			return dp[0][dummy_num.length - 1];
		}
	}

	/**
	 * @approach: Bottom up dp
	 * @source : leetcode official solution
	 * @TC O(N^3)
	 * @SC O(N^2)
	 * @author biswaspa
	 *
	 */
	private static class LeetcodeOfficialSolution1 {
		public int maxCoins(int[] nums) {
			// add 1 before and after nums
			int n = nums.length + 2;
			int[] newNums = new int[n];
			System.arraycopy(nums, 0, newNums, 1, n - 2);
			newNums[0] = 1;
			newNums[n - 1] = 1;
			// dp[i][j] represents
			// maximum if we burst all nums[left]...nums[right], inclusive
			int[][] dp = new int[n][n];
			// do not include the first one and the last one
			// since they are both fake balloons added by ourselves and we can not burst
			// them
			for (int left = n - 2; left >= 1; left--) {
				for (int right = left; right <= n - 2; right++) {
					// find the last burst one in newNums[left]...newNums[right]
					for (int i = left; i <= right; i++) {
						// newNums[i] is the last burst one
						int gain = newNums[left - 1] * newNums[i] * newNums[right + 1];
						// recursively call left side and right side
						int remaining = dp[left][i - 1] + dp[i + 1][right];
						// update
						dp[left][right] = Math.max(remaining + gain, dp[left][right]);
					}
				}
			}
			// burst newNums[1]...newNums[n-2], excluding the first one and the last one
			return dp[1][n - 2];
		}
	}

}
