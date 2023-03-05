package com.partha.leetcode;

/**
 * https://leetcode.com/problems/non-decreasing-array/
 * @author partha
 *
 */
public class NonDecreasingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * TC O(n)
	 * SC O(1)
	 * @author partha
	 *
	 */
	private static class Solution {

		public boolean checkPossibility(int[] nums) {
			boolean modify = false;
			for(int i=0; i<nums.length-1; i++){
				if(nums[i] <= nums[i+1]) 
					continue;
				if(modify) 
					return false;
				modify = true;
				if(i == 0) 
					nums[i] = nums[i+1];
				else{
					if(nums[i-1] <= nums[i+1]) 
						nums[i] = nums[i-1];
					else 
						nums[i+1] = nums[i];
				}
			}
			return true;
		}
	}


	/**
	 * TC O(n)
	 * SC O(1)
	 * @author partha
	 *
	 */
	private static class Solution2{
		public boolean checkPossibility(int[] nums) {
			for (int i=1, modified=0; i<nums.length; i++) {
				if (nums[i-1] > nums[i]) {
					if (modified++ == 1) return false;
					if (i<2 || nums[i-2] <= nums[i]) nums[i-1] = nums[i];
					else nums[i] = nums[i-1];
				}
			}
			return true;
		}
	}

}
