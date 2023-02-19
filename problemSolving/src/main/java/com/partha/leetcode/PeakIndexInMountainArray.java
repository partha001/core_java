package com.partha.leetcode;

/**
 * https://leetcode.com/problems/peak-index-in-a-mountain-array
 * @author biswaspa
 *
 */
public class PeakIndexInMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	private static class Solution {
	    public int peakIndexInMountainArray(int[] arr) {
	        int left = 0;
	        int right = arr.length-1;
	        while(left<right){
	            int mid =( left + right)/2;
	            if(arr[mid]<arr[mid+1]){
	                left = mid +1;
	            }else{
	                right = mid;
	            }
	        }
	        return right;
	    }
	}

}
