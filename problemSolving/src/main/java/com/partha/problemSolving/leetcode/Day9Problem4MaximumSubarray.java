package com.partha.problemSolving.leetcode;

public class Day9Problem4MaximumSubarray {
	
	public static void main(String[] args) {
		new Solution1().merge(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3);
	}
	
	static class Solution1 {
	    public void merge(int[] nums1, int m, int[] nums2, int n) {
	        int[] arr = new int[nums1.length];
	        int i=0;
	        int j=0;
	        int k=0;
	        while(j<n){
	            if(nums1[i] <= nums2[j] && nums1[i]!=0){
	                arr[k]=nums1[i];
	                i++;
	            }else{
	                arr[k]= nums2[j];
	                j++;
	            }
	            k++;
	        }
	        
	        while(k<nums1.length){
	            arr[k]=nums1[i];
	            k++;
	            i++;
	        }
	        
	        nums1=arr;
	        
	    }
	}

}
