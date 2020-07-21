package com.partha.problemSolving.leetcode;

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
	    	   result[1]= nums[1];
	       }
	       for(int i=2 ; i<nums.length; i++) {
	    	   result[i] = (result[i-1] >= (nums[i] + result[i-2]) )?  result[i-1] : (nums[i] + result[i-2]) ;
	       }
	       return result[nums.length-1];
	    }

}
