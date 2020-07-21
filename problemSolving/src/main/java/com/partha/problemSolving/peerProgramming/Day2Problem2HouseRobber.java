package com.partha.problemSolving.peerProgramming;

/**
 * leetcode : https://leetcode.com/problems/house-robber/
 * @author biswaspa
 *
 */
public class Day2Problem2HouseRobber {

	public static void main(String[] args) {
		System.out.println(rob(new int[] {10,3,2,6,7}));
	}
	
	 public static int rob(int[] nums) {
		 int[] result= new int[nums.length];
	       if(nums.length>=1) {
	    	   result[0]=nums[0];
	       }if(nums.length>=2) {
	    	   result[1]= (nums[0]>=nums[1] )? nums[0] : nums[1];
	       }if(nums.length>=3) {
	    	   result[2]= (nums[0]+nums[2] >= nums[1] ) ? nums[0]+nums[2] : nums[2];
	       }
	       for(int i=3 ; i<nums.length; i++) {
	    	   
	       }
	       return result[nums.length-1];
	    }

}
