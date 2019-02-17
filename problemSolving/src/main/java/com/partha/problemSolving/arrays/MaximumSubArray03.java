package com.partha.problemSolving.arrays;

/**
 * @description: here are using devide-and-conquer approach. i.e. 
 * @complexity : O(n log n) . recursively calling itself . the time-complexity is much like merge-sort complexity calculation
 * @author partha
 * @link : https://www.youtube.com/watch?v=ohHWQf1HDfU&vl=en
 *
 */
public class MaximumSubArray03 {

	public static void main(String[] args) {
		int[] arr= new int[]{-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maximumSubArray(arr, arr.length));
	}
	
	/**
	 * this method prints the maximum subarray sum
	 * 
	 * @param arr : input array
	 * @param n : size of the input array
	 */
	public static int maximumSubArray(int arr[], int n){
		
		int result = Integer.MIN_VALUE;
		
		//loop for iterating over the start indexes
		for(int startIndex=0;startIndex < n ; startIndex++){
			
			int subArraySum =0;
			//loop for iterating every subarray sizes
			for(int subarraySize=1; subarraySize<=n;subarraySize++){
				
				//the below condition is avoid out of bound array index
				if(startIndex+ subarraySize> n)
					break;
				subArraySum = subArraySum +arr[startIndex + subarraySize -1];
				result = result < subArraySum ? subArraySum : result ;
			}		
		}
		
		return result;
	}

}
