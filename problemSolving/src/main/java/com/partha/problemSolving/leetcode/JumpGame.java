package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/jump-game/
 * @author partha
 *
 */
public class JumpGame {

	public static void main(String[] args) {

	}
	
	private static class Solution {
	    public boolean canJump(int[] nums) {
	        if(nums[0] == 0 && nums.length == 1){
	            return true;
	        }
	        
	       int max = nums[0];
	       for(int i = 1;i<nums.length;i++){
	           if( i > max){
	               return false;
	           }
	           if(i+nums[i] > max){
	               max = i + nums[i];
	           }
	       }
	      return true;
	    }
	}

}


