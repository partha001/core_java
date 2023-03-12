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
	
	/**
	 * same algo as find peak element
	 * @author partha
	 *
	 */
	private static class Solution1 {
	    public int peakIndexInMountainArray(int[] arr) {
	        int start = 0;
	        int end =  arr.length - 1;
	        while(start < end){
	            int mid = (start + end)/2;
	            if(arr[mid] > arr[mid+1] ){
	                //we are in dec part of the array
	                end = mid;
	            }
	            else{//we are in inc part of array
	                start = mid + 1;
	            }
	        }
	        return start;
	    }
	}

}
