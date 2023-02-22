package com.partha.leetcode;

/**
 * https://leetcode.com/problems/find-peak-element
 * @author partha
 *
 */
public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private static class Solution {
	    public int findPeakElement(int[] arr) {
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
