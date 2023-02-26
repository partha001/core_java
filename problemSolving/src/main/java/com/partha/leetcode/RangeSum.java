package com.partha.leetcode;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 * @author partha
 *
 */
public class RangeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * naive solution . calculates the sum every time.
	 * @author partha
	 *
	 */
	class NumArray1 {

	    int[] nums;

	    public NumArray1(int[] nums) {
	        this.nums = nums;
	    }
	    
	    public int sumRange(int left, int right) {
	        if(left<=0)
	            left=0;
	        if(right>=nums.length)
	            right = nums.length-1;
	        int sum=0;
	        for(int i=left;i<=right;i++)
	             sum+= nums[i];

	        return sum;
	    }
	}


	
	/**
	 * precalculates the prefix sum and stores it.
	 * practice this
	 * @author partha
	 *
	 */
	class NumArray2 {
	    int prefixArray[] = null;
	    public NumArray2(int[] nums) {
	        int sum = 0; int n = nums.length;
	        prefixArray = new int[n];
	        for(int i = 0;i<n;i++){
	            sum+=nums[i];
	            prefixArray[i] = sum;
	        }
	    }
	    
	    public int sumRange(int left, int right) {
	        if(left>0) return (prefixArray[right]-prefixArray[left-1]);
	         return prefixArray[right];
	    }
	}



}
