package com.partha.leetcode;

/**
 * link : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * @author biswaspa
 *
 */
public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {

	}
	
	
	class Solution {
	    public int removeDuplicates(int[] nums) {
	    	if(nums.length<=1) return nums.length; //edge case
	    	
	        int latest = 0;
	        for(int i=1;i<nums.length;i++){
	            if(nums[i]== nums[latest])
	                continue;
	            nums[++latest] = nums[i];
	        }
	        return latest+1;
	    }
	}
	

}
