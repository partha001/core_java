package com.partha.problemSolving.leetcode;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * @author biswaspa
 *
 */
public class ProductOfArraysExceptSelf {

	public static void main(String[] args) {

	}
	
	class Solution {
	    public int[] productExceptSelf(int[] nums) {
	    int[] result = new int[nums.length];
	    int left = 1, right = 1;
	    //The left side nums' product
	    for (int i = 0; i < nums.length; i++) {
	      result[i] = left;
	      left *= nums[i];
	    }
	    //The right side nums' product
	    for (int i = nums.length - 1; i >= 0; i--) {
	      result[i] *= right;
	      right *= nums[i];
	    }
	    return result;
	  }
	}

}
