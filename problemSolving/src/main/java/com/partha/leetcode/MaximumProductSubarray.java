package com.partha.leetcode;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * @author partha
 *
 */
public class MaximumProductSubarray {
	
	public static void main(String[] args) {
		
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
	
	
	
	
	private static class Solution {
		
	    public int maxProduct(int[] nums) {
	    	// it is important to initialize the below 3 variables with nums[0] and not 1.
	    	// and then run the loop from index 1.
	        int minProduct = nums[0];
	        int maxProduct = nums[0];
	        int max = nums[0];
	        
	        for(int i=1;i<nums.length;i++){
	            int current = nums[i];
	            if(current<0){
	                //if current in -ve then swappng values
	                int temp1 = minProduct; 
	                int temp2 = maxProduct;
	                maxProduct = Math.max(current, current * temp1);
	                minProduct = Math.min(current, current * temp2);
	                
	            }else{
	               maxProduct = Math.max(current, current * maxProduct);
	               minProduct = Math.min(current, current * minProduct);
	            }
	            max = Math.max(maxProduct,max);
	        }
	        return max;
	    }
	}
	
	

}
