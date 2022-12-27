package com.partha.arrays;

/**
 * @description: dynamic programming 
 * @comments : kadane's algorithm also has the same complexity but has an assumption
 * [i.e. there is one positive value]
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
		int result = arr[0];
		int sum = arr[0];

		for(int i=1;i<arr.length;i++){
			if(sum + arr[i] > arr[i]){
				sum = sum + arr[i];
			}else{
				sum = arr[i];
			}
			result = Math.max(sum,result);
		}		
		return result;
	}


}
