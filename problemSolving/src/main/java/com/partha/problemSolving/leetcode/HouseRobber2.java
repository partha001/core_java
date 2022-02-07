package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/house-robber-ii/
 * @author biswaspa
 *
 */
public class HouseRobber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private static class Solution {
	    public int rob(int[] nums) {
	        
	        if(nums.length == 1)
	            return nums[0];
	        if(nums.length == 2)
	            return Math.max(nums[0],nums[1]);
	        if(nums.length == 3)
	            return Math.max(Math.max(nums[0],nums[1]),Math.max(nums[1],nums[2]));
	       
	        int x = robLogic(nums,0,nums.length-2);
	        int y = robLogic(nums,1,nums.length-1);
	        return Math.max(x,y);
	    }
	    
	    
	    private int robLogic(int[] nums, int st, int end){
	        int even = 0,odd = 0;
	        
	        for(int i = st;i<=end;i++){
	            if(i % 2 == 0){
	                even = even + nums[i];
	                even = Math.max(even,odd);
	            }else{
	                 odd = odd + nums[i];
	                 odd = Math.max(even,odd);
	            }
	        }
	        return Math.max(even,odd);
	    }
	}

}
