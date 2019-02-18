package com.partha.problemSolving.arrays;

/**
 * @description: dynamic programming 
 * @comments : kadane's algorithm also has the same complexity but has an assumption.
 *  			however this algorithm works fine for all values
 * @complexity : O(n ) . 
 * @author partha
 * @link : https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 *
 */
public class MaximumSubArraySum04 {

	public static void main(String[] args) {
		int[] arr= new int[]{-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSumSubarraySum(arr, arr.length));
	}

	public static int maxSumSubarraySum(int[] arr,int n){
		int result = 0;
		int sum = 0;
		
		for(int i=0;i<n;i++){
			if(sum + arr[i]>0)
				sum = sum + arr[i];
			else
				sum =0;
			result = result > sum ? result : sum;
		}		
		return result;
	}


}
