package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/move-zeroes/
 * @author biswaspa
 *
 */
public class MoveZeroes {

	public static void main(String[] args) {

	}
	
	static class Solution1 {
		
		public void moveZeroes(int[] nums) {
	        int pointer1=0;
	        for(int a=0;a<nums.length;a++){
	            if(nums[a]!=0){
	                nums[pointer1] = nums[a];
	                pointer1++;
	            }
	        }
	        
	        for(int i=pointer1;i<nums.length;i++){
	            nums[i]=0;
	        }
	    }
	}

}
