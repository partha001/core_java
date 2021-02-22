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
			if(nums.length<=1 ) {
				//do nothing
			}else {
				if(nums.length==k) {
					//do nothing 
				}else {
					int[] result = new int[nums.length];
					for(int i=0;i<k;i++) {
						result[i]= nums[nums.length-k+i];
					}
					
					for(int i=0;i<nums.length-k;i++) {
						result[k+i] = nums[i];
					}
					
					nums = result ;
										
				}
			}
	    }
	}


}
