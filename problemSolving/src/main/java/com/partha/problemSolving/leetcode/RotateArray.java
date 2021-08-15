package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/rotate-array/
 * @author biswaspa
 *
 */
public class RotateArray {

	public static void main(String[] args) {
		new Solution1().rotate(new int[] {10,11,12},1);
	}

	static class Solution1 {
		
		public void rotate(int[] nums, int k) {
			int[] a = new int[nums.length];
		    for (int i = 0; i < nums.length; i++) {
		      a[(i + k) % nums.length] = nums[i];
		    }
		    for (int i = 0; i < nums.length; i++) {
		      nums[i] = a[i];
		    }
		}
	}


}
