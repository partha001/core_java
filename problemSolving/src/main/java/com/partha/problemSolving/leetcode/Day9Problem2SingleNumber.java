package com.partha.problemSolving.leetcode;

/**
 * link : https://leetcode.com/problems/single-number/
 * @author biswaspa
 *
 */
public class Day9Problem2SingleNumber {

	public static void main(String[] args) {
		System.out.println(new Solution1().singleNumber(new int[]{10,20,30,20,10}));
	}
	
	
	/**
	 * O(n)
	 * @author biswaspa
	 *
	 */
	static class Solution1 {

		 public int singleNumber(int[] nums) {
			 int res = nums[0]; 
				for (int i = 1; i < nums.length; i++) 
					res = res ^ nums[i]; 
				return res; 
		  }
	}
	
	
	
	

}
