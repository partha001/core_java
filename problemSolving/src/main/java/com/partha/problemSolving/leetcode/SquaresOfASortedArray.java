package com.partha.problemSolving.leetcode;


/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * @author partha
 *
 */
public class SquaresOfASortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static class Solution {
	    public int[] sortedSquares(int[] nums) {
	       int[] result = new int[nums.length];
	        int start=0;
	        int end=nums.length-1;
	        for(int i=nums.length-1;i>=0;i--){
	            if(Math.abs(nums[start])> Math.abs(nums[end])){
	                result[i] = nums[start] * nums[start];
	                start++;
	            }else{
	                result[i] = nums[end] * nums[end];
	                end--;
	            }
	        }
	        return result;
	    }
	}

}
