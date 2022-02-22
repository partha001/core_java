package com.partha.problemSolving.leetcode;

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
	
	
	
	
	private static class  Solution2 {
	    public int maxProduct(int[] nums) {
	        int mpp=nums[0]; // mpp: maximum Positive Product
	         int mnp=nums[0]; // mnp: Minimum Negative Product
	         int omax=nums[0]; // overall maximum Product
	         
	         
	         for(int i=1;i<nums.length;i++){
	             
	             int val=nums[i];
	             if(val<0){
	            	 //if currentVal is -ve then swapping values
	                 int temp1=mnp;
	                 int temp2=mpp;
	               mpp=Math.max(val,val*temp1);
	               mnp=Math.min(val,val*temp2);    
	             }else{
	            	 //if current val is positive then no swapping
	                mpp=Math.max(val,val*mpp);
	                mnp=Math.min(val,val*mnp); 
	             }
	             omax=Math.max(mpp,omax);
	             
	         }
	         
	         return omax;
	     }
	 }
	
	

}
