package com.partha.arrays;

/**
 * @description: kadane's algorithm 
 * @assumption : there is at least one positive element
 * @complexity : O(n ) . 
 * @author partha
 * @link : https://www.youtube.com/watch?v=ohHWQf1HDfU&vl=en
 *
 */
public class MaximumSubArraySum05 {

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
