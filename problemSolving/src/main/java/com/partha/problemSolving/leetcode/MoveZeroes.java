package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/move-zeroes/
 * @author biswaspa
 *
 */
public class MoveZeroes {

	public static void main(String[] args) {

	}
	
	private static class Solution {
	    public void moveZeroes(int[] nums) {
	        if(nums.length<=1)
	            return;
	        
	        int i=0;
	        for(int m=0;m<nums.length;m++){
	           if(nums[m]!=0){
	               nums[i] = nums[m];
	               i++;
	           }
	        }
	        
	        
	        while(i<nums.length){
	            nums[i++]=0;
	        }              
	    }
	}
	
	
	/**
	 * its the same code written little differently using 'continue'. this has same runtime but takes lesser memory
	 * @author partha
	 *
	 */
	private static class Solution2 {
	    public void moveZeroes(int[] nums) {
	        int last = 0;
	        for(int i=0;i<nums.length;i++){
	            if(nums[i]==0)
	                continue;
	            nums[last] = nums[i];
	            last++;
	        }
	        
	        while(last<nums.length){
	            nums[last++]=0;
	        }
	    }
	}

}
