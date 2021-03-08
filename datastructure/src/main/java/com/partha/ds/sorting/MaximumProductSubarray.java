package com.partha.ds.sorting;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * @author biswaspa
 *
 */
public class MaximumProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * this is the bactracking approach. this does dfs against every element.
	 * thus there are lot of recalculations.  hence its not a good solution
	 * @author biswaspa
	 *
	 */
	private static class Solution1 {
	    
	    int max = Integer.MIN_VALUE;
	    
	     public int maxProduct(int[] nums) {
	         if (nums.length == 0)
	             return 0;
	        
	        
	         for (int i=0;i<nums.length;i++){
	             int res = 1;
	             dfs(nums,res, i);
	         }
	         return max;
	     }
	    
	     protected void dfs(int[] nums, int product, int index){
	         if (index > nums.length-1)
	             return;
	         product = product * nums[index];
	         max  = Math.max(max, product);
	         dfs(nums, product, index+1);    
	     }
	}
	
	
	/**
	 * 
	 */

}
