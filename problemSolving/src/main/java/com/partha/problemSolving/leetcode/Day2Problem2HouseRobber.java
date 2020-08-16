package com.partha.problemSolving.leetcode;

/**
 * leetcode : https://leetcode.com/problems/house-robber/
 * @author biswaspa
 *
 */
public class Day2Problem2HouseRobber {

	public static void main(String[] args) {
		int[] arr = new int[] {10,3,2,6,7};
		
		System.out.println(new Solution1().rob(arr));
	}

	/**
	 * timecomplexity = O(n)
	 * spacecomplexity = O(n)
	 * @param nums
	 * @return
	 */
	static class Solution1 {
	    public int rob(int[] nums) {
			if(nums.length==0) {
				return 0;
			}else if(nums.length==1){
				return nums[0]; 
			}else if (nums.length==2) {
				return (nums[0]>=nums[1]) ? nums[0] : nums[1];
			}else {
				int[] result= new int[nums.length];
				result[0]=nums[0];
				result[1]= Math.max(nums[0],nums[1]);
				for(int i=2 ; i<nums.length; i++) {
					result[i] = Math.max(nums[i] + result[i-2] , result[i-1] );    
				}
				return result[result.length-1];
			}
		}
	}

}
