package com.partha.leetcode;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * @author biswaspa
 *
 */
public class ProductOfArraysExceptSelf {

	public static void main(String[] args) {

	}
	
	private static class Solution1 {
	    public int[] productExceptSelf(int[] nums) {
	        int[] result = new int[nums.length];
	        int leftProduct=1;
	        int rightProduct=1;
	        for(int i=0;i<nums.length;i++){
	            result[i] = leftProduct;
	            leftProduct = leftProduct * nums[i];
	        }


	        for(int i=nums.length-1;i>=0;i--){
	            result[i] = result[i]* rightProduct;
	            rightProduct = rightProduct * nums[i];
	        }

	        return result;

	    }
	}

	
}
